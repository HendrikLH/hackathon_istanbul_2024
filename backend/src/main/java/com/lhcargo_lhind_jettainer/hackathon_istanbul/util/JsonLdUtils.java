package com.lhcargo_lhind_jettainer.hackathon_istanbul.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.jsonldjava.core.JsonLdOptions;
import com.github.jsonldjava.core.JsonLdProcessor;
import com.github.jsonldjava.utils.JsonUtils;
import com.lhcargo_lhind_jettainer.hackathon_istanbul.model.CARGO;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.*;

@Slf4j
public class JsonLdUtils {

    /**
     * Removes the @type field from any object in JSON-LD if the object only has @id
     * and @type
     * except of the root object
     * 
     * @param json
     * @return
     * @throws Exception
     */
    public static String removeNotRequiredTypesFromJsonLd(String json) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);

        removeTypeIfOnlyIdAndType(root, true);

        return mapper.writeValueAsString(root);
    }

    private static void removeTypeIfOnlyIdAndType(JsonNode node, boolean isRoot) {
        if (node.isObject()) {
            ObjectNode objectNode = (ObjectNode) node;
            boolean hasOnlyIdAndType = objectNode.has("@id") && objectNode.has("@type") && objectNode.size() == 2;

            if (hasOnlyIdAndType && !isRoot) {
                objectNode.remove("@type");
            } else {
                Iterator<Map.Entry<String, JsonNode>> fields = objectNode.fields();
                while (fields.hasNext()) {
                    Map.Entry<String, JsonNode> field = fields.next();
                    removeTypeIfOnlyIdAndType(field.getValue(), false);
                }
            }
        } else if (node.isArray()) {
            for (JsonNode arrayItem : node) {
                removeTypeIfOnlyIdAndType(arrayItem, false);
            }
        }
    }

    public static Set<JsonNode> extractResolvedNodesFromGraph(JsonNode originalNode) {
        return Set.of();
    }

    @SuppressWarnings("unchecked")
    public static JsonNode resolveGraphIfPresent(JsonNode originalNode, String rootId) {
        if (!originalNode.has("@graph") && !originalNode.has("@context")) {
            log.debug("No graph or context found in the json-ld, returning the original node as is.");
            return originalNode;
        }
        if (originalNode.has("@context")) {
            // seems like the json-ld is not compacted, compact it first by removing the
            // context
            // Compact with new context (if needed, otherwise use an empty map or null)
            // Your originalNode as a Map
            Map<String, Object> originalNodeMap;
            try {
                originalNodeMap = (Map<String, Object>) JsonUtils.fromString(originalNode.toString());
            } catch (IOException e) {
                log.error("Error while converting JsonNode to Map", e);
                return null;
            }

            Map<String, Object> context = new HashMap<>();
            JsonLdOptions options = new JsonLdOptions();

            // Perform compaction
            Map<String, Object> compacted = JsonLdProcessor.compact(originalNodeMap, context, options);

            // Convert compacted map to JsonNode using Jackson
            originalNode = new ObjectMapper().convertValue(compacted, JsonNode.class);
        }
        if (!originalNode.has("@graph")) {
            return originalNode;
        }        

        JsonNode rootNode = null;
        Map<String, JsonNode> nodesMap = new HashMap<>();
        JsonNode graph = originalNode.get("@graph");
        for (JsonNode graphNode : graph) {
            if (graphNode.has("@id") && graphNode.get("@id").asText().equals(rootId)) {
                rootNode = graphNode;
            }
            nodesMap.put(graphNode.get("@id").asText(), graphNode);
        }
        // start with rootNode, iterate through all children and replace @id with the
        // actual object, dont visit the same node twice
        if (rootNode == null) {
            log.warn("Root node with specified rootId not found in the graph.");
            return null;
        }

        Queue<JsonNode> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(rootNode);
        visited.add(rootId);
        while (!queue.isEmpty()) {
            JsonNode current = queue.remove();
            Iterator<String> fieldNames = current.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = current.get(fieldName);
                if (fieldValue.isArray()) {
                    ArrayNode updatedArray = JsonNodeFactory.instance.arrayNode();
                    for (JsonNode arrayElement : fieldValue) {
                        if (arrayElement.isObject() && arrayElement.has("@id")) {
                            String id = arrayElement.get("@id").asText();
                            if (nodesMap.containsKey(id) && !visited.contains(id)) {
                                updatedArray.add(nodesMap.get(id));
                                queue.add(nodesMap.get(id));
                                visited.add(id);
                            }
                        } else {
                            updatedArray.add(arrayElement);
                        }
                    }
                    ((ObjectNode) current).set(fieldName, updatedArray);
                } else if (fieldValue.isObject() && fieldValue.has("@id")) {
                    String id = fieldValue.get("@id").asText();
                    if (nodesMap.containsKey(id) && !visited.contains(id)) {
                        ((ObjectNode) current).set(fieldName, nodesMap.get(id));
                        queue.add(nodesMap.get(id));
                        visited.add(id);
                    }
                }
            }
        }
        return rootNode;
    }

    /**
     * This function is destructive and modifies the input JsonNode by adding the @type property to each object.
     * @param node
     * @param cargo
     */
