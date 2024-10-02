"use client";

import { useState } from "react";
import {
  ChakraProvider,
  Box,
  VStack,
  Heading,
  Input,
  Button,
  Card,
  CardHeader,
  CardBody,
  SimpleGrid,
  Text,
  Flex,
  Table,
  Thead,
  Tbody,
  Tr,
  Th,
  Td,
  Icon,
  Modal,
  useDisclosure,
  ModalOverlay,
  ModalContent,
  Spinner
} from "@chakra-ui/react";
import {
  FaBox,
  FaWeight,
  FaMapMarkerAlt,
  FaFlag,
  FaClock,
  FaPlane,
} from "react-icons/fa";
import { variables } from "./variables";
import BreadCrumbs from "./BreadCrumbs";
import Footer from "./Footer";
import MilestoneFlowChart from "./MileStoneFlowChart";

// Mock data - replace with actual API calls in a real application
const mockAwbData = {
  product: "General Cargo",
  pieces: 5,
  weight: 500,
  origin: "LAX",
  destination: "JFK",
  recentMilestone: "DEP",
};

const mockMilestones = ["RCS", "DEP", "ARR", "RCF", "NFD"];

const mockStatusHistory = [
  {
    flight: "LH8401",
    origin: "PVG",
    destination: "FRA",
    event: "BKD",
    station: "PVG (Shanghai)",
    plannedTime: "2023-05-15 10:00",
    actualTime: "2023-05-15 10:00",
    plannedPieces: "15 / 2595 kg",
    actualPieces: "15 / 2959 kg",
  },
  {
    flight: "LH8401",
    origin: "PVG",
    destination: "FRA",
    event: "RCS",
    station: "PVG (Shanghai)",
    plannedTime: "2023-05-15 10:00",
    actualTime: "2023-05-15 10:00",
    plannedPieces: "15 / 2595 kg",
    actualPieces: "15 / 2959 kg",
  },
  {
    flight: "LH8401",
    origin: "FRA",
    destination: "BUD",
    event: "ARR",
    station: "PVG (Shanghai)",
    plannedTime: "2023-05-15 10:00",
    actualTime: "2023-05-15 10:00",
    plannedPieces: "15 / 2595 kg",
    actualPieces: "15 / 2959 kg",
  },
  {
    flight: "LH8401",
    origin: "FRA",
    destination: "BUD",
    event: "DEP",
    station: "PVG (Shanghai)",
    plannedTime: "2023-05-15 10:00",
    actualTime: "2023-05-15 10:00",
    plannedPieces: "15 / 2595 kg",
    actualPieces: "15 / 2959 kg",
  },
];

export default function UldTracking() {
  const [awb, setAwb] = useState("020");

  const { isOpen, onOpen, onClose } = useDisclosure();

  const handleSearch = () => {
    onOpen(); // Open the loading overlay
    // Simulate an API call
    setTimeout(() => {
      console.log("Searching for AWB:", awb);
      onClose(); // Close the loading overlay after the "API call" is complete
    }, 2000); // Simulating a 2-second delay
  };

  return (
    <>
          <MilestoneFlowChart />

          {/* AWB Input */}
          <Flex>
            <Input
              value={awb}
              onChange={(e) => setAwb(e.target.value)}
              placeholder="Enter AWB number"
              mr={2}
            />
            <Button
              onClick={handleSearch}
              backgroundColor={variables.color.yellow}
              color={variables.color.blue}
            >
              Search
            </Button>
          </Flex>

          {/* AWB Overview */}
          <Card>
            <CardHeader>
              <Heading size="md">AWB Overview</Heading>
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

          {/* Milestone Overview */}
          <Card>
            <CardHeader>
              <Heading size="md">Milestone Overview</Heading>
            </CardHeader>
            <CardBody>
              <Flex justify="space-between" align="center">
                {mockMilestones.map((milestone, index) => (
                  <VStack
                    key={index}
                    color={
                      index <=
                      mockMilestones.indexOf(mockAwbData.recentMilestone)
                        ? variables.color.yellow
                        : variables.color.grey
                    }
                  >
                    <Icon as={FaPlane} boxSize={6} mb={2} />
                    <Text>{milestone}</Text>
                  </VStack>
                ))}
              </Flex>
            </CardBody>
          </Card>

          {/* Status History */}
          <Card>
            <CardHeader>
              <Heading size="md">Status History</Heading>
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
                        <Icon
                          as={FaPlane}
                          boxSize={4}
                          mb={0}
                          marginRight="1em"
                        />
                        {status.flight}
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

      {/* Loading Overlay */}
      <Modal isOpen={isOpen} onClose={onClose} isCentered>
        <ModalOverlay bg="blackAlpha.300" backdropFilter="blur(10px)" />
        <ModalContent bg="transparent" boxShadow="none">
          <Flex justify="center" align="center" height="100vh">
            <Spinner
              thickness="4px"
              speed="0.65s"
              emptyColor={variables.color.yellow}
              color={variables.color.blue}
              size="xl"
            />
          </Flex>
        </ModalContent>
      </Modal>
    </>
  );
}
