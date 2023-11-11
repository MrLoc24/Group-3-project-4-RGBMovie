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
import { Container, Input, Paper } from "@mui/material";
import { Search } from "@mui/icons-material";
import { useState } from "react";
import { useSelector } from "react-redux";

export default function SlideSection() {
  const [search, setSearch] = useState("");
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const movies = useSelector((state: any) => state.movies.movies);

  return (
    <>
      <Container
        sx={{ marginBottom: "2rem", display: "flex", justifyContent: "center" }}
      >
        {/* Search Field */}
        <Paper
          elevation={0}
          variant="outlined"
          component="div"
          sx={{
            p: "2px 4px",
            display: "flex",
            alignItems: "center",
            marginLeft: "1rem",
            padding: "0.8rem 1.5rem",
            width: "50%",
            borderRadius: "35px",
          }}
        >
          <Input
            fullWidth
            sx={{ ml: 1, flex: 1 }}
            value={search}
            onChange={(e) => setSearch(e.target.value)}
            placeholder="Search movies"
          />
          <Search />
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
        {movies.map((item: any) => {
          if (item.title.toLowerCase().includes(search.toLowerCase())) {
            return (
              <SwiperSlide>
                <MovieCard {...item} />
              </SwiperSlide>
            );
          }
        })}
      </Swiper>
    </>
  );
}
