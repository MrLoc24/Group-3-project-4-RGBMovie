import { ThemeProvider, createTheme } from "@mui/material/styles";
import { Outlet } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import { Header, NavigationBar } from "./components";

const darkTheme = createTheme({
  palette: {
    mode: "dark",
  },
  components: {
    MuiBottomNavigationAction: {
      styleOverrides: {
        label: {
          fontSize: "1.25rem",
          marginLeft: "1rem",
          marginRight: "1rem",
        },
      },
    },
  },
});

function App() {
  return (
    <ThemeProvider theme={darkTheme}>
      <Header children={<NavigationBar />} />
      <ToastContainer />
      <Outlet />
    </ThemeProvider>
  );
}

export default App;
