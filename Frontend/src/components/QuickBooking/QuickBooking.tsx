import { Box, Button, Card, Container, Grid } from "@mui/material";
import "./QuickBooking.css";
import { LocationMenu, PaymentSelect, ShowingTime } from "..";
import CustomContainer from "../common/Container/CustomContainer";
import DateSelect from "../common/DateSelect/DateSelect";

const style = {
  display: "flex",
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "70rem",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};
const dunmpShowingTimeData = [
  {
    format: "3D",
    showingTime: [
      "11:00 AM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
    ],
  },
  {
    format: "2D",
    showingTime: [
      "11:00 AM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
      "12:00 PM",
    ],
  },
  { format: "IMAX", showingTime: ["11:00 AM", "12:00 PM", "12:00 PM"] },
];


const QuickBooking = ({ handleClose }) => {
  return (
    <Box sx={style}>
      <Grid container spacing={2}>
        {/* Select Showingtime */}
        <Grid item xs={6} md={8}>
          <LocationMenu />
          <CustomContainer>
            <DateSelect />
          </CustomContainer>
          <CustomContainer>
            <Container
              sx={{
                display: "block",
                justifyContent: "center",
                color: "var(--textPrimary)",
                paddingLeft: {
                  md: "0rem",
                },
              }}
            >
              {dunmpShowingTimeData.map((item) => (
                <ShowingTime
                  format={item.format}
                  showingTime={item.showingTime}
                />
              ))}
            </Container>
          </CustomContainer>
        </Grid>
        {/* Show Information and payment select */}
        <Grid item xs={6} md={4}>
          <Card sx={{ marginBottom: "0.5rem" }}>
            <img
              className="imageCard"
              src="https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071219/cinemas/poster/Faith_wcgvn9.png"
              alt="faith"
            />
          </Card>
          <PaymentSelect />
          <Container
            sx={{
              width: "100%",
              display: "flex",
              justifyContent: "space-between",
              padding: {
                md: "0rem",
              },
              marginTop: "0.5rem",
            }}
          >
            <Button variant="outlined" fullWidth>
              Book
            </Button>
            <Button variant="outlined" fullWidth onClick={handleClose}>
              Cancel
            </Button>
          </Container>
        </Grid>
      </Grid>
    </Box>
  );
};

export default QuickBooking;
