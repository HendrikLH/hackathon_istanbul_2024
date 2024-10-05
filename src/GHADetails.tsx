import {
  Button,
  Card,
  CardBody,
  CardHeader,
  Flex,
  Heading,
  Icon,
  Link,
  Modal,
  ModalBody,
  ModalCloseButton,
  ModalContent,
  ModalFooter,
  ModalHeader,
  ModalOverlay,
  SimpleGrid,
  Table,
  Tbody,
  Td,
  Text,
  Th,
  Thead,
  Tr,
  useDisclosure,
} from "@chakra-ui/react";
import {
  FaBox,
  FaClock,
  FaFlag,
  FaMapMarkerAlt,
  FaPlane,
  FaWeight,
} from "react-icons/fa";
import { locations, mockAwbData, mockStatusHistory } from "./mockData";
import BreadCrumbs from "./BreadCrumbs";
import { useLocation } from "react-router-dom";
import LoadingSpinner from "./LoadingSpinner";
import GeoMap from "./GeoMap";
import { defaultCrumb } from "./ShipmentOverview";
import { variables } from "./variables";
import { useEffect, useState } from "react";
import ULDObject from "./LogisticsObjects/ULDObject";
import WaybillObjectResponse from "./LogisticsObjects/WaybillObject";
import getAirportCode from "./utils/getAirPortCodeFromUrl";

export default function GHADetails() {
  const location = useLocation();
  const currentlocation = window.location.origin + location.pathname;
  const id = currentlocation.split("/").pop();

  // ULD Data fetching
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

  const { isOpen, onOpen, onClose } = useDisclosure()

  return (
    <>
      <BreadCrumbs
        breadCrumbs={[
          defaultCrumb,
          {
            href: variables.links.gha.base,
            label: "GHA Overview",
            isCurrentPage: false,
          },
          { href: currentlocation, label: "GHA Details", isCurrentPage: true },
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
              <Icon as={FaPlane} mr={2} />
              <Text>Flight: LH8401</Text>
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

      {/* ULD Overview */}
      <Card margin="1em 0" width="100%" boxSizing="border-box">
        <CardHeader>
          <Heading size="md">ULD Details</Heading>
        </CardHeader>
        <CardBody>
          <SimpleGrid columns={[2, null, 3]} spacing={4}>
            <Flex align="center">
              <Icon as={FaBox} mr={2} />
              <Text>ULD Number: {ULDData?.["@graph"][0].uldSerialNumber}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaClock} mr={2} />
              <Text>Current Milestone: FOH</Text>
              {/*<Text>Current Milestone: ALS</Text>*/}
            </Flex>
            <Flex align="center">
              <Icon as={FaPlane} mr={2} />
              <Text>Operating Airline: {ULDData?.["@graph"][2].codeDescription}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaMapMarkerAlt} mr={2} />
              <Text>Origin: {getAirportCode(awbData?.departureLocation["@id"])}</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaFlag} mr={2} />
              <Text>Destination: ATL</Text>
            </Flex>
            <Flex align="center">
              <Icon as={FaWeight} mr={2} />
              <Text>Weight: 560 kg</Text>
            </Flex>
          </SimpleGrid>
        </CardBody>
      </Card>

      {/* Geo Location Map */}
      <GeoMap points={locations} />

      <Button
        mt="1em"
        color={variables.color.blue}
        bgColor={variables.color.yellow}
        minWidth="20em"
        p={6}
        _hover={{bgColor:"orange", color: "black"}}
        onClick={onOpen}
      >Lead me to ULD with exception</Button>

<Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>Navigate to ULD {ULDData?.["@graph"][0].uldSerialNumber}</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            The ULD can be found at lat: 50.042669 lng: 8.539264
          </ModalBody>

          <ModalFooter>
            <Button 
            color={variables.color.blue}
            bgColor={variables.color.yellow}
            _hover={{bgColor:"orange", color: "black"}}
            colorScheme='blue' mr={3}
            onClick={onClose}>
              Start Navigation
            </Button>
          </ModalFooter>
        </ModalContent>
      </Modal>
    </>
  );
}
