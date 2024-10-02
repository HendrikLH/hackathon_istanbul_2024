"use client";

import { useEffect } from "react";
import {
  Flex,
  Modal,
  useDisclosure,
  ModalOverlay,
  ModalContent,
  Spinner
} from "@chakra-ui/react";
import { variables } from "./variables";

interface LoadSpinnerProps {
    loadingTimeMS?: number
}

export default function LoadingSpinner({loadingTimeMS=750}: LoadSpinnerProps) {


  const { isOpen, onOpen, onClose } = useDisclosure();

  useEffect(() => {
    onOpen();
    // Simulate an API call
    setTimeout(() => {
        console.log("Fake loading spinner active for: " + loadingTimeMS);
      onClose(); // Close the loading overlay after the "API call" is complete
    }, loadingTimeMS);
  }, []);

  return (
    <>
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
