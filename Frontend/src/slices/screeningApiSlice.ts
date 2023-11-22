import { apiSlice } from "./apiSlice";
const THEATER_URL = "/screening";

export const screeningApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    findScreeningByMovieAndTheater: builder.mutation({
      query: (data) => ({
        url: `${THEATER_URL}?theater=${data.theater}&movie=${data.movie}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useFindScreeningByMovieAndTheaterMutation } = screeningApiSlice;
