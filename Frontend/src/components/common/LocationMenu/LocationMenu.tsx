import React, { useState } from "react";
import { CustomerContainer } from "../..";
import {
  FormControl,
  InputLabel,
  MenuItem,
  Select,
  SelectChangeEvent,
} from "@mui/material";

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

const LocationMenu = () => {
  const [location, setLocation] = useState("");
  const [theater, setTheater] = useState("");

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocation(event.target.value);
  };

  const hadnleTheaterSelect = (event: SelectChangeEvent) => {
    setTheater(event.target.value);
  };
  return (
    <CustomerContainer>
      <FormControl
        variant="standard"
        sx={{ m: 1, minWidth: 120, width: "100%" }}
      >
        <InputLabel id="demo-simple-select-standard-label">Location</InputLabel>
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
        <InputLabel id="demo-simple-select-standard-label">Theater</InputLabel>
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
  );
};

export default LocationMenu;
