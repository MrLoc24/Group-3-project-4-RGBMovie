import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./slices/authSlice";
import { apiSlice } from "./slices/apiSlice";
import movieReducer from "./slices/movieSlice";
import theaterReducer from "./slices/theaterSlice";
import profileReducer from "./slices/profileSlice";
import cartReducer from "./slices/cartSlice";

const store = configureStore({
  reducer: {
    auth: authReducer,
    [apiSlice.reducerPath]: apiSlice.reducer,
    movies: movieReducer,
    theaters: theaterReducer,
    profile: profileReducer,
    cart: cartReducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(apiSlice.middleware),
  devTools: true,
});

export default store;
