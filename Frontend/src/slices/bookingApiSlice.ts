import { apiSlice } from "./apiSlice";
const THEATER_URL = "/api/customer";

export const bookingApliSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    booking: builder.mutation({
      query: (data) => ({
        url: `${THEATER_URL}/book?username=${data.username}&screening=${data.screening}&auditorium=${data.auditorium}&seatName=${data.seatName}`,
        method: "POST",
      }),
    }),
  }),
});

export const { useBookingMutation } = bookingApliSlice;
