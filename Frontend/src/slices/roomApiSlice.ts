import { apiSlice } from "./apiSlice";
const THEATER_URL = "/api/auditorium";

export const roomApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    getRoomById: builder.mutation({
      query: (id) => ({
        url: `${THEATER_URL}/${id}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useGetRoomByIdMutation } = roomApiSlice;
