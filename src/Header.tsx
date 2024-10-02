'use client'

import { Box, Flex, Text, VStack, HStack, Heading, useColorModeValue, ChakraProvider } from '@chakra-ui/react'
import { FaPlane, FaBox } from 'react-icons/fa'
import { variables } from './variables'

export default function Header() {
  const bgColor = useColorModeValue(variables.color.lightGrey, 'gray.700')
  const textColor = useColorModeValue(variables.color.blue, 'white')
  const accentColor = useColorModeValue(variables.color.yellow, 'blue.200')

  return (
    <ChakraProvider>
      <Box 
        as="header" 
        bg={bgColor} 
        color={textColor} 
        py={3} 
        px="1em" 
        boxShadow="sm"
      >
        <Flex 
          maxW="container.xl" 
          mx="auto" 
          justifyContent="space-between" 
          alignItems="center"
        >
          <HStack spacing={4}>
            <Box as={FaBox} size="24px" color={accentColor} />
            <VStack alignItems="flex-start" spacing={0}>
              <Heading size="md" fontWeight="bold">ULD Tracking</Heading>
              <Text fontSize="sm" fontWeight="medium">By Team <i>JettHansa Industries</i></Text>
            </VStack>
          </HStack>
          
          <HStack spacing={2} alignItems="center">
            <Box as={FaPlane} size="20px" color={accentColor} />
            <Text fontSize="sm" fontWeight="medium">
              IATA ONE Record Hackathon
            </Text>
            <Text fontSize="sm" fontWeight="bold" color={accentColor}>
              Istanbul 2024
            </Text>
          </HStack>
        </Flex>
      </Box>
    </ChakraProvider>
  )
}