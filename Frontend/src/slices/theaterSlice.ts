import { createSlice } from "@reduxjs/toolkit";

const theaterSlice = createSlice({
  name: "theaters",
  initialState: { theaters: {} },
  reducers: {
    addTheaters: (state, action) => {
      state.theaters = action.payload;
    },
  },
});
export const { addTheaters } = theaterSlice.actions;
export default theaterSlice.reducer;
