import React from "react";
import { CardProps } from "../../../interfaces";
import { Button, Grid, Typography } from "@mui/material";
import MovieDetail from "../../MovieDetail/MovieDetail";
import { ReceiptOutlined } from "@mui/icons-material";

const Poster = ({ title, image, content, handleClick, id }: CardProps) => {
  return (
    <>
      <Grid
        container
        component={"form"}
        onSubmit={handleClick}
        sx={{
          width: "auto",
          height: "20rem",
          background: `url('${image}') no-repeat center`,
          backgroundSize: "contain",
          "&:hover .overlayContent": {
            display: "flex",
          },
        }}
      >
        <input hidden type="number" value={id} name="id" />
        <input hidden type="text" value={image} name="image" />
        <input hidden type="text" value={title} name="title" />
        <Grid item md={12} sx={{ height: "3rem" }}></Grid>
        <Grid
          className="overlayContent"
          container
          md={12}
          sx={{
            display: "none",
            "&:hover": {
              display: "flex",
            },
            background: "rgba(0, 0, 0, 0.7)",
            textShadow: "2px 2px rgba(0, 0, 0, 0.9)",
            color: "#f1f1f1" /* Grey text */,
            width: "auto" /* Full width */,
            padding: "1rem" /* Some padding */,
            textAlign: "center",
          }}
        >
          <Grid item md={12}>
            <Typography variant="h5">{title}</Typography>
          </Grid>
          <Grid item md={12}>
            <Typography
              sx={{
                overflow: "hidden",
                textOverflow: "ellipsis",
                display: "-webkit-box",
                WebkitLineClamp: "2",
                WebkitBoxOrient: "vertical",
              }}
            >
              {content}
            </Typography>
          </Grid>
          <Grid container md={12}>
            <Grid item md={6}>
              <Button
                variant="outlined"
                type="submit"
                startIcon={<ReceiptOutlined />}
              >
                Book
              </Button>
            </Grid>
            <Grid item md={6}>
              <MovieDetail image={image} title={title} description={content} />
            </Grid>
          </Grid>
        </Grid>
      </Grid>
    </>
  );
};

export default Poster;
