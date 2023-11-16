/* eslint-disable @typescript-eslint/no-explicit-any */
import { ThemeProvider, createTheme } from "@mui/material/styles";
import { Outlet } from "react-router-dom";
import { ToastContainer } from "react-toastify";
import { NavigationBar, QuickBooking } from "./components";
import "react-toastify/dist/ReactToastify.css";
import { Button, Container, Modal } from "@mui/material";
import { Add } from "@mui/icons-material";
import { useState } from "react";
import { useEffect } from "react";
import { useFindAllMoviesMutation } from "./slices/moviesApiSlice";
import { addMovies } from "./slices/movieSlice";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { useFindAllTheaterMutation } from "./slices/theatersApiSlice";
import { addTheaters } from "./slices/theaterSlice";
import { PayPalScriptProvider } from "@paypal/react-paypal-js";

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

  const dispatch = useDispatch();

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [findAllMovies] = useFindAllMoviesMutation();
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [findAllTheater] = useFindAllTheaterMutation();

  useEffect(() => {
    try {
      findAllMovies("").then((result: any) => {
        const movieList = result.data.map((item: any) => {
          return {
            id: item.pk,
            title: item.title,
            runningTime: item.durationMin,
            content: item.description,
            rated: item.age,
            releaseDate: item.openingDate,
            genres: item.genre,
            image: item.mainImg,
            price: item.price,
          };
        });

        dispatch(addMovies(movieList));
      });

      findAllTheater("").then((result: any) => {
        const theaters = result.data;
        dispatch(addTheaters(theaters));
      });

      // eslint-disable-next-line @typescript-eslint/no-explicit-any
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  }, []);

  return (
    <PayPalScriptProvider
      options={{
        clientId:
          "AfhvgFWMucHa47s_kR3z6YG-4m2cVW3CGcr1rEMlCyZUEXnydt0IevhjjayttiDOmsRK74ptUMRpRoan",
      }}
    >
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
            marginBottom: "3rem",
            height: "70vh",
            width: "100%",
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
              // background: "#191717",
              background: "none",
              position: "fixed",
              bottom: "2%",
              right: "2%",
              width: "8vw",
              padding: "0.7rem 0rem",
              borderRadius: "15px",
              border: "#555843 solid",
              "&:hover": {
                border: "#555843 solid",
                background: "#191717",
                boxShadow:
                  "0 0 0.1rem #fff, 0 0 1rem var(--neonPurple), 0 0 0.5rem var(--neonBlue)",
              },
              zIndex: "999",
              fontSize: {
                xs: "0.7rem",
                sm: "0.7rem",
                md: "1rem",
              },
            }}
            onClick={handleOpen}
            startIcon={
              <Add
                sx={{
                  fontSize: {
                    xs: 40,
                    sm: 50,
                    md: 60,
                  },
                }}
              />
            }
          >
            Book
          </Button>
        </Container>
      </ThemeProvider>
    </PayPalScriptProvider>
  );
}

export default App;
