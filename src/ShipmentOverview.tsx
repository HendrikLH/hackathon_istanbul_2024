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
import { useEffect, useState } from "react";
import WaybillObjectResponse from "./LogisticsObjects/WaybillObject";
import getAirportCode from "./utils/getAirPortCodeFromUrl";

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

  // Data fetching
  const [data, setData] = useState<WaybillObjectResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(variables.api.awbs[0].endpoint, {
          method: "GET",
          headers: {
            'Authorization': `Bearer ${variables.accessToken}`,
            'Content-Type': 'application/ld+json'
          }
        });
        
        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result: WaybillObjectResponse = await response.json();

        console.log("Result for shipment: ", result);

        setData(result);
      } catch (error: any) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);
 
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
              <Text>Pieces: {0}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaWeight} mr={2} />
              <Text>Weight: {mockAwbData.weight} kg</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaMapMarkerAlt} mr={2} />
              <Text>Origin: {getAirportCode(data?.departureLocation["@id"])}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaFlag} mr={2} />
              <Text>Destination: {getAirportCode(data?.departureLocation["@id"])}</Text>
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
                <Th>AWB</Th>
                <Th>Departure Location</Th>
                <Th>Arrival Location</Th>
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
                    <Link href={currentlocation + "/" + data?.waybillPrefix + "-" + data?.waybillNumber}>
                    {data?.waybillPrefix}-{data?.waybillNumber}
                    </Link>
                  </Td>
                  <Td>{data?.waybillPrefix}-{data?.waybillNumber}</Td>
                  <Td>{getAirportCode(data?.departureLocation["@id"])}</Td>
                  <Td>{getAirportCode(data?.arrivalLocation["@id"])}</Td>
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
