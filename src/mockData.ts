export const mockAwbData = {
    product: "General Cargo",
    pieces: 5,
    weight: 500,
    origin: "LAX",
    destination: "JFK",
    recentMilestone: "DEP",
  };
  
export const mockStatusHistory = [
    {
      flight: "LH8401",
      origin: "PVG",
      destination: "FRA",
      event: "BKD",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH8401",
      origin: "FRA",
      destination: "BUD",
      event: "ARR",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH8401",
      origin: "FRA",
      destination: "BUD",
      event: "DEP",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
  ];

  export // Mock data for geo-locations
  const locations = [
    {
      id: 1,
      lat: 50.042669,
      lng: 8.539264,
      timestamp: "2024-03-15 10:30:00",
      name: "ULD #1",
      info: "Cargo received",
    },
    {
      id: 2,
      lat: 50.042514,
      lng: 8.542955,
      timestamp: "2024-03-15 14:45:00",
      name: "ULD #2",
      info: "In transit",
    },
    {
      id: 3,
      lat: 50.041405,
      lng: 8.543497,
      timestamp: "2024-03-16 02:15:00",
      name: "ULD #3",
      info: "Customs clearance",
    },
  ];