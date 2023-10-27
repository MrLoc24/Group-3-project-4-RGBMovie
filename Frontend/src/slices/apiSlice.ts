import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";

const baseQuery = fetchBaseQuery({
  baseUrl: "http://localhost:8080",
  // credentials: "same-origin",
  // mode: "cors",
  prepareHeaders: (headers) => {
    if (localStorage.getItem("customerInfo")) {
      const token = JSON.parse(localStorage.getItem("customerInfo") ?? "");
      headers.set("Authorization", `Bearer ${token.accessToken}`);
    }
    return headers;
  },
});

export const apiSlice = createApi({
  baseQuery,
  tagTypes: ["Customer", "Movie", "Theater"],
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  endpoints: (builder) => ({}),
});
