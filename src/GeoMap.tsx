"use client";

import { useState, useEffect } from "react";
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

import L from "leaflet";
import { variables } from "./variables";
import { locations } from "./mockData";

let DefaultIcon = L.icon({
  iconUrl: require("./assets/pin.svg").default,
  iconSize: [50, 60],
});

L.Marker.prototype.options.icon = DefaultIcon;

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
      weight: 5,
      opacity: 0.75
    });

    polyline.addTo(map);

    // Calculate the total length of the polyline
    const totalLength = locations.reduce((total, location, index, array) => {
        if (index === 0) return 0;
        const prevLocation = array[index - 1];
        const latLng1 = L.latLng(prevLocation.lat, prevLocation.lng);
        const latLng2 = L.latLng(location.lat, location.lng);
        return total + latLng1.distanceTo(latLng2);
      }, 0);
  
      // Set the desired duration in milliseconds (e.g., 50000ms for 50 seconds)
      const desiredDurationMs = 50000;
  
      // Calculate the speed (meters per millisecond)
      const speed = totalLength / desiredDurationMs;
  
      // Set the snaking speed for the animation
      polyline.snakeIn({ snakingSpeed: speed });

    return () => {
      map.removeLayer(polyline);
    };
  }, [map]);

  return null;
}

interface DataPoint {
  id: number,
  lat: number,
  lng: number,
  timestamp: string,
  name: string,
  info: string
}

interface GeoMapProps {
  points: DataPoint[]
}

export default function GeoMap({points}: GeoMapProps) {
  const [center] = useState<[number, number]>([50.042514,8.542955]);
  const [zoom] = useState(17);

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