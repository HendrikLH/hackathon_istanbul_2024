interface GraphEntry {
    "@id": string;
    "@type": string | string[];
    attachedIotDevices?: {
      "@id": string;
    };
    numberOfDoors?: {
      "@type": string;
      "@value": string;
    };
    ownerCode?: {
      "@id": string;
    };
    uldSerialNumber?: string;
    uldTypeCode?: {
      "@id": string;
    };
    code?: string;
    codeDescription?: string;
  }
  
  // Define the main interface for the entire object
  export default interface  ULDObject {
    "@graph": GraphEntry[];
    "@context": {
      "@vocab": string;
    };
  }