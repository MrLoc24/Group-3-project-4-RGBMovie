import { apiSlice } from "./apiSlice";
const THEATER_URL = "/api/customer/book";

export const bookingApliSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    booking: builder.mutation({
      query: (data) => ({
        url: `${THEATER_URL}?username=${data.username}&screening=${data.screening}&auditorium=${data.auditorium}&seatName=${data.seatName}`,
        method: "POST",
      }),
    }),
    getCartorHistory: builder.mutation({
      query: (data) => ({
        url: `${THEATER_URL}/${data.action}?userId=${data.id}&resId=${data.resId}`,
        method: "GET",
      }),
    }),
  }),
});

export const { useBookingMutation, useGetCartorHistoryMutation } =
  bookingApliSlice;
