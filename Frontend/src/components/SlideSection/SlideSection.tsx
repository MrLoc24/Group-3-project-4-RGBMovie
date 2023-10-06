import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/effect-coverflow";
import "swiper/css/pagination";
import "./SlideSection.css";

// import required modules
import {
  EffectCoverflow,
  Autoplay,
  Navigation,
  Pagination,
} from "swiper/modules";
import MovieCard from "../common/MovieCard/MovieCard";
import {
  Container,
  FormControl,
  IconButton,
  Input,
  InputLabel,
  MenuItem,
  Paper,
  Select,
} from "@mui/material";
import { Search } from "@mui/icons-material";
import { useState } from "react";
import { useSelector } from "react-redux";

export default function SlideSection() {
  const [search, setSearch] = useState("");
  const [status, setStatus] = useState("Now Showing");
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const movies = useSelector((state: any) => state.movies.movies);
  console.log(movies);

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const handleStatusChange = (event: any) => {
    setStatus(event.target.value);
    console.log(event.target.value);
  };

  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const handleSubmitSearch = (event: any) => {
    event.preventDefault();
    console.log(search);
  };

  return (
    <>
      <Container
        sx={{ marginBottom: "1rem", display: "flex", justifyContent: "center" }}
      >
        {/* Status Select */}
        <Paper
          elevation={0}
          sx={{
            p: "0px",
            display: "flex",
            alignItems: "center",
            width: "30%",
          }}
        >
          <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Status</InputLabel>
            <Select
              labelId="demo-simple-select-label"
              id="demo-simple-select"
              value={status}
              label="Status"
              onChange={handleStatusChange}
            >
              <MenuItem value={"Now Showing"}>Now Showing</MenuItem>
              <MenuItem value={"Comming Soon"}>Comming Soon</MenuItem>
            </Select>
          </FormControl>
        </Paper>

        {/* Search Field */}
        <Paper
          elevation={0}
          variant="outlined"
          component="form"
          sx={{
            p: "2px 4px",
            display: "flex",
            alignItems: "center",
            width: "30%",
            marginLeft: "1rem",
          }}
          onSubmit={handleSubmitSearch}
        >
          <Input
            sx={{ ml: 1, flex: 1 }}
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            placeholder="Search movies"
          />
          <IconButton type="submit">
            <Search />
          </IconButton>
        </Paper>
      </Container>
      <Swiper
        effect={"coverflow"}
        grabCursor={true}
        centeredSlides={true}
        slidesPerView={"auto"}
        coverflowEffect={{
          rotate: 50,
          stretch: 0,
          depth: 100,
          modifier: 1,
          slideShadows: true,
        }}
        navigation={true}
        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        pagination={{
          clickable: true,
        }}
        modules={[EffectCoverflow, Autoplay, Navigation, Pagination]}
        className="slideSection neonBorder"
      >
        {/*eslint-disable-next-line @typescript-eslint/no-explicit-any */}
        {movies.map((item: any) => (
          <SwiperSlide>
            <MovieCard {...item} />
          </SwiperSlide>
        ))}
      </Swiper>
    </>
  );
}
