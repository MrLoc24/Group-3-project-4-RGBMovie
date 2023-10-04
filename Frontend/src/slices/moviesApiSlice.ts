import { apiSlice } from "./apiSlice";
const MOVIE_URL = "/api/movie";

export const moviesApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    findAllMovies: builder.mutation({
      query: () => ({
        url: `${MOVIE_URL}`,
        method: "GET",
      }),
    }),
    findMoviesByName: builder.mutation({
      query: (id) => ({
        url: `${MOVIE_URL}/${id}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useFindMoviesByNameMutation, useFindAllMoviesMutation } =
  moviesApiSlice;
