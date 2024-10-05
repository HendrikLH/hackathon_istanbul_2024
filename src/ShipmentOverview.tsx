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
import { CheckCircleIcon, WarningIcon, WarningTwoIcon } from "@chakra-ui/icons";

interface ShipmentOverviewProps {
  agent: "Shipper" | "Quality Assurance Agent";
}

export const defaultCrumb = {
  href: variables.links.base,
  label: "Agent Selection",
  isCurrentPage: false,
};

export function getShipmentStatus() {
  const randStatus = Math.floor(Math.random() * 4);
  if (randStatus == 0) {
    return <WarningIcon color="red" />;
  } else if (randStatus == 1) {
    return <WarningTwoIcon color={variables.color.yellow} />;
  } else {
    return <CheckCircleIcon color="green" />;
  }
}

export default function ShipmentOverview({ agent }: ShipmentOverviewProps) {
  const location = useLocation();
  const currentlocation = window.location.origin + location.pathname;

  // Data fetching
  const [data, setData] = useState<WaybillObjectResponse | null>(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await fetch(variables.api.awbs[0].endpoint, {
          method: "GET",
          headers: {
            Authorization: `Bearer ${variables.accessToken}`,
            "Content-Type": "application/ld+json",
          },
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
            ? [
                defaultCrumb,
                {
                  href: variables.links.shipper.base,
                  label: "Shipment Overview",
                  isCurrentPage: true,
                },
              ]
            : [
                defaultCrumb,
                {
                  href: variables.links.qa.base,
                  label: "Quality Assurance Overview",
                  isCurrentPage: true,
                },
              ]
        }
      />

      {/* Status History */}
      <Card width="100%" boxSizing="border-box">
        <CardHeader>
          <Heading size="md">List of Shipments</Heading>
        </CardHeader>
        <CardBody>
          <Table variant="simple">
            <Thead>
              <Tr>
                <Th>AWB</Th>
                {agent === "Quality Assurance Agent" ? <Th>Test</Th> : <></>}
                <Th>Recent Milestone</Th>
                <Th>Departure Location</Th>
                <Th>Arrival Location</Th>
                <Th>Status</Th>
              </Tr>
            </Thead>
            <Tbody>
              <Tr key={1234} color="red">
                <Td>
                  <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                  <Link
                    href={
                      currentlocation +
                      "/" +
                      "020" +
                      "-" +
                      "44395433"
                    }
                  >
                    020-44395433
                  </Link>
                </Td>
                {agent === "Quality Assurance Agent" ? <Td>DB Schenker</Td> : <></>}
                <Td>FOH</Td>
                <Td>FRA</Td>
                <Td>ATL</Td>
                <Td><WarningIcon color="red" /></Td>
              </Tr>
              <Tr key={1234}>
                <Td>
                  <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                  <Link
                    href={
                      currentlocation +
                      "/" +
                      "020" +
                      "-" +
                      "117069007"
                    }
                  >
                    020-00706942
                  </Link>
                </Td>
                {agent === "Quality Assurance Agent" ? <Td>DB Schenker</Td> : <></>}
                <Td>FOH</Td>
                <Td>IST</Td>
                <Td>FRA</Td>
                <Td><CheckCircleIcon color="green" /></Td>
              </Tr>
              {mockStatusHistory.map((status, index) => (
                <Tr key={index}>
                  <Td>
                    <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                    <Link
                      href={
                        currentlocation +
                        "/" +
                        data?.waybillPrefix +
                        "-" +
                        data?.waybillNumber
                      }
                    >
                      {data?.waybillPrefix}-{data?.waybillNumber}
                    </Link>
                  </Td>
                  {agent === "Quality Assurance Agent" ? <Td>Kühne + Nagel AG</Td> : <></>}
                  <Td>DEP</Td>
                  <Td>{getAirportCode(data?.departureLocation["@id"])}</Td>
                  <Td>{getAirportCode(data?.arrivalLocation["@id"])}</Td>
                  <Td>{getShipmentStatus()}</Td>
                </Tr>
              ))}
            </Tbody>
          </Table>
        </CardBody>
      </Card>
    </>
  );
}
