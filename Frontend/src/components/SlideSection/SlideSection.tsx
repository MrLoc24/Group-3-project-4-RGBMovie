import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/effect-coverflow";
import "swiper/css/pagination";
import "./SlideSection.css";

// import required modules
import { EffectCoverflow, Autoplay, Navigation, Pagination} from "swiper/modules";
import MovieCard from "../common/MovieCard/MovieCard";
import { CardProps } from "../../interfaces/CardProps";
import { ReceiptOutlined } from "@mui/icons-material";

const posters: CardProps[] = [
  {
    title: "Raven",
    image: "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071362/cinemas/poster/Raven_uld5z7.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",
    primaryButton: {
      label: "Book",
      icon: <ReceiptOutlined />,
    },
    secondaryButton: true,
  },
  {
    title: "Animus",
    image: "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071213/cinemas/poster/Animus_mp66wi.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",
    primaryButton: {
      label: "Book",
      icon: <ReceiptOutlined />,
    },
    secondaryButton: true,
  },
  {
    title: "Faith",
    image: "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071219/cinemas/poster/Faith_wcgvn9.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",
    primaryButton: {
      label: "Book",
      icon: <ReceiptOutlined />,
    },
    secondaryButton: true,
  },
  {
    title: "Highway",
    image: "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071343/cinemas/poster/Highway_akssin.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",
    primaryButton: {
      label: "Book",
      icon: <ReceiptOutlined />,
    },
    secondaryButton: true,
  },
  {
    title: "Monster",
    image: "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071348/cinemas/poster/Monster_l6a7yj.png",
    content:
      "Lorem ipsum dolor sit amet consectetur adipisicing elit. Amet, deserunt! Consequatur architecto doloribus quibusdam accusantium!",
    primaryButton: {
      label: "Book",
      icon: <ReceiptOutlined />,
    },
    secondaryButton: true,
  },
];

export default function App() {
  return (
    <>
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
          clickable: true
        }}
        modules={[EffectCoverflow, Autoplay, Navigation, Pagination]}
        className="slideSection neonBorder"
      >
        {posters.map((item) => (
          <SwiperSlide>
            <MovieCard {...item}/>
          </SwiperSlide>
        ))}
      </Swiper>
    </>
  );
}
