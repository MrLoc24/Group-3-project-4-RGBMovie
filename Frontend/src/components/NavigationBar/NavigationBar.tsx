import {
  MovieOutlined,
  TheatersOutlined,
  EventOutlined,
  LockOpenOutlined,
  AccountCircleOutlined,
} from "@mui/icons-material";
import {
  BottomNavigationAction,
  BottomNavigation,
  Typography,
  Box,
  Modal,
  Menu,
  MenuItem,
} from "@mui/material";
import { BookLogo, Logo } from "../../assets";
import { useNavigate } from "react-router-dom";
import { useState, useEffect } from "react";
import { QuickBooking } from "..";
import { useDispatch, useSelector } from "react-redux";
// import { useLogoutMutation } from "../../slices/customersApiSlice";
import { logout } from "../../slices/authSlice";
import { toast } from "react-toastify";

const NavigationBar = () => {
  // Handle auth
  const { customerInfo } = useSelector((state: any) => state.auth);
  const [username, setUsername] = useState("User");

  useEffect(() => {
    if (customerInfo) {
      setUsername(customerInfo.username);
    }
  }, [customerInfo]);

  const dispatch = useDispatch();
  const navigate = useNavigate();

  // const [logoutApiCall] = useLogoutMutation();

  const logoutHandler = async () => {
    try {
      // await logoutApiCall().unwrap();
      setAnchorEl(null);
      dispatch(logout(""));
      navigate("/");
    } catch (error) {
      console.log(error);
    }
  };
  // Handle Close/Open QuickBooking
  const [open, setOpen] = useState(false);

  const handleClose = (event: object, reason: string) => {
    reason == "backdropClick" ? "" : setOpen(false);
  };
  const handleOpen = () => {
    if (customerInfo) {
      setOpen(true);
    } else {
      navigate("/signin");
      toast("Please sign in before booking ticket");
    }
  };

  // Profile menu
  const [anchorEl, setAnchorEl] = useState<null | HTMLElement>(null);
  const openProfile = Boolean(anchorEl);
  const handleClickProfile = (event: React.MouseEvent<HTMLButtonElement>) => {
    setAnchorEl(event.currentTarget);
  };
  const handleCloseProfile = () => {
    setAnchorEl(null);
  };

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
        {customerInfo ? (
          <BottomNavigationAction
            label={username}
            className="neonText"
            icon={<AccountCircleOutlined />}
            aria-controls={openProfile ? "basic-menu" : undefined}
            aria-haspopup="true"
            aria-expanded={openProfile ? "true" : undefined}
            onClick={handleClickProfile}
          />
        ) : (
          <BottomNavigationAction
            label="Sign In"
            className="neonText"
            icon={<LockOpenOutlined />}
            value="signin"
          />
        )}
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

      {/* Profile menu */}
      <Menu
        id="basic-menu"
        anchorEl={anchorEl}
        open={openProfile}
        onClose={handleCloseProfile}
        MenuListProps={{
          "aria-labelledby": "basic-button",
        }}
      >
        <MenuItem onClick={handleCloseProfile}>Profile</MenuItem>
        <MenuItem onClick={logoutHandler}>Logout</MenuItem>
      </Menu>
    </Box>
  );
};

export default NavigationBar;
