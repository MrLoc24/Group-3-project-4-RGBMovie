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
import { Carousel, SlideSection, Theater } from "./components/index.ts";
import { SectionScreen } from "./screens";

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
      <Route path="/login" />
      {/* Private Routes */}
      <Route path="">
        <Route path="/profile" />
      </Route>
    </Route>
  )
);

ReactDOM.createRoot(document.getElementById("root")!).render(
  // <Provider store={store}></Provider>
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
  // </Provider>
);
