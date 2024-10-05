export const variables = {
    color: {
        yellow: "#f9ba00",
        blue: "#00235f",
        white: "#fff",
        grey: "#7a7a7a",
        lightGrey: "#f5f5f5"
    },
    links: {
        base: "/",
        shipper: {
            base: "/shipment",
            details: "/shipment/*"
        },
        gha: {
            base: "/ground-handling-agent",
            details: "/ground-handling-agent/*"
        },
        qa: {
            base: "/quality-assurance",
            details: "/quality-assurance/*"
        }
    }
}