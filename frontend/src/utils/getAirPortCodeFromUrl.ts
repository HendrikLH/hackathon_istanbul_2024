export default function getAirportCode(url:string | undefined | null) {
    // Split the string by "-" and return the last element
    if(url === undefined || url === null) {
        return "n/a"
    }
    const segments = url.split("-");
    return segments[segments.length - 1];
  }