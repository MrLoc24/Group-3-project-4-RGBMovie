import { createSlice } from "@reduxjs/toolkit";

const cartSlice = createSlice({
  name: "movies",
  initialState: { cart: [] },
  reducers: {
    addCart: (state, action) => {
      state.cart = action.payload;
    },
  },
});
export const { addCart } = cartSlice.actions;
export default cartSlice.reducer;
