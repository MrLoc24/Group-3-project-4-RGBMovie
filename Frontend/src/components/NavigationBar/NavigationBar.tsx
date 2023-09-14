import {
  MovieOutlined,
  TheatersOutlined,
  EventOutlined,
  LockOpenOutlined,
} from "@mui/icons-material";
import {
  BottomNavigationAction,
  BottomNavigation,
  Typography,
  Box,
  Modal,
} from "@mui/material";
import { BookLogo, Logo } from "../../assets";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { QuickBooking } from "..";

const NavigationBar = () => {
  const [open, setOpen] = useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = (event: object, reason: string) => {
    reason == "backdropClick" ? "" : setOpen(false);
  };
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
          className="neonImagePurple logoHover"
          variant="h2"
          noWrap
          component="a"
          href="#"
          onClick={() => navigate("/")}
          sx={{
            display: "block",
            mx: "2rem",
          }}
        >
          <img src={Logo} alt="Logo" width={170} />
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
          label="Sign In"
          className="neonText"
          icon={<LockOpenOutlined />}
          value="signin"
        />
        <Typography
          className="logoHover neonImagePurple"
          variant="h2"
          noWrap
          component="a"
          href="#"
          onClick={handleOpen}
          sx={{
            display: "block",
            mx: "2rem",
          }}
        >
          <img src={BookLogo} alt="Logo" width={160} />
        </Typography>
      </BottomNavigation>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <QuickBooking handleClose={handleClose} />
      </Modal>
    </Box>
  );
};

export default NavigationBar;
