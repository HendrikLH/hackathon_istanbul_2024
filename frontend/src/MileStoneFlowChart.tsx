'use client'

import { useState } from 'react'
import { ChakraProvider, Box, VStack, Text, Link, Tooltip, useDisclosure, Modal, ModalOverlay, ModalContent, ModalHeader, ModalBody, ModalCloseButton } from '@chakra-ui/react'
import ReactFlow, { Node, Edge, Controls, Background } from 'reactflow'
import 'reactflow/dist/style.css'
import { FaPlane, FaBox, FaWarehouse } from 'react-icons/fa'

const mockMilestones = ["RCS", "DEP", "ARR", "RCF", "NFD"]

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
]

const CustomNode = ({ data }: any) => {
  const { isOpen, onOpen, onClose } = useDisclosure()

  return (
    <>
      <Box
        bg="white"
        border="1px"
        borderColor="gray.200"
        borderRadius="md"
        p={2}
        textAlign="center"
        cursor="pointer"
        onClick={onOpen}
      >
        <VStack>
          {data.icon}
          <Text fontWeight="bold">{data.label}</Text>
          <Text fontSize="sm">{data.subLabel}</Text>
        </VStack>
      </Box>

      <Modal isOpen={isOpen} onClose={onClose}>
        <ModalOverlay />
        <ModalContent>
          <ModalHeader>{data.label}</ModalHeader>
          <ModalCloseButton />
          <ModalBody>
            <VStack align="start" spacing={2}>
              <Text><strong>Flight:</strong> {data.details.flight}</Text>
              <Text><strong>Origin:</strong> {data.details.origin}</Text>
              <Text><strong>Destination:</strong> {data.details.destination}</Text>
              <Text><strong>Event:</strong> {data.details.event}</Text>
              <Text><strong>Station:</strong> {data.details.station}</Text>
              <Text><strong>Planned Time:</strong> {data.details.plannedTime}</Text>
              <Text><strong>Actual Time:</strong> {data.details.actualTime}</Text>
              <Text><strong>Planned Pieces:</strong> {data.details.plannedPieces}</Text>
              <Text><strong>Actual Pieces:</strong> {data.details.actualPieces}</Text>
            </VStack>
          </ModalBody>
        </ModalContent>
      </Modal>
    </>
  )
}

export default function MilestoneFlowChart() {
  const [nodes, setNodes] = useState<Node[]>([])
  const [edges, setEdges] = useState<Edge[]>([])

  useState(() => {
    const newNodes: Node[] = mockStatusHistory.map((status, index) => ({
      id: `${index}`,
      type: 'custom',
      position: { x: index * 250, y: 0 },
      data: {
        label: status.event,
        subLabel: `${status.origin} -> ${status.destination}`,
        icon: status.event === 'DEP' || status.event === 'ARR' ? <FaPlane size={24} /> : 
              status.event === 'RCS' ? <FaBox size={24} /> : <FaWarehouse size={24} />,
        details: status,
      },
    }))

    const newEdges: Edge[] = mockStatusHistory.slice(0, -1).map((_, index) => ({
      id: `e${index}-${index + 1}`,
      source: `${index}`,
      target: `${index + 1}`,
      type: 'smoothstep',
    }))

    setNodes(newNodes)
    setEdges(newEdges)
  })

  const nodeTypes = {
    custom: CustomNode,
  }

  return (
    <ChakraProvider>
      <Box height="500px" border="1px" borderColor="gray.200" borderRadius="md">
        <ReactFlow
          nodes={nodes}
          edges={edges}
          nodeTypes={nodeTypes}
          fitView
        >
          <Background />
          <Controls />
        </ReactFlow>
      </Box>
      <VStack mt={4} spacing={2}>
        {mockMilestones.map((milestone, index) => (
          <Tooltip key={index} label={`View details for ${milestone}`}>
            <Link href="#" color="blue.500">
              {milestone}
            </Link>
          </Tooltip>
        ))}
      </VStack>
    </ChakraProvider>
  )
}