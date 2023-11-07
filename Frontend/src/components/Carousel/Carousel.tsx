/* eslint-disable @typescript-eslint/no-explicit-any */
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/pagination";
import "swiper/css/navigation";

import "./Carousel.css";

// const carouseSlides = [];

// import required modules
import { Pagination, Navigation, Autoplay } from "swiper/modules";



export default function App() {
  
  return (
    <>
      <Swiper
        slidesPerView={1}
        spaceBetween={30}
        loop={true}
        pagination={{
          clickable: true,
        }}
        autoplay={{
          delay: 2500,
          disableOnInteraction: false,
        }}
        navigation={true}
        modules={[Pagination, Navigation, Autoplay]}
        className="carousel"
      >
        <SwiperSlide>
          <img
            src={
              "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694070783/cinemas/carousel2_f76ipl.jpg"
            }
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            src={
              "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694070786/cinemas/carousel3_obl7yl.jpg"
            }
          />
        </SwiperSlide>
        <SwiperSlide>
          <img
            src={
              "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694070782/cinemas/carousel1_djan9y.jpg"
            }
          />
        </SwiperSlide>
      </Swiper>
    </>
  );
}
