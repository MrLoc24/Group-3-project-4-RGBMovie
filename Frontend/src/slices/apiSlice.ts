import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const URI = process.env["REACT_APP_BACKEND_URL"] || "http://localhost:8080/api";

const baseQuery = fetchBaseQuery({
  baseUrl: URI,
  // credentials: "same-origin",
  // mode: "cors",
  prepareHeaders: (headers) => {
    if (localStorage.getItem("customerInfo")) {
      const token = JSON.parse(localStorage.getItem("customerInfo") ?? "");
      headers.set("Authorization", `Bearer ${token.accessToken}`);
    }
    headers.set("Content-Type", "application/json");
    console.log(URI);
    return headers;
  },
});

export const apiSlice = createApi({
  baseQuery,
  tagTypes: [
    "Customer",
    "Movie",
    "Theater",
    "Screening",
    "Auditorium",
    "Booking",
    "Paypal",
  ],
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  endpoints: (builder) => ({}),
});
