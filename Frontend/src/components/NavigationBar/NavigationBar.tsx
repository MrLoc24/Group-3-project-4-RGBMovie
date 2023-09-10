import {
  MovieOutlined,
  TheatersOutlined,
  EventOutlined,
  NewspaperOutlined,
} from "@mui/icons-material";
import {
  BottomNavigationAction,
  BottomNavigation,
  Typography,
  Box,
} from "@mui/material";
import { LogoColor, LogoTicket } from "../../assets";
import { useNavigate } from "react-router-dom";

const NavigationBar = () => {
  const navigate = useNavigate();
  return (
    <Box alignContent={"center"}>
      <BottomNavigation
        showLabels
        style={{
          backgroundColor: "transparent",
          justifyContent: "center",
          minHeight: "7rem",
          alignItems: "center",
        }}
        onChange={(event, newValue) => {
          navigate(newValue);
        }}
      >
        <Typography
          className="neonImagePink"
          variant="h2"
          noWrap
          component="a"
          href="/"
          sx={{
            display: "block",
            mx: "2rem",
          }}
        >
          <img src={LogoColor} alt="Logo" width={200} />
        </Typography>
        <BottomNavigationAction
          label="Movies"
          className="neonText flicker"
          icon={<MovieOutlined />}
          value="movie"
        />
        <BottomNavigationAction
          label="Theaters"
          className="neonText"
          icon={<TheatersOutlined />}
          value="theater"
        />
        <BottomNavigationAction
          label="Events"
          className="neonText"
          icon={<EventOutlined />}
        />
        <BottomNavigationAction
          label="News"
          className="neonText"
          icon={<NewspaperOutlined />}
          value="news"
        />
        <Typography
          className="neonImagePink"
          variant="h2"
          noWrap
          component="a"
          href="/"
          sx={{
            display: "block",
            mx: "2rem",
          }}
        >
          <img src={LogoTicket} alt="Logo" width={100} />
        </Typography>
      </BottomNavigation>
    </Box>
  );
};

export default NavigationBar;
