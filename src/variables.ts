export const variables = {
  color: {
    yellow: "#f9ba00",
    blue: "#00235f",
    white: "#fff",
    grey: "#7a7a7a",
    lightGrey: "#f5f5f5",
  },
  links: {
    base: "/",
    shipper: {
      base: "/shipment",
      details: "/shipment/*",
    },
    gha: {
      base: "/ground-handling-agent",
      details: "/ground-handling-agent/*",
    },
    qa: {
      base: "/quality-assurance",
      details: "/quality-assurance/*",
    },
  },
  api: {
    shipments: [
      {
        endpoint:
          "http://localhost:8080/logistics-objects/6a94e74d-0d11-5151-8d6b-2befcabe18e0",
      },
    ],
    awbs: [
      { endpoint: "http://localhost:8080/logistics-objects/awb-020-44395433" },
    ],
    ulds: [
      {
        endpoint: "http://localhost:8080/logistics-objects/uld-AKE65849LH",
      },
    ],
  },
  accessToken:
    "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPbTJoUktNNWdOUHJlb2UtQURrU3RscUpjMGNRWVA0RU1od2dyQmhicW0wIn0.eyJleHAiOjE3MjgxNzM5OTAsImlhdCI6MTcyODEzNzk5MSwianRpIjoiOTFkODhhYTItOTVlNy00ZjBiLWIwMWMtMjZhMjI3OTI4MWM3IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4OTg5L3JlYWxtcy9uZW9uZSIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiIwYWU4OThmMy1kMjQ4LTRlYWMtODY4MS1iMDM4MWM4MmQ2YzAiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJuZW9uZS1jbGllbnQiLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1uZW9uZSIsInVtYV9hdXRob3JpemF0aW9uIl19LCJyZXNvdXJjZV9hY2Nlc3MiOnsiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwiY2xpZW50SG9zdCI6IjE5Mi4xNjguNjUuMSIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwibG9naXN0aWNzX2FnZW50X3VyaSI6Imh0dHA6Ly9sb2NhbGhvc3Q6ODA4MC9sb2dpc3RpY3Mtb2JqZWN0cy9fZGF0YS1ob2xkZXIiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJzZXJ2aWNlLWFjY291bnQtbmVvbmUtY2xpZW50IiwiY2xpZW50QWRkcmVzcyI6IjE5Mi4xNjguNjUuMSIsImNsaWVudF9pZCI6Im5lb25lLWNsaWVudCJ9.gwFAopyx_HiWZr2xqt6DDE4nDOxPmNsi8iK0v89tJDdCJS0MxHKJKGGYml2b0SXM1LrCuPoDmI-xNEEEonr5HIO047BMyheewP-PW1Df38iEHFe5F_PqGgvrUIwIeBuSdhGRfHT9rJw2vXIuW1tghCRl3krysKrz-WQfnqwgNb_ZWEjfESiEvU0gJmqUHkeQuNTDdGS45tS8HebyYSNg6Ok_bgX327bOZXXwXCM6N103Cm1CuUBe7gdeL4dgleFS-eAt3JrrzxTzn15OAK2BZnofDYnV90dLic_zUzG4RDsX0M326-rCc5V1ykBZmEzhoNBAtEbIiHmePRnTPAOYow",
};
