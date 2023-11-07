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
  CustomContainer,
  LocationMenu,
  Poster,
  SeatsSelect,
} from "..";
import DateSelect from "../common/DateSelect/DateSelect";
import { forwardRef, useEffect, useState } from "react";
import { useSelector } from "react-redux";
import { ArrowBackOutlined } from "@mui/icons-material";
import { useFindScreeningByMovieAndTheaterMutation } from "../../slices/screeningApiSlice";
import { toast } from "react-toastify";
import { useGetRoomByIdMutation } from "../../slices/roomApiSlice";

const style = {
  display: "flex",
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "100vw",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

const occupiedList = ["A1", "B1", "B2", "B3", "C2"];

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
  const [room, setRoom] = useState(null);
  const [seats, setSeats] = useState([]);
  const [price, setPrice] = useState("");
  const [payment, setPayment] = useState("");
  const [showingTime, setShowingTime] = useState(null);
  const [date, setDate] = useState<string | null>(null);

  const [showingTimeList, setShowingTimeList] = useState<any>([]);
  const [showingTimes, setShowingTimes] = useState<any>(null);
  const [dates, setDates] = useState<any>([]);

  const theaterList = useSelector((state: any) => state.theaters.theaters);
  const movieList = useSelector((state: any) => state.movies.movies);

  const [screenings] = useFindScreeningByMovieAndTheaterMutation();
  const [auditorium] = useGetRoomByIdMutation();

  useEffect(() => {
    const subLocation = theaterList.map((item: any) => {
      return item.subLocation;
    });
    const uniqueLocation = new Set(subLocation);
    setLocations(Array.from(uniqueLocation));

    // Set Start Date
    const startDate = new Date();
    setDate(startDate.toISOString());
  }, []);

  const handleMovieClick = (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.target);
    setMovieId(data.get("id"));
    const selectedMovie = movieList.find(
      (item: any) => item.id == data.get("id")
    );

    setMovieName(selectedMovie.title);
    setMovieImage(selectedMovie.image);
    setRunningTime(selectedMovie.runningTime);
  };

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocation(event.target.value);

    const listTheater = theaterList.filter(
      (item: any) => item.subLocation == event.target.value
    );

    setTheaters(listTheater);
  };

  const handleTheaterSelect = async (event: SelectChangeEvent) => {
    setTheater(event.target.value);
    try {
      const selectedScreening = theaterList.find(
        (item: any) => item.address === event.target.value
      );

      const listScreening = await screenings({
        theater: selectedScreening.pk,
        movie: movieId,
      });

      const dates = listScreening.data.map((item: any) =>
        item.time.substring(0, 10)
      );

      const startDate = new Date();
      const dateList: Date[] = [];
      const setOfDates = Array.from(new Set(dates));
      setOfDates.forEach((element: any) => {
        const dateItem = new Date(element);
        if (dateItem >= startDate) {
          dateList.push(dateItem);
        }
      });
      setDates(dateList);
      setShowingTimeList(listScreening.data);
      setShowingTimes(
        listScreening.data.filter(
          ({ time }: any) => time.substring(0, 10) === date?.substring(0, 10)
        )
      );
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  };

  const handleDateSelect = (
    event: React.MouseEvent<HTMLElement>,
    date: string | null
  ) => {
    setDate(date);
    setShowingTimes(
      showingTimeList.filter(
        ({ time }: any) => time.substring(0, 10) === date?.substring(0, 10)
      )
    );
  };

  const handleShowingTimeClick = async (e: any) => {
    const selectedScreening = showingTimeList.find(
      (item: any) => item.pk == e.target.value
    );

    try {
      const auditorimInfo = await auditorium(selectedScreening.auditorium);
      setRoom(auditorimInfo.data);
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }

    setShowingTime(e.target.value);

    setTimeDate(selectedScreening.time);
  };

  const handleBack = () => {
    if (showingTime) {
      setShowingTime(null);
      setRoom(null);
    } else {
      setMovieId(null);
      setMovieName(null);
      setMovieImage(null);
      setLocation("");
      setTheater("");
      setRunningTime("");
      setSeats([]);
      setTimeDate("");
      setRoom(null);
      setPayment("");
      setPrice("");
      setShowingTimeList(null);
      setShowingTime(null);
      setShowingTimes(null);
      const startDate = new Date();
      setDate(startDate.toISOString());
      setDates(null);
    }
  };

  return (
    <Box sx={style}>
      <Grid container spacing={2}>
        {/* Select Movies */}
        {movieName ? null : (
          <Grid
            item
            xs={6}
            md={8}
            style={{
              overflowY: "scroll",
              maxHeight: "80vh",
              maxWidth: "100%",
              overflowX: "hidden",
            }}
          >
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

        {/* Select Showingtime and Seats */}
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
            style={{}}
          >
            {/* Location & Theater Select */}
            {movieId && !showingTime ? (
              <LocationMenu
                location={location}
                theater={theater}
                handleTheaterSelect={handleTheaterSelect}
                handleLocationSelect={handleLocationSelect}
                locationList={locations}
                theaterList={theaters}
              />
            ) : null}
            {/* Date Select */}
            {dates && !showingTime ? (
              <CustomContainer>
                <DateSelect
                  dates={dates}
                  handleDateSelect={handleDateSelect}
                  date={date}
                />
              </CustomContainer>
            ) : null}

            {/* ShowingTimes Select */}
            {theater && !showingTime ? (
              <Container
                sx={{
                  display: "flex",
                  justifyContent: "start",
                  color: "var(--textPrimary)",
                  paddingLeft: {
                    md: "1rem",
                  },
                }}
              >
                {showingTimes?.map(({ pk, time }: any) => (
                  <Container sx={{ display: "flex" }}>
                    <Button
                      variant="outlined"
                      onClick={handleShowingTimeClick}
                      value={pk}
                    >
                      {time.substr(11, 5)}
                    </Button>
                  </Container>
                ))}
              </Container>
            ) : null}

            {/* Select seats */}
            {showingTime ? (
              <Container
                style={{
                  overflowY: "scroll",
                  maxHeight: "80vh",
                  maxWidth: "100%",
                  overflowX: "hidden",
                }}
              >
                <SeatsSelect
                  column={5}
                  row={10}
                  occupied={occupiedList}
                  price={price}
                />
              </Container>
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
              timeDate={timedate
                .replace("T", " ")
                .replace(":", "h")
                .substring(0, 16)}
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
