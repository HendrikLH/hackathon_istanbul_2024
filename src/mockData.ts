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
      event: "FOH",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH001",
      origin: "FRA",
      destination: "BUD",
      event: "FOW",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH2191",
      origin: "FRA",
      destination: "BUD",
      event: "BKA",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH002",
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
      flight: "LH0204",
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
      origin: "PVG",
      destination: "FRA",
      event: "BKD",
      station: "PVG (Shanghai)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    }

  ];

  export const mockQAOverview = [
    {
      flight: "LH8401",
      origin: "PVG",
      destination: "FRA",
      event: "FOH",
      station: "FRA (Frankfurt)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH3948",
      origin: "IST",
      destination: "FRA",
      event: "FOH",
      station: "IST (Istanbul)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH571",
      origin: "ATL",
      destination: "FRA",
      event: "DEP",
      station: "ATL (Atlanta)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
    {
      flight: "LH8401",
      origin: "BRE",
      destination: "FRA",
      event: "BKD",
      station: "BRE (Bremen)",
      plannedTime: "2023-05-15 10:00",
      actualTime: "2023-05-15 10:00",
      plannedPieces: "15 / 2595 kg",
      actualPieces: "15 / 2959 kg",
    },
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
    }
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
    {
      id: 4,
      lat: 50.041424,
      lng: 8.540463,
      timestamp: "2024-03-16 02:15:00",
      name: "ULD #4",
      info: "Customs clearance",
    },
    {
      id: 5,
      lat: 50.040308,
      lng: 8.543563,
      timestamp: "2024-03-16 02:15:00",
      name: "ULD #3",
      info: "Customs clearance",
    },
    {
      id: 6,
      lat: 50.036653,
      lng: 8.539532,
      timestamp: "2024-03-16 02:15:00",
      name: "ULD #3",
      info: "Customs clearance",
    },
  ];