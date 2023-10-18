import { apiSlice } from "./apiSlice";
const CUSTOMER_URL = "/api";

export const usersApiSlice = apiSlice.injectEndpoints({
  endpoints: (builder) => ({
    login: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/auth`,
        method: "POST",
        body: data,
        headers: {
          "Content-type": "application/json",
        },
      }),
    }),
    register: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/signup`,
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
        url: `${CUSTOMER_URL}/user/edit`,
        method: "POST",
        body: data,
      }),
    }),
    profile: builder.mutation({
      query: (username) => ({
        url: `${CUSTOMER_URL}/user/profile/${username}`,
        method: "GET",
      }),
    }),
  }),
});

export const {
  useLoginMutation,
  useLogoutMutation,
  useRegisterMutation,
  useUpdateCustomerMutation,
  useProfileMutation,
} = usersApiSlice;
