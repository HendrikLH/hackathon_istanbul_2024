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
    const colors = ["green", "green", "green"];

    const animatePolyline = (index: number) => {
      if (index >= locations.length - 1) return; // Stop if no more locations

      const prevLocation = locations[index];
      const location = locations[index + 1];

      const polyline = L.polyline(
        [
          [prevLocation.lat, prevLocation.lng],
          [location.lat, location.lng]
        ],
        {
          color: colors[index % colors.length],
          weight: 5,
          opacity: 0.75
        }
      );

      polyline.addTo(map);

      const distance = L.latLng(prevLocation.lat, prevLocation.lng).distanceTo(L.latLng(location.lat, location.lng));
      const duration = 5000; // 5 seconds per polyline animation
      const speed = distance / duration;

      // Start the snaking animation and wait for it to finish before animating the next polyline
      polyline.snakeIn({ snakingSpeed: speed });

      setTimeout(() => {
        // Animate the next polyline after the current one is done
        animatePolyline(index + 1);
      }, duration / 3); // Wait for the duration of the current polyline animation before moving to the next
    };

    // Start animating from the first polyline
    animatePolyline(0);

    return () => {
      map.eachLayer(layer => {
        if (layer instanceof L.Polyline) {
          map.removeLayer(layer);
        }
      });
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