/*    public static void enrichJsonWithTypes(JsonNode node, CARGO cargo) {
        assert node != null;
        assert cargo != null;
        // Check if the node is an array and process each element.
        if (node.isArray()) {
            for (JsonNode element : node) {
                enrichJsonWithTypes(element, cargo);
            }
        } else if (node.isObject()) { // If it's an object, process each field.
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.fieldNames().forEachRemaining(fieldName -> {
                JsonNode childNode = objectNode.get(fieldName);
                // Check and set the @type property for the node if it's an object.
                if (childNode.isObject() && !childNode.has("@type") && cargo.hasObjectProperty(fieldName)) {
                    String type = cargo.getObjectPropertyType(fieldName);
                    if (type != null) {
                        ((ObjectNode) childNode).put("@type", type);
                    }
                }
                // Recurse into arrays and objects.
                enrichJsonWithTypes(childNode, cargo);
            });
        }
        // Base case for primitives does nothing.
    }*/

      /**
     * This function is destructive and modifies the input JsonNode by adding the @type property to each object.
     * @param node
     * @param api
     */
    public static void enrichJsonWithTypes(JsonNode node, CARGO api) {
        assert node != null;
        assert api != null;
        // Check if the node is an array and process each element.
        if (node.isArray()) {
            for (JsonNode element : node) {
                enrichJsonWithTypes(element, api);
            }
        } else if (node.isObject()) { // If it's an object, process each field.
            ObjectNode objectNode = (ObjectNode) node;
            objectNode.fieldNames().forEachRemaining(fieldName -> {
                JsonNode childNode = objectNode.get(fieldName);
                // Check and set the @type property for the node if it's an object.
                if (childNode.isObject() && !childNode.has("@type") && api.hasObjectProperty(fieldName)) {
                    String type = api.getObjectPropertyType(fieldName);
                    if (type != null) {
                        ((ObjectNode) childNode).put("@type", type);
                    }
                }
                // Recurse into arrays and objects.
                enrichJsonWithTypes(childNode, api);
            });
        }
        // Base case for primitives does nothing.
    }



    /**
     * This function takes a JsonNode object, walks through it and extract all link values from @id fields if the object has more than @id and @property fields.
     * A link is somethink that starts with http:// or https://
     * Input node must be an object
     * @param node The JsonNode object to extract ids from.
     * @return A set of all ids found in the JsonNode object.
     */
    public static Set<String> extractLinkableIds(JsonNode node) {
        assert node != null;
        assert node.isObject();
        Set<String> ids = new HashSet<>();
        Queue<JsonNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            JsonNode current = queue.remove();
            Iterator<String> fieldNames = current.fieldNames();
            while (fieldNames.hasNext()) {
                String fieldName = fieldNames.next();
                JsonNode fieldValue = current.get(fieldName);
                if (fieldValue.isArray()) {
                    for (JsonNode arrayElement : fieldValue) {
                        if (arrayElement.isObject() && arrayElement.has("@id") && arrayElement.has("@type") && arrayElement.size() > 2) {
                            String id = arrayElement.get("@id").asText();
                            if (id.startsWith("http://") || id.startsWith("https://")) {
                                ids.add(id);
                            }
                            queue.add(arrayElement);
                        }
                    }
                } else if (fieldValue.isObject() && fieldValue.has("@id") && fieldValue.has("@type") && fieldValue.size() > 2) {
                    String id = fieldValue.get("@id").asText();
                    if (id.startsWith("http://") || id.startsWith("https://")) {
                        ids.add(id);
                    }
                    queue.add(fieldValue);
                } else if (fieldValue.isTextual() && fieldName.equals("@id") && fieldValue.asText().startsWith("http://") || fieldValue.asText().startsWith("https://")) {
                    ids.add(fieldValue.asText());
                }
            }
        }
        return ids;
    }
}
