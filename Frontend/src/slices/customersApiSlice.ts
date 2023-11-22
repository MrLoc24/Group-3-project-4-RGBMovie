import { apiSlice } from "./apiSlice";
const CUSTOMER_URL = "";

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
    changePassword: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/user/edit/password/${data.username}`,
        method: "POST",
        body: data.body,
      }),
    }),
    profile: builder.mutation({
      query: (username) => ({
        url: `${CUSTOMER_URL}/user/profile/${username}`,
        method: "GET",
      }),
    }),
    recoverPassword: builder.mutation({
      query: (email) => ({
        url: `${CUSTOMER_URL}/customer/recover?email=${email}`,
        method: "POST",
      }),
    }),
    showChangePasswordPage: builder.mutation({
      query: (token) => ({
        url: `${CUSTOMER_URL}/customer/resetPassword?token=${token}`,
        method: "GET",
      }),
    }),
    resetPassword: builder.mutation({
      query: (data) => ({
        url: `${CUSTOMER_URL}/customer/changePassword?newPassword=${data.newPassword}&userId=${data.userId}&token=${data.token}`,
        method: "POST",
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
  useRecoverPasswordMutation,
  useShowChangePasswordPageMutation,
  useResetPasswordMutation,
  useChangePasswordMutation,
} = usersApiSlice;
