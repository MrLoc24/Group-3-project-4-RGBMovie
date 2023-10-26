import { ThemeProvider, createTheme } from "@mui/material/styles";
import { Outlet } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import { NavigationBar, QuickBooking } from "./components";
import "react-toastify/dist/ReactToastify.css";
import { Button, Container, Fab, Modal } from "@mui/material";
import { Add } from "@mui/icons-material";
import { useState } from "react";

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
  const [open, setOpen] = useState(false);
  const handleClose = (event: object, reason: string) => {
    reason == "backdropClick" ? "" : setOpen(false);
  };
  const handleOpen = () => {
    setOpen(true);
  };

  return (
    <ThemeProvider theme={darkTheme}>
      {/* <Header children={<NavigationBar />} /> */}
      <NavigationBar />
      <ToastContainer
        position="top-right"
        autoClose={2000}
        hideProgressBar={false}
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="dark"
      />
      <Container
        sx={{
          marginTop: "3rem",
          height: "70vh",
        }}
      >
        <Modal
          open={open}
          onClose={handleClose}
          aria-labelledby="modal-modal-title"
          aria-describedby="modal-modal-description"
        >
          <QuickBooking handleClose={handleClose} />
        </Modal>
        <Outlet />
        <Button
          className="neonText"
          variant="outlined"
          sx={{
            color: "white",
            position: "fixed",
            bottom: "0%",
            right: "0%",
            width: "15vw",
            padding: "0.7rem 0rem",
            borderRadius: "25px 0 0 0",
            borderRight: "none",
            border: "white",
            boxShadow:
              "0 0 0.2rem #fff, 0 0 0.2rem #fff, 0 0 1rem var(--neonPurple), 0 0 0.5rem var(--neonBlue)",
            "&:hover": {
              borderRight: "none",
            },
          }}
          onClick={handleOpen}
        >
          <Add />
          Book
        </Button>
      </Container>
    </ThemeProvider>
  );
}

export default App;
