/* eslint-disable @typescript-eslint/no-explicit-any */
import { Grid } from "@mui/material";

const Detail = ({
  id,
  image,
  name,
  runningTime,
  theater,
  timeDate,
  room,
  seats,
  price,
  payment,
  handleFinalSubmit,
}: any) => {
  return (
    <Grid
      container
      component={"form"}
      onSubmit={handleFinalSubmit}
      spacing={2}
      sx={{
        height: "35rem",
        width: "auto",
        background: `url('${image}') center`,
        backgroundSize: "cover",
        paddingLeft: "1rem",
      }}
    >
      <Grid item xs={12} height={"12rem"}></Grid>

      {/* Term */}
      <Grid
        item
        xs={4}
        sx={{
          background: "rgba(33,33,33,0.5)",
          color: "var(--textPrimary)",
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-evenly",
        }}
      >
        <Grid item md={12}>
          Name
        </Grid>
        <Grid item md={12}>
          Running Time
        </Grid>
        <Grid item md={12}>
          Theater
        </Grid>
        <Grid item md={12}>
          Date & Time
        </Grid>
        <Grid item md={12}>
          Room
        </Grid>
        <Grid item md={12}>
          Seats
        </Grid>
        <Grid item md={12}>
          Price
        </Grid>
        <Grid item md={12}>
          Payment
        </Grid>
      </Grid>

      {/* Value  */}
      <Grid
        item
        xs={8}
        sx={{
          background: "rgba(33,33,33,0.5)",
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-evenly",
        }}
      >
        <Grid item md={12}>
          {name}
        </Grid>
        <Grid item md={12}>
          {runningTime} minutes
        </Grid>
        <Grid item md={12}>
          {theater}
        </Grid>
        <Grid item md={12}>
          {timeDate}
        </Grid>
        <Grid item md={12}>
          {room ? room.name : null}
        </Grid>
        <Grid item md={12}>
          {seats}
        </Grid>
        <Grid item md={12}>
          $ {price}
        </Grid>
        <Grid item md={12}>
          {payment}
        </Grid>
      </Grid>
    </Grid>
  );
};

export default Detail;
