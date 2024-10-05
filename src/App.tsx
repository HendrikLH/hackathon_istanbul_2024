import { ChakraProvider, Flex } from "@chakra-ui/react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import ShipmentOverview from "./ShipmentOverview";
import Header from "./Header";
import Footer from "./Footer";
import ShipmentDetails from "./ShipmentDetails";
import AgentSelection from "./AgentSelection";
import { variables } from "./variables";
import QualityAssuranceDetails from "./QualityAssuranceDetails";
import GHAOverview from "./GHAOverview";
import GHADetails from "./GHADetails";

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
            <Route path={variables.links.shipper.base} element={<ShipmentOverview agent="Shipper" />} />
            <Route path={variables.links.qa.base} element={<ShipmentOverview agent="Quality Assurance Agent" />} />
            <Route path={variables.links.gha.base} element={<GHAOverview />} />
            <Route path={variables.links.shipper.details} element={<ShipmentDetails />} />
            <Route path={variables.links.qa.details} element={<QualityAssuranceDetails />} />
            <Route path={variables.links.gha.details} element={<GHADetails />} />
          </Routes>
        </Flex>
        <Footer />
      </ChakraProvider>
    </BrowserRouter>
  );
}

export default App;
