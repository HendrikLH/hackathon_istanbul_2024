export default interface WaybillObjectResponse {
    "@id": string;
    "@type": string[];
    arrivalLocation: {
      "@id": string;
    };
    departureLocation: {
      "@id": string;
    };
    referredBookingOption: {
      "@id": string;
    };
    shipment: {
      "@id": string;
    };
    waybillNumber: string;
    waybillPrefix: string;
    waybillType: {
      "@id": string;
    };
    "@context": {
      "@vocab": string;
    };
  }