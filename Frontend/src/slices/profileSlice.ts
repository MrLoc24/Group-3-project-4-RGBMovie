import { createSlice } from "@reduxjs/toolkit";

const initialState = {
  customerDetail: localStorage.getItem("customerDetail")
    ? JSON.parse(localStorage.getItem("customerDetail") ?? "")
    : null,
};

const profileSlice = createSlice({
  name: "profile",
  initialState,
  reducers: {
    setProfile: (state, action) => {
      state.customerDetail = action.payload;
      localStorage.setItem("customerDetail", JSON.stringify(action.payload));
    },
  },
});

export const { setProfile } = profileSlice.actions;

export default profileSlice.reducer;
