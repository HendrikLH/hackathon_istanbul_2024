import { ChakraProvider, Flex } from "@chakra-ui/react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ShipmentOverview from "./ShipmentOverview";
import Header from "./Header";
import Footer from "./Footer";
import ShipmentDetails from "./ShipmentDetails";
import AgentSelection from "./AgentSelection";

function App() {
  return (
    <BrowserRouter>
      <ChakraProvider>
        <Header />
        <Flex
          maxWidth="container.xl"
          margin="auto"
          justifyContent="space-between"
          alignItems="center"
          flexDir="column"
          flexWrap="wrap"
          px={4}
          mx="auto"
          boxSizing="border-box"
        >
          <Routes>
            <Route path="/" element={<AgentSelection/>}/>
            <Route path="/shipment/" element={<ShipmentOverview />} />
            <Route path="/shipment/*" element={<ShipmentDetails />} />
          </Routes>
        </Flex>
        <Footer />
      </ChakraProvider>
    </BrowserRouter>
  );
}

export default App;
