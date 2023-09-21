import { apiSlice } from "./apiSlice";
const THEATER_URL = "/api/theater";

export const theatersApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    findAllTheater: builder.mutation({
      query: () => ({
        url: `${THEATER_URL}/`,
        method: "GET",
      }),
    }),
    findTheaterById: builder.mutation({
      query: (data) => ({
        url: `${THEATER_URL}/${data}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useFindAllTheaterMutation, useFindTheaterByIdMutation } =
  theatersApiSlice;
