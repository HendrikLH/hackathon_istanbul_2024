import {
    Card,
    CardBody,
    CardHeader,
    Heading,
    Icon,
    Link,
    Table,
    Tbody,
    Td,
    Th,
    Thead,
    Tr,
  } from "@chakra-ui/react";
  import {
    FaPlane,
  } from "react-icons/fa";
  import { mockAwbData, mockStatusHistory } from "./mockData";
  import BreadCrumbs from "./BreadCrumbs";
  import { useLocation } from "react-router-dom";
  import { variables } from "./variables";
import { defaultCrumb } from "./ShipmentOverview";
  
  export default function GHAOverview() {
    const location = useLocation();
    const currentlocation = window.location.origin + location.pathname;
  
   
  
    return (
      <>
        <BreadCrumbs
          breadCrumbs={[defaultCrumb, { href: variables.links.gha.base, label: "GHA Overview", isCurrentPage: true }]}
        />
  
        {/* Status History */}
        <Card width="100%" boxSizing="border-box" >
          <CardHeader>
            <Heading size="md">List of Shipments</Heading>
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
                      <Icon as={FaPlane} boxSize={4} mb={0} marginRight="1em" />
                      <Link href={currentlocation + "/" + status.flight}>
                        {status.flight}
                      </Link>
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
      </>
    );
  }
  