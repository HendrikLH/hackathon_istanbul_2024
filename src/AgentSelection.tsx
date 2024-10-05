"use client";

import {
  Box,
  VStack,
  Heading,
  SimpleGrid,
  Button,
  Text,
  Icon,
  ChakraProvider,
  Link,
} from "@chakra-ui/react";
import { FaShippingFast, FaPlane, FaClipboardCheck } from "react-icons/fa";
import { variables } from "./variables";

const agentOptions = [
  {
    role: "Shipper",
    icon: FaShippingFast,
    description: "Manage shipments and track cargo",
  },
  {
    role: "Ground Handling Agent",
    icon: FaPlane,
    description: "Coordinate airport operations and cargo handling",
  },
  {
    role: "Quality Assurance Agent",
    icon: FaClipboardCheck,
    description: "Ensure compliance and maintain quality standards",
  },
];

export default function AgentSelection() {
  const handleSelection = (role: string) => {
    console.log(`Selected role: ${role}`);
    // Here you would typically navigate to the appropriate page or update the app state
  };

  function getAgentRoute(role: string): string | undefined {
    console.log("Agent route: " + role);
    // Return the route based on the role
    switch (role) {
      case "Shipper":
        return variables.links.shipper.base;
      case "Ground Handling Agent":
        return variables.links.gha.base;
      case "Quality Assurance Agent":
        return variables.links.qa.base;
      default:
        return variables.links.base;
    }
  }

  return (
    <ChakraProvider>
      <Box
        minHeight="72vh"
        display="flex"
        alignItems="center"
        justifyContent="center"
      >
        <VStack spacing={8} align="stretch" maxWidth="800px" width="100%" p={6}>
          <Heading as="h1" size="2xl" textAlign="center" mb={4}>
            Select Your Role
          </Heading>
          <SimpleGrid columns={{ base: 1, md: 3 }} spacing={6}>
            {agentOptions.map((option) => (
              <Link href={getAgentRoute(option.role)}>
                <Button
                  key={option.role}
                  height="auto"
                  flexDirection="column"
                  alignItems="center"
                  justifyContent="center"
                  py={8}
                  px={4}
                  bg="white"
                  boxShadow="md"
                  borderRadius="lg"
                  transition="all 0.3s"
                  _hover={{ transform: "translateY(-5px)", boxShadow: "lg" }}
                >
                  <Icon as={option.icon} boxSize={12} mb={4} color={variables.color.yellow} />
                  <Text fontWeight="bold" fontSize="lg" mb={2}>
                    {option.role}
                  </Text>
                  <Text
                    fontSize="sm"
                    textAlign="center"
                    color="gray.600"
                    whiteSpace="normal"
                    wordBreak="break-word"
                  >
                    {option.description}
                  </Text>
                </Button>
              </Link>
            ))}
          </SimpleGrid>
        </VStack>
      </Box>
    </ChakraProvider>
  );
}
