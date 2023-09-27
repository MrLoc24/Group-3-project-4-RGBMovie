import { apiSlice } from "./apiSlice";
const MOVIE_URL = "/api/movie";

export const moviesApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    findAllMovies: builder.mutation({
      query: () => ({
        url: `${MOVIE_URL}/`,
        method: "GET",
      }),
    }),
    findMoviesByName: builder.mutation({
      query: (data) => ({
        url: `${MOVIE_URL}/search?name=${data}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useFindMoviesByNameMutation, useFindAllMoviesMutation } = moviesApiSlice;
