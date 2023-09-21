import { apiSlice } from "./apiSlice";
const CUSTOMER_URL = "/api/customers";

export const usersApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/auth`,
        method: "POST",
        body: data,
      }),
    }),
    register: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}`,
        method: "POST",
        body: data,
      }),
    }),
    logout: builder.mutation({
      query: () => ({
        url: `${CUSTOMER_URL}/logout`,
        method: "POST",
      }),
    }),
    updateCustomer: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/profile`,
        method: "PUT",
        body: data,
      }),
    }),
  }),
});

export const {
  useLoginMutation,
  useLogoutMutation,
  useRegisterMutation,
  useUpdateCustomerMutation,
} = usersApiSlice;
