/* eslint-disable @typescript-eslint/no-explicit-any */
import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import IconButton from "@mui/material/IconButton";
import Typography from "@mui/material/Typography";
import Menu from "@mui/material/Menu";
import MenuIcon from "@mui/icons-material/Menu";
import Container from "@mui/material/Container";
import Button from "@mui/material/Button";
import Tooltip from "@mui/material/Tooltip";
import MenuItem from "@mui/material/MenuItem";
import { useNavigate } from "react-router-dom";
import {
  AccountCircleOutlined,
  LoginOutlined,
  MovieOutlined,
} from "@mui/icons-material";
import { useDispatch, useSelector } from "react-redux";
import { useEffect, useState } from "react";
import { logout } from "../../slices/authSlice";
import { Logo } from "..";
import { BottomNavigation, BottomNavigationAction } from "@mui/material";

const pages = ["Movie", "Theater", "Cart"];
const settings = ["Profile", "Logout"];

function NavigationBar() {
  const { customerInfo } = useSelector((state: any) => state.auth);
  const [username, setUsername] = useState("User");

  useEffect(() => {
    if (customerInfo) {
      const currentDate = new Date();
      const loginDate = new Date(customerInfo.timestamp);
      if ((currentDate - loginDate) / (1000 * 60 * 60 * 24) >= 10) {
        localStorage.clear();
      } else {
        setUsername(customerInfo.username);
      }
    }
  }, [customerInfo]);

  const navigate = useNavigate();
  const dispatch = useDispatch();

  const [anchorElNav, setAnchorElNav] = React.useState<null | HTMLElement>(
    null
  );
  const [anchorElUser, setAnchorElUser] = React.useState<null | HTMLElement>(
    null
  );

  const handleOpenNavMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorElNav(event.currentTarget);
  };
  const handleOpenUserMenu = (event: React.MouseEvent<HTMLElement>) => {
    setAnchorElUser(event.currentTarget);
  };

  const handleNavClick = (e: any) => {
    setAnchorElNav(null);
    let value: string = "";
    if (e.target.value) {
      value = e.target.value;
    } else if (e.currentTarget.dataset) {
      value = e.currentTarget.dataset.myValue;
    }
    switch (value) {
      case "Movie":
        navigate("/movie");
        break;
      case "Theater":
        navigate("/theater");
        break;
      case "Cart":
        navigate("/cart");
        break;
      case "Login":
        navigate("/signin");
        break;
      default:
        break;
    }
  };

  const handleProfileclick = async (e: any) => {
    setAnchorElUser(null);
    const { myValue } = e.currentTarget.dataset;

    switch (myValue) {
      case "Profile":
        navigate("/profile");
        break;
      case "Logout":
        dispatch(logout(""));
        navigate("/");
        break;
      default:
        break;
    }
    setAnchorElUser(null);
  };

  return (
    <AppBar
      position="fixed"
      sx={{
        top: "3%",
        left: "50%",
        width: "100vw",
        height: "8vh",
        transform: "translate(-50%, 0)",
        padding: "0rem 10rem",
        background: "#191717",
        border: "#555843 solid thin",
        justifyContent: "center",
        // "&:hover": {
        //   boxShadow:
        //     "0 0 0.1rem #fff, 0 0 0.2rem #fff, 0 0 2rem var(--neonBlue), 0 0 0.5rem var(--neonBlue)",
        // },
      }}
    >
      <Container
        maxWidth="xl"
        sx={{
          padding: "0.5rem",
        }}
      >
        <Toolbar disableGutters>
          {/* Logo */}
          <Typography
            variant="h6"
            noWrap
            component="a"
            href="#"
            onClick={() => navigate("/")}
            sx={{
              mr: 2,
              display: { xs: "none", md: "flex" },
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            {/* <img className="neonText" src={Logo} alt="Logo" width={150} /> */}
            <Logo />
          </Typography>

          {/* SnackBar */}
          <Box
            sx={{
              flexGrow: 1,
              display: { xs: "flex", md: "none" },
            }}
          >
            <IconButton
              size="large"
              aria-label="account of current user"
              aria-controls="menu-appbar"
              aria-haspopup="true"
              onClick={handleOpenNavMenu}
              color="inherit"
            >
              <MenuIcon />
            </IconButton>
            <Menu
              id="menu-appbar"
              anchorEl={anchorElNav}
              anchorOrigin={{
                vertical: "bottom",
                horizontal: "left",
              }}
              keepMounted
              transformOrigin={{
                vertical: "top",
                horizontal: "left",
              }}
              open={Boolean(anchorElNav)}
              onClose={handleNavClick}
              sx={{
                display: { xs: "block", md: "none" },
              }}
            >
              {pages.map((page) => (
                <MenuItem
                  key={page}
                  data-my-value={page}
                  onClick={handleNavClick}
                >
                  <Typography textAlign="center">{page}</Typography>
                </MenuItem>
              ))}
            </Menu>
          </Box>

          {/* Logo */}
          <Typography
            variant="h5"
            noWrap
            component="a"
            href="#"
            onClick={() => navigate("/")}
            sx={{
              mr: 2,
              display: { xs: "flex", md: "none" },
              flexGrow: 1,
              fontFamily: "monospace",
              fontWeight: 700,
              letterSpacing: ".3rem",
              color: "inherit",
              textDecoration: "none",
            }}
          >
            {/* <img src={Logo} alt="Logo" width={150} /> */}
            <Logo />
          </Typography>
          <BottomNavigation
            showLabels
            sx={{
              flexGrow: 1,
              display: { xs: "none", md: "flex" },
              justifyContent: "center",
              alignItems: "center",
              backgroundColor: "transparent",
            }}
            onChange={(event, newValue) => {
              navigate(newValue);
            }}
          >
            {pages.map((page) => (
              <BottomNavigationAction
                className="neonTextYellow"
                label={page}
                icon={<MovieOutlined />}
                value={page}
              />
            ))}
          </BottomNavigation>

          {customerInfo ? (
            <Box sx={{ flexGrow: 0 }}>
              <Tooltip title="Profile settings">
                <Button
                  variant="outlined"
                  startIcon={<AccountCircleOutlined />}
                  onClick={handleOpenUserMenu}
                  sx={{
                    border: "none",
                    textTransform: "capitalize",
                    fontSize: "1.2rem",
                    "&:hover": {
                      border: "none",
                    },
                  }}
                  size="large"
                >
                  {username}
                </Button>
              </Tooltip>
              <Menu
                sx={{ mt: "45px" }}
                id="menu-appbar"
                anchorEl={anchorElUser}
                anchorOrigin={{
                  vertical: "top",
                  horizontal: "right",
                }}
                keepMounted
                transformOrigin={{
                  vertical: "top",
                  horizontal: "right",
                }}
                open={Boolean(anchorElUser)}
                onClose={handleProfileclick}
              >
                {settings.map((setting) => (
                  <MenuItem
                    key={setting}
                    data-my-value={setting}
                    onClick={handleProfileclick}
                  >
                    <Typography textAlign="center">{setting}</Typography>
                  </MenuItem>
                ))}
              </Menu>
            </Box>
          ) : (
            <Button
              size="large"
              sx={{
                color: "white",
              }}
              value="Login"
              onClick={handleNavClick}
              startIcon={<LoginOutlined />}
            >
              Login
            </Button>
          )}
        </Toolbar>
      </Container>
    </AppBar>
  );
}
export default NavigationBar;
