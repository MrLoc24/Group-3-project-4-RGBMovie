import React from "react";
import { ShowingTimeProps } from "../../interfaces/ShowingTimeProps";
import { Button, Container } from "@mui/material";


const ShowingTime = ({ format, showingTime }: ShowingTimeProps) => {
  const handleClick = () => {
    console.log("Showing Time Click");
  };
  return (
    <>
      <Container sx={{ display: "block", width: "100%" }}>
        <Container>{format}</Container>
        <Container sx={{ display: "flex", flexWrap: "wrap" }}>
          {showingTime.map((item) => (
            <Button variant="outlined" onClick={handleClick}>
              {item}/
            </Button>
          ))}
        </Container>
      </Container>
    </>
  );
};

export default ShowingTime;
