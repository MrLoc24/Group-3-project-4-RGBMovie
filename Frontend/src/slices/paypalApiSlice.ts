/* eslint-disable @typescript-eslint/no-explicit-any */
import { apiSlice } from "./apiSlice";
const THEATER_URL = "/api";

export const paypalApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    paypalCreateOrder: builder.mutation({
      query: (data: any) => ({
        url: `${THEATER_URL}/orders?id=${data}`,
        method: "POST",
      }),
    }),
    paypalOnApprove: builder.mutation({
      query: (data: any) => ({
        url: `${THEATER_URL}/orders/${data.orderID}/capture?id=${data.id}`,
        method: "POST",
      }),
    }),
  }),
});

export const { usePaypalCreateOrderMutation, usePaypalOnApproveMutation } = paypalApiSlice;
