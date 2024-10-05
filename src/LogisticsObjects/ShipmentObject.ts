export default interface LogisticsObjectResponse {
  "@graph": GraphNode[];
  "@context": Context;
}

interface GraphNode {
  "@id": string;
  "@type": string[] | string;
  checks?: RefObject;
  pieces?: RefObject;
  specialHandlingCodes?: RefObject[];
  totalDimensions?: RefObject;
  totalGrossWeight?: RefObject;
  numericalValue?: NumericalValue;
  unit?: RefObject;
  volume?: RefObject;
}

interface RefObject {
  "@id": string;
}

interface NumericalValue {
  "@type": string;
  "@value": string;
}

interface Context {
  "@vocab": string;
}