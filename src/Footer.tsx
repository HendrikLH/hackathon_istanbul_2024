"use client";

import {
  Box,
  Flex,
  Image,
  Text,
  ChakraProvider,
  extendTheme,
} from "@chakra-ui/react";

// Extend the theme to include custom colors
const theme = extendTheme({
  colors: {
    brand: {
      yellow: "#f9ba00",
      blue: "#00235f",
      white: "#fff",
      grey: "#7a7a7a",
    },
  },
});

export default function Footer() {
  return (
    <ChakraProvider theme={theme}>
      <Box as="footer" bg="brand.blue" color="brand.white" py={4} mt="1em">
        <Flex
          maxWidth="container.xl"
          margin="auto"
          justifyContent="space-between"
          alignItems="center"
          flexWrap="wrap"
          px={4}
        >
          <Flex alignItems="center">
            <Text fontSize="sm" color="brand.grey" mr={4}>
              © {new Date().getFullYear()} IATA ONE Record <br />
              Hackathon @ Istanbul
            </Text>
          </Flex>

          <Flex justifyContent="center" alignItems="center" flexGrow={1} my={2}>
              <Box boxSize="150px">
                <Image
                  src={"/logo-white-lhind.png"}
                  margin="1em"
                  mx={2}
                />
                <Image
                  src={"/LCAG_Logo.png"}
                  margin="1em"
                  mx={2}
                />
                <Image
                  src={"/jettainer_logo.png"}
                  mx={2}
                  bgColor="white"
                  margin="1em"
                />
              </Box>
          </Flex>

          <Flex alignItems="center">
            <Text fontSize="sm" color="brand.yellow" textAlign="right">
              <b>Powered by</b>
              <br />
              Lufthansa Industry Solutions <br />
              Lufthansa Cargo <br />
              and Jettainer
            </Text>
          </Flex>
        </Flex>
      </Box>
    </ChakraProvider>
  );
}
