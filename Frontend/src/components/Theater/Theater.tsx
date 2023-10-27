/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useEffect, useState } from "react";
import { SelectChangeEvent } from "@mui/material/Select";
import { CustomContainer, LocationMenu, ShowingTimesSection } from "..";
import DateSelect from "../common/DateSelect/DateSelect";
import { useSelector } from "react-redux";

const Theater = () => {
  const [location, setLocation] = useState("");
  const [theater, setTheater] = useState("");
  const [locations, setLocations] = useState<any[]>([]);
  const [theaters, setTheaters] = useState<any[]>([]);
  const [films, setFilms] = useState<any[]>([]);
  const theaterList = useSelector((state: any) => state.theaters.theaters);
  const movieList = useSelector((state: any) => state.movies.movies);

  useEffect(() => {
    const subLocation = theaterList.map((item: any) => {
      return item.subLocation;
    });
    const uniqueLocation = new Set(subLocation);
    setLocations(Array.from(uniqueLocation));
  }, []);

  const handleLocationSelect = (event: SelectChangeEvent) => {
    setLocation(event.target.value);

    const listTheater = theaterList.filter(
      (item: any) => item.subLocation == event.target.value
    );

    setTheaters(listTheater);
  };

  const handleTheaterSelect = (event: SelectChangeEvent) => {
    setTheater(event.target.value);
    const index = theaters.findIndex((item) => item.name == event.target.value);
    const filmList = theaters[index].films;
    setFilms(
      filmList.map((film: any) => {
        const movie = movieList.find((item: any) => item.id == film.id);
        return { ...film, name: movie.title, image: movie.image };
      })
    );
  };

  return (
    <>
      {/* Choose Location */}
      <LocationMenu
        location={location}
        theater={theater}
        handleTheaterSelect={handleTheaterSelect}
        handleLocationSelect={handleLocationSelect}
        locationList={locations}
        theaterList={theaters}
      />

      {/* Choose Date */}
      {theaters.length !== 0 ? (
        <CustomContainer>
          <DateSelect />
        </CustomContainer>
      ) : null}

      {films ? <ShowingTimesSection films={films} /> : null}
    </>
  );
};

export default Theater;
