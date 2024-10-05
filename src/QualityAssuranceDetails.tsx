import {
    Card,
    CardBody,
    CardHeader,
    Flex,
    Heading,
    Icon,
    Link,
    SimpleGrid,
    Table,
    Tbody,
    Td,
    Text,
    Th,
    Thead,
    Tr,
  } from "@chakra-ui/react";
  import {
    FaBox,
    FaClock,
    FaFlag,
    FaMapMarkerAlt,
    FaPlane,
    FaWeight,
  } from "react-icons/fa";
  import { mockAwbData, mockStatusHistory } from "./mockData";
  import BreadCrumbs from "./BreadCrumbs";
  import { useLocation } from "react-router-dom";
import LoadingSpinner from "./LoadingSpinner";
import GeoMap from "./GeoMap";
import { defaultCrumb } from "./ShipmentOverview";
import { variables } from "./variables";
  
  export default function QualityAssuranceDetails() {
  
      const location = useLocation();
      const currentlocation = window.location.origin + location.pathname;
      const id = currentlocation.split("/").pop();
  
    return (
      <>
        <BreadCrumbs
          breadCrumbs={[defaultCrumb,
            { href: variables.links.qa.base, label: "Quality Assurance Overview", isCurrentPage: false },
            { href: currentlocation, label: `Details for ${id}`, isCurrentPage: true },
          ]}
        />
        <LoadingSpinner loadingTimeMS={200} />
          {/* AWB Overview */}
        <Card margin="1em 0" width="100%" boxSizing="border-box">
          <CardHeader>
            <Heading size="md">Shipment Details</Heading>
          </CardHeader>
          <CardBody>
            <SimpleGrid columns={[2, null, 3]} spacing={4}>
              <Flex align="center">
                <Icon as={FaBox} mr={2} />
                <Text>Product: {mockAwbData.product}</Text>
              </Flex>
              <Flex align="center">
                <Icon as={FaBox} mr={2} />
                <Text>Pieces: {mockAwbData.pieces}</Text>
              </Flex>
              <Flex align="center">
                <Icon as={FaWeight} mr={2} />
                <Text>Weight: {mockAwbData.weight} kg</Text>
              </Flex>
              <Flex align="center">
                <Icon as={FaMapMarkerAlt} mr={2} />
                <Text>Origin: {mockAwbData.origin}</Text>
              </Flex>
              <Flex align="center">
                <Icon as={FaFlag} mr={2} />
                <Text>Destination: {mockAwbData.destination}</Text>
              </Flex>
              <Flex align="center">
                <Icon as={FaClock} mr={2} />
                <Text>Recent Milestone: {mockAwbData.recentMilestone}</Text>
              </Flex>
            </SimpleGrid>
          </CardBody>
        </Card>

        {/* ULDs */}
        <Card marginBottom="1em" width="100%" boxSizing="border-box">
          <CardHeader>
            <Heading size="md">List of ULDs for Shipment {id}</Heading>
          </CardHeader>
          <CardBody>
            <Table variant="simple">
              <Thead>
                <Tr>
                  <Th>ULD No.</Th>
                  <Th>Current Station</Th>
                  <Th>Origin</Th>
                  <Th>Destination</Th>
                  <Th>Amount of Pieces</Th>
                </Tr>
              </Thead>
              <Tbody>
                {mockStatusHistory.map((status, index) => (
                  <Tr key={index}>
                    <Td>
                      <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                      <Link href={currentlocation + "shipment/" + status.flight}>{status.flight}</Link>
                    </Td>
                    <Td>{status.station}</Td>
                    <Td>{status.station}</Td>
                    <Td>{status.station}</Td>
                    <Td>{status.plannedPieces}</Td>
                  </Tr>
                ))}
              </Tbody>
            </Table>
          </CardBody>
        </Card>

        {/* Geo Location Map */}
        <GeoMap />
      </>
    );
  }
  