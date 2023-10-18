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
import { useEffect } from "react";
import { useFindAllMoviesMutation } from "../../slices/moviesApiSlice";
import { addMovies } from "../../slices/movieSlice";
import { useDispatch } from "react-redux";
import { toast } from "react-toastify";
import { CardProps } from "../../interfaces";
import { useFindAllTheaterMutation } from "../../slices/theatersApiSlice";
import { addTheaters } from "../../slices/theaterSlice";

// eslint-disable-next-line @typescript-eslint/no-unused-vars
const posters: CardProps[] = [
  {
    id: 1,
    title: "Raven",
    image:
      "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071362/cinemas/poster/Raven_uld5z7.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",

    secondaryButton: true,
  },
  {
    id: 2,
    title: "Animus",
    image:
      "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071213/cinemas/poster/Animus_mp66wi.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",

    secondaryButton: true,
  },
  {
    id: 3,
    title: "Faith",
    image:
      "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071219/cinemas/poster/Faith_wcgvn9.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",

    secondaryButton: true,
  },
  {
    id: 4,
    title: "Highway",
    image:
      "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071343/cinemas/poster/Highway_akssin.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",

    secondaryButton: true,
  },
  {
    id: 5,
    title: "Monster",
    image:
      "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071348/cinemas/poster/Monster_l6a7yj.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",

    secondaryButton: true,
  },
];

// eslint-disable-next-line @typescript-eslint/no-explicit-any, @typescript-eslint/no-unused-vars
const locations: any = {
  location: [
    {
      name: "Ho Chi Minh",
      theaters: [
        {
          name: "RGB Ly Chinh Thang",
          films: [
            {
              id: 1,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 2,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 3,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
          ],
        },
        {
          name: "RGB Cong Hoa",
          films: [
            {
              id: 1,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 2,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 3,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
          ],
        },
      ],
    },
    {
      name: "Bien Hoa",
      theaters: [
        {
          name: "RGB Bien Hoa",
          films: [
            {
              id: 1,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 2,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 3,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
          ],
        },
        {
          name: "RGB BigC",
          films: [
            {
              id: 1,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 2,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
            {
              id: 3,
              format: [
                {
                  name: "2D - Engsub",
                  showingTimes: [
                    "11:00 A.M",
                    "12:00 P.M",
                    "1:30 P.M",
                    "3:45 P.M",
                    "7:00 P.M",
                  ],
                },
                {
                  name: "3D - Engsub",
                  showingTimes: ["1:30 P.M", "3:45 P.M", "7:00 P.M"],
                },
                {
                  name: "IMAX - Engsub",
                  showingTimes: ["8:45 P.M", "9:00 P.M"],
                },
              ],
            },
          ],
        },
      ],
    },
  ],
};

export default function App() {
  const dispatch = useDispatch();

  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [findAllMovies] = useFindAllMoviesMutation();
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [findAllTheater] = useFindAllTheaterMutation();

  useEffect(() => {
    try {
      findAllMovies("").then((result) => {
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
        dispatch(addTheaters(locations));
      });

      // eslint-disable-next-line @typescript-eslint/no-explicit-any
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  }, []);
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
