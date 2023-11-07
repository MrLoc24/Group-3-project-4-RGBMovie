import React from "react";
import { styled, Container, Typography } from "@mui/material";
import "./Logo.css";
// import { VideocamOutlined } from "@mui/icons-material";
// import { Logo as LogoYellow } from "../../../assets";

const CustomeContainer = styled(Container)({
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
        sx={{
          WebkitTextStroke: "2px var(--neonBlue)",
          fontSize: { xs: "1rem", sm: "2rem", md: "3rem" },
          margin: "0px",
          padding: "0px",
        }}
      >
        RGB
      </Typography>
      <Typography
        sx={{
          textDecoration: "overline",
          fontSize: {
            xs: "0.5rem",
            sm: "1rem",
            md: "1.5rem",
          },
        }}
      >
        Cinemas
      </Typography>
      {/* <img src={LogoYellow} alt="rgb" width={150} /> */}
    </CustomeContainer>
  );
};

export default Logo;
