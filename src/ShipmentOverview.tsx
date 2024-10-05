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
import { variables } from "./variables";

interface ShipmentOverviewProps {
  agent: "Shipper" | "Quality Assurance Agent";
}

export const defaultCrumb = {
  href: variables.links.base,
  label: "Agent Selection",
  isCurrentPage: false
}

export default function ShipmentOverview({ agent }: ShipmentOverviewProps) {
  const location = useLocation();
  const currentlocation = window.location.origin + location.pathname;

 

  return (
    <>
      <BreadCrumbs
        breadCrumbs={
          agent === "Shipper"
            ? [defaultCrumb, { href: variables.links.shipper.base, label: "Shipment Overview", isCurrentPage: true }]
            : [defaultCrumb, { href: variables.links.qa.base, label: "Quality Assurance Overview", isCurrentPage: true }]
        }
      />

      {/* AWB Overview */}
      <Card margin="1em 0" width="100%" boxSizing="border-box">
        <CardHeader>
          <Heading size="md">Shipment Statistics</Heading>
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

      {/* Status History */}
      <Card width="100%" boxSizing="border-box">
        <CardHeader>
          <Heading size="md">List of Shipments</Heading>
        </CardHeader>
        <CardBody>
          <Table variant="simple">
            <Thead>
              <Tr>
                <Th>Flight no. (Origin / Destination)</Th>
                <Th>Event</Th>
                <Th>Station</Th>
                <Th>Planned Time</Th>
                <Th>Actual Time</Th>
                <Th>Planned Pieces / Weight</Th>
                <Th>Actual Pieces / Weight</Th>
              </Tr>
            </Thead>
            <Tbody>
              {mockStatusHistory.map((status, index) => (
                <Tr key={index}>
                  <Td>
                    <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                    <Link href={currentlocation + "/" + status.flight}>
                      {status.flight}
                    </Link>
                  </Td>
                  <Td>{status.event}</Td>
                  <Td>{status.station}</Td>
                  <Td>{status.plannedTime}</Td>
                  <Td>{status.actualTime}</Td>
                  <Td>{status.plannedPieces}</Td>
                  <Td>{status.actualPieces}</Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </CardBody>
      </Card>
    </>
  );
}
