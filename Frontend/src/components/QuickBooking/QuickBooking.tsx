/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  Box,
  Button,
  Card,
  Container,
  Grid,
  SelectChangeEvent,
} from "@mui/material";
import "./QuickBooking.css";
import {
  Detail,
  PaymentSelect,
  ShowingTime,
  CustomContainer,
  LocationMenu,
  Poster,
  SeatsSelect,
} from "..";
import DateSelect from "../common/DateSelect/DateSelect";
import { forwardRef, useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { ArrowBackOutlined } from "@mui/icons-material";

const style = {
  display: "flex",
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "70rem",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

// eslint-disable-next-line @typescript-eslint/no-explicit-any
const QuickBooking = forwardRef(({ handleClose }: any) => {
  // States of Location
  const [location, setLocation] = useState("");
  const [theater, setTheater] = useState("");
  const [locations, setLocations] = useState<any[]>([]);
  const [theaters, setTheaters] = useState<any[]>([]);

  // States of CheckingForm
  const [movieId, setMovieId] = useState<any>();
  const [movieName, setMovieName] = useState<any>("");
  const [movieImage, setMovieImage] = useState<any>("");
  const [runningTime, setRunningTime] = useState("");
  const [timedate, setTimeDate] = useState("");
  const [room, setRoom] = useState("");
  const [seats, setSeats] = useState([]);
  const [price, setPrice] = useState("");
  const [payment, setPayment] = useState("");

  const [showingTime, setShowingTime] = useState<any>();

  const theaterList = useSelector((state: any) => state.theaters.theaters);
  const movieList = useSelector((state: any) => state.movies.movies);

  useEffect(() => {
    const subLocation = theaterList.map((item: any) => {
      return item.subLocation;
    });
    const uniqueLocation = new Set(subLocation);
    setLocations(Array.from(uniqueLocation));
  }, []);

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocation(event.target.value);

    const listTheater = theaterList.filter(
      (item: any) => item.subLocation == event.target.value
    );

    setTheaters(listTheater);
  };
  
  const handleTheaterSelect = (event: SelectChangeEvent) => {
    setTheater(event.target.value);
    // const index = theaters.findIndex((item) => item.name == event.target.value);
    // const filmList = theaters[index].films;
    // // setShowingTime(filmList.find((item: any) => item.id == movieId));
    // const film = filmList.find((item: any) => item.id == movieId);
    // setShowingTime(film.format);
  };

  const handleMovieClick = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.target);
    setMovieId(data.get("id"));
    setMovieName(data.get("title"));
    setMovieImage(data.get("image"));
  };

  const handleBack = () => {
    setMovieId(null);
    setMovieName(null);
    setMovieImage(null);
    setLocation("");
    setTheater("");
    setRunningTime("");
    setSeats([]);
    setTimeDate("");
    setPayment("");
    setPrice("");
    setPrice("");
    setShowingTime(null);
  };

  return (
    <Box sx={style}>
      <Grid container spacing={2}>
        {/* Select Movies */}
        {movieName ? null : (
          <Grid item xs={6} md={8}>
            <Grid container spacing={2}>
              {movieList.map((item: any) => (
                <Grid item xs={4} md={4}>
                  {/* <MovieCard {...item} />; */}
                  <Poster
                    key={item.id}
                    {...item}
                    handleClick={handleMovieClick}
                  />
                </Grid>
              ))}
            </Grid>
          </Grid>
        )}

        {/* Select Showingtime */}
        {movieName ? (
          <Grid
            item
            xs={6}
            md={8}
            sx={{
              display: "flex",
              flexDirection: "column",
              justifyContent: "space-around",
            }}
          >
            {/* Location Select */}
            <LocationMenu
              location={location}
              theater={theater}
              handleTheaterSelect={handleTheaterSelect}
              handleLocationSelect={handleLocationSelect}
              locationList={locations}
              theaterList={theaters}
            />
            {/* Theater Select */}
            {theater ? (
              <CustomContainer>
                <DateSelect />
              </CustomContainer>
            ) : null}

            {/* ShowingTimes Select */}
            {movieId ? (
              <CustomContainer>
                <Container
                  sx={{
                    display: "block",
                    justifyContent: "center",
                    color: "var(--textPrimary)",
                    paddingLeft: {
                      md: "0rem",
                    },
                  }}
                >
                  {showingTime?.map(({ name, showingTimes }: any) => (
                    <ShowingTime format={name} showingTime={showingTimes} />
                  ))}
                </Container>
              </CustomContainer>
            ) : null}
            <Container
              sx={{
                marginLeft: "0.5rem",
              }}
            >
              <Button
                variant="outlined"
                startIcon={<ArrowBackOutlined />}
                onClick={handleBack}
              >
                Back
              </Button>
            </Container>
          </Grid>
        ) : null}

        {/* Select seats */}
        {timedate ? <SeatsSelect /> : null}

        {/* Show Information and payment select */}
        <Grid item xs={6} md={4}>
          <Card sx={{ marginBottom: "0.5rem" }}>
            <Detail
              name={movieName}
              image={movieImage}
              id={movieId}
              runningTime={runningTime}
              theater={theater}
              seats={seats}
              timedate={timedate}
              room={room}
              price={price}
              payment={payment}
            />
          </Card>
          <PaymentSelect />
          <Container
            sx={{
              width: "-webkit-fill-available",
              display: "flex",
              justifyContent: "space-between",
              padding: {
                md: "0rem",
              },
              marginTop: "0.5rem",
            }}
          >
            <Button variant="outlined" fullWidth>
              Book
            </Button>
            <Button variant="outlined" fullWidth onClick={handleClose}>
              Cancel
            </Button>
          </Container>
        </Grid>
      </Grid>
    </Box>
  );
});

export default QuickBooking;
