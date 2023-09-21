import React, { useEffect, useState } from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import { CustomerContainer, ShowingTimesSection } from "..";
import DateSelect from "../common/DateSelect/DateSelect";
import { useSelector } from "react-redux";

const Theater = () => {
  const [locationIndex, setLocationIndex] = useState("");
  const [theaterIndex, setTheaterIndex] = useState("");
  const [locations, setLocations] = useState<any[]>([]);
  const [theaters, setTheaters] = useState<any[]>([]);
  const [films, setFilms] = useState<any[]>([]);
  const [movies, setMovies] = useState<any[]>([]);
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const theaterList = useSelector((state: any) => state.theaters.theaters);
  // eslint-disable-next-line @typescript-eslint/no-explicit-any
  const movieList = useSelector((state: any) => state.movies.movies);

  useEffect(() => {
    setLocations(theaterList.location);
    setMovies(movieList);
  }, []);

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocationIndex(event.target.value);
    const index = parseInt(event.target.value);
    setTheaters(locations[index].theaters);
  };

  const hadnleTheaterSelect = (event: SelectChangeEvent) => {
    setTheaterIndex(event.target.value);
    const index = parseInt(event.target.value);
    const filmList = theaters[index].films;
    setFilms(
      filmList.map((film: any) => {
        const movie = movies.find((item) => item.id == film.id);
        return { ...film, name: movie.title, image: movie.image };
      })
    );
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
            value={locationIndex}
            onChange={handleLocationSelect}
            label="Location"
          >
            {/* eslint-disable-next-line @typescript-eslint/no-explicit-any */}
            {locations
              ? locations.map(({ name }, index) => (
                  <MenuItem key={name} value={`${index}`}>
                    {name}
                  </MenuItem>
                ))
              : null}
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
            value={theaterIndex}
            onChange={hadnleTheaterSelect}
            label="Theater"
          >
            {theaters
              ? theaters.map(
                  // eslint-disable-next-line @typescript-eslint/no-explicit-any
                  ({ name }, index) => (
                    <MenuItem key={name} value={`${index}`}>
                      {name}
                    </MenuItem>
                  )
                )
              : null}
          </Select>
        </FormControl>
      </CustomerContainer>

      {/* Choose Date */}
      {films ? (
        <CustomerContainer>
          <DateSelect />
        </CustomerContainer>
      ) : null}

      {films ? <ShowingTimesSection films={films} /> : null}
    </>
  );
};

export default Theater;
