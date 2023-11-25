import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.tsx";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import "./index.css";
import {
  Carousel,
  SignIn,
  SlideSection,
  Theater,
  SignUp,
  PrivateRoute,
  ForgotPassword,
  NewPassword,
} from "./components/index.ts";
import {
  CartScreen,
  HistoryScreen,
  LoginScreen,
  ProfileScreen,
  SectionScreen,
} from "./screens";
import { Provider } from "react-redux";
import store from "./store.ts";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<App />}>
      <Route
        index={true}
        path="/"
        element={<SectionScreen child={<Carousel />} />}
      />
      <Route
        path="/movie"
        element={
          <SectionScreen
            selectInput={["Now Showing", "Comming Soon"]}
            searchInput="Search movies"
            title="Movie Selection"
            child={<SlideSection />}
          />
        }
      />
      <Route
        path="/theater"
        element={<SectionScreen title="Theater" child={<Theater />} />}
      />
      <Route path="/signin" element={<LoginScreen child={<SignIn />} />} />
      <Route path="/signup" element={<LoginScreen child={<SignUp />} />} />
      <Route path="/forgot" element={<ForgotPassword />} />
      <Route path="/resetPassword" element={<NewPassword />} />

      {/* Private Routes */}
      <Route path="" element={<PrivateRoute />}>
        <Route path="/history" element={<HistoryScreen />} />
        <Route path="/cart" element={<CartScreen />} />
        <Route path="/profile" element={<ProfileScreen />} />
      </Route>
    </Route>
  )
);

ReactDOM.createRoot(document.getElementById("root")!).render(
  <Provider store={store}>
    <React.StrictMode>
      <RouterProvider router={router} />
    </React.StrictMode>
  </Provider>
);
