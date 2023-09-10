import React, { useState } from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import { CustomerContainer, ShowingTime } from "..";
import DateSelect from "../common/DateSelect/DateSelect";
import { Card, Container } from "@mui/material";

const dumpData: { location: Array<string>; theater: Array<string> } = {
  location: [
    "Ho Chi Minh",
    "Ha Noi",
    "Da Nang",
    "Dong Nai",
    "Ba Ria - Vung Tau",
    "Hai Phong",
    "Con Dao",
  ],
  theater: [
    "RGB Ly Chinh Thang",
    "RGB Hung Vuong",
    "RGB Su Van Hanh",
    "RGB Cong Hoa",
  ],
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

const Theater = () => {
  const [location, setLocation] = useState("");
  const [theater, setTheater] = useState("");

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocation(event.target.value);
  };

  const hadnleTheaterSelect = (event: SelectChangeEvent) => {
    setTheater(event.target.value);
  };

  return (
    <>
      {/* Choose Location */}
      <CustomerContainer>
        <FormControl
          variant="standard"
          sx={{ m: 1, minWidth: 120, width: "100%" }}
        >
          <InputLabel id="demo-simple-select-standard-label">
            Location
          </InputLabel>
          <Select
            labelId="demo-simple-select-standard-label"
            id="demo-simple-select-standard"
            value={location}
            onChange={handleLocationSelect}
            label="Location"
          >
            {dumpData.location.map((location) => (
              <MenuItem key={location} value={location}>
                {location}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
        <FormControl
          variant="standard"
          sx={{ m: 1, minWidth: 120, width: "100%" }}
        >
          <InputLabel id="demo-simple-select-standard-label">
            Theater
          </InputLabel>
          <Select
            labelId="demo-simple-select-standard-label"
            id="demo-simple-select-standard"
            value={theater}
            onChange={hadnleTheaterSelect}
            label="Theater"
          >
            {dumpData.theater.map((theater) => (
              <MenuItem key={theater} value={theater}>
                {theater}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </CustomerContainer>

      {/* Choose Date */}
      <CustomerContainer>
        <DateSelect />
      </CustomerContainer>

      {/* Choose Film and Showingtime */}
      <CustomerContainer>
        <Container
          sx={{ justifyContent: "left", display: "flex", width: "fit-content" }}
        >
          <Card>
            <img
              src={
                "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071353/cinemas/poster/Stallion_fy0pxn.png"
              }
              alt="raven"
              width={300}
            />
          </Card>
        </Container>
        <Container
          sx={{
            display: "block",
            justifyContent: "center",
            color: "var(--textPrimary)",
          }}
        >
          {dunmpShowingTimeData.map((item) => (
            <ShowingTime format={item.format} showingTime={item.showingTime} />
          ))}
        </Container>
      </CustomerContainer>
      <CustomerContainer>
        <Container
          sx={{ justifyContent: "left", display: "flex", width: "fit-content" }}
        >
          <Card>
            <img
              src={
                "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071345/cinemas/poster/NightParty_noxwho.png"
              }
              alt="raven"
              width={300}
            />
          </Card>
        </Container>
        <Container
          sx={{
            display: "block",
            justifyContent: "center",
            color: "var(--textPrimary)",
          }}
        >
          {dunmpShowingTimeData.map((item) => (
            <ShowingTime format={item.format} showingTime={item.showingTime} />
          ))}
        </Container>
      </CustomerContainer>
      <CustomerContainer>
        <Container
          sx={{ justifyContent: "left", display: "flex", width: "fit-content" }}
        >
          <Card>
            <img
              src={
                "https://res.cloudinary.com/dlv6zjsif/image/upload/v1694071359/cinemas/poster/TheJourney_llcno4.png"
              }
              alt="raven"
              width={300}
            />
          </Card>
        </Container>
        <Container
          sx={{
            display: "block",
            justifyContent: "center",
            color: "var(--textPrimary)",
          }}
        >
          {dunmpShowingTimeData.map((item) => (
            <ShowingTime format={item.format} showingTime={item.showingTime} />
          ))}
        </Container>
      </CustomerContainer>
    </>
  );
};

export default Theater;
