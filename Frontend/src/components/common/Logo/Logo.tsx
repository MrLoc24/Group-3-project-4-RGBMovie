import React from "react";
import { styled, Container, Typography } from "@mui/material";
import "./Logo.css";
// import { VideocamOutlined } from "@mui/icons-material";
// import { Logo as LogoYellow } from "../../../assets";

const CustomeContainer = styled(Container)({
  fontSize: "2rem",
  fontWeight: "lighter",
  display: "flex",
  flexDirection: "column",
  justifyContent: "center",
  alignItems: "center",
  textShadow:
    "#fff 0px 0px 10px,var(--neonPink) 0px 0px 15px,var(--neonPurple) 0px 0px 20px, var(--neonCrimson) 0px 0px 30px",
  //   WebkitTextStroke: "1px rgba(255,47,0,1)",
  color: "white",
});

const Logo = () => {
  return (
    <CustomeContainer>
      <Typography
        className="logo"
        variant="h3"
        sx={{ WebkitTextStroke: "2px var(--neonPink)" }}
      >
        RGB
      </Typography>
      <Typography
        variant="h5"
        sx={{
          textDecoration: "overline",
        }}
      >
        Cinemas
      </Typography>
      {/* <img src={LogoYellow} alt="rgb" width={150} /> */}
    </CustomeContainer>
  );
};

export default Logo;
