import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  customerInfo: localStorage.getItem("customerInfo")
    ? JSON.parse(localStorage.getItem("customerInfo") ?? "")
    : null,
};

const authSlice = createSlice({
  name: "auth",
  initialState,
  reducers: {
    setCredentials: (state, action) => {
      state.customerInfo = action.payload;
      localStorage.setItem("customerInfo", JSON.stringify(action.payload));
    },
    // eslint-disable-next-line @typescript-eslint/no-unused-vars
    logout: (state, action) => {
      state.customerInfo = null;
      localStorage.removeItem("customerInfo");
    },
  },
});

export const { setCredentials, logout } = authSlice.actions;

export default authSlice.reducer;
