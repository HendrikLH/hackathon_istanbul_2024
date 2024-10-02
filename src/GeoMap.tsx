"use client";

import { useState, useEffect, useRef } from "react";
import { Box, Text, VStack, ChakraProvider } from "@chakra-ui/react";
import {
  MapContainer,
  TileLayer,
  Marker,
  Tooltip,
  useMap
} from "react-leaflet";
import "leaflet/dist/leaflet.css";
import "leaflet.polyline.snakeanim";

// Fix for default marker icons
import icon from "leaflet/dist/images/marker-icon.png";
import iconShadow from "leaflet/dist/images/marker-shadow.png";
import L from "leaflet";
import { variables } from "./variables";

let DefaultIcon = L.icon({
  iconUrl: require("./assets/pin.svg").default,
  shadowUrl: iconShadow,
  iconSize: [50, 60],
  
});

L.Marker.prototype.options.icon = DefaultIcon;

// Mock data for geo-locations
const locations = [
  {
    id: 1,
    lat: 50.0471,
    lng: 8.5629,
    timestamp: "2024-03-15 10:30:00",
    name: "ULD #1",
    info: "Cargo received",
  },
  {
    id: 2,
    lat: 50.0379,
    lng: 8.5622,
    timestamp: "2024-03-15 14:45:00",
    name: "ULD #2",
    info: "In transit",
  },
  {
    id: 3,
    lat: 50.038,
    lng: 8.5329,
    timestamp: "2024-03-16 02:15:00",
    name: "ULD #3",
    info: "Customs clearance",
  },
];

declare module "leaflet" {
  interface Polyline {
    snakeIn(options?: { snakingSpeed?: number }): this;
    snakeOut(options?: { snakingSpeed?: number }): this;
  }
}

function PolylineComponent() {
  const map = useMap();
  
  useEffect(() => {
    const polyline = L.polyline(locations.map(location => [location.lat, location.lng]), {
      color: variables.color.yellow,
      weight: 6,
      opacity: 0.75
    });

    polyline.addTo(map);
    polyline.snakeIn({ snakingSpeed: 1000 });

    return () => {
      map.removeLayer(polyline);
    };
  }, [map]);

  return null;
}

export default function GeoMap() {
  const [center] = useState<[number, number]>([50.0421, 8.5629]);
  const [zoom] = useState(14);

  return (
    <ChakraProvider>
      <Box height="500px" width="100%" borderRadius="md" overflow="hidden">
        <MapContainer center={center} zoom={zoom} style={{ height: '100%', width: '100%' }}>
          <TileLayer
            url="https://{s}.google.com/vt/lyrs=s&x={x}&y={y}&z={z}"
            maxZoom={20}
            subdomains={["mt1", "mt2", "mt3"]}
          />
          {locations.map((location) => (
            <Marker key={location.id} position={[location.lat, location.lng]}>
              <Tooltip>
                <VStack align="start" spacing={1}>
                  <Text fontWeight="bold">{location.name}</Text>
                  <Text fontSize="sm">{location.timestamp}</Text>
                  <Text fontSize="sm">{location.info}</Text>
                </VStack>
              </Tooltip>
            </Marker>
          ))}
          <PolylineComponent />
        </MapContainer>
      </Box>
    </ChakraProvider>
  )
}