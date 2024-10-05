import {
  Card,
  CardBody,
  CardHeader,
  Flex,
  Heading,
  Icon,
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
  FaWarehouse
} from "react-icons/fa";
import { mockAwbData, mockStatusHistory } from "./mockData";
import BreadCrumbs from "./BreadCrumbs";
import { useLocation } from "react-router-dom";
import LoadingSpinner from "./LoadingSpinner";
import { defaultCrumb, getShipmentStatus } from "./ShipmentOverview";
import { variables } from "./variables";
import ULDObject from "./LogisticsObjects/ULDObject";
import { useEffect, useState } from "react";
import WaybillObjectResponse from "./LogisticsObjects/WaybillObject";
import getAirportCode from "./utils/getAirPortCodeFromUrl";

export default function QualityAssuranceDetails() {
  const location = useLocation();
  const currentlocation = window.location.origin + location.pathname;
  const id = currentlocation.split("/").pop();

  // Data fetching
  const [ULDData, setULDData] = useState<ULDObject | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(variables.api.ulds[0].endpoint, {
          method: "GET",
          headers: {
            Authorization: `Bearer ${variables.accessToken}`,
            "Content-Type": "application/ld+json",
          },
        });

        if (!response.ok) {
          throw new Error(`HTTP error! status: ${response.status}`);
        }

        const result: ULDObject = await response.json();

        console.log("Result for ULD: ", result);

        setULDData(result);
      } catch (error: any) {
        setError(error.message);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  // AWB Data fetching
  const [awbData, setAwbData] = useState<WaybillObjectResponse | null>(null);
  const [awbLoading, setAwbLoading] = useState(true);
  const [awbError, setAwbError] = useState(null);

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

        setAwbData(result);
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
        breadCrumbs={[
          defaultCrumb,
          {
            href: variables.links.shipper.base,
            label: "Shipment Overview",
            isCurrentPage: false,
          },
          {
            href: currentlocation,
            label: `Shipment Details ${id}`,
            isCurrentPage: true,
          },
        ]}
      />
      <LoadingSpinner loadingTimeMS={300} />
      {/* AWB Overview */}
      <Card margin="1em 0" width="100%" boxSizing="border-box">
        <CardHeader>
          <Heading size="md">Shipment Details</Heading>
        </CardHeader>
        <CardBody>
          <SimpleGrid columns={[2, null, 3]} spacing={4}>
            <Flex align="center">
              <Icon as={FaBox} mr={2} />
              <Text>AWB:  {awbData?.waybillPrefix}-{awbData?.waybillNumber}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaBox} mr={2} />
              <Text>Pieces: {}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaWarehouse} mr={2} />
              <Text>Status: {getShipmentStatus()}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaMapMarkerAlt} mr={2} />
              <Text>Origin: {getAirportCode(awbData?.departureLocation["@id"])}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaFlag} mr={2} />
              <Text>Destination: {getAirportCode(awbData?.arrivalLocation["@id"])}</Text>
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
          <Heading size="md">List of Milestones for Shipment</Heading>
        </CardHeader>
        <CardBody>
          <Table variant="simple">
            <Thead>
              <Tr>
                <Th>Milestone</Th>
                <Th>Station</Th>
                <Th>Status</Th>
                <Th>Amount of Pieces</Th>
              </Tr>
            </Thead>
            <Tbody>
              {mockStatusHistory.map((status, index) => (
                <Tr key={index}>
                  <Td>
                    <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                      {ULDData?.["@graph"][1].code}
                  </Td>
                  <Td>{status.station}</Td>
                  <Td>{getShipmentStatus()}</Td>
                  <Td>{status.plannedPieces}</Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </CardBody>
      </Card>

    </>
  );
}
