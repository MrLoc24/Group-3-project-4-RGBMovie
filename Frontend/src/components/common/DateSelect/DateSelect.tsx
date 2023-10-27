import { Box, Container, ToggleButton, ToggleButtonGroup } from "@mui/material";
import React, { useEffect, useState } from "react";

const DateSelect = () => {
  const [date, setDate] = useState<string | null>("");
  const [dates, setDates] = useState<Array<Date>>();
  const dayOfWeek = new Map<number, string>();
  dayOfWeek.set(0, "Sun");
  dayOfWeek.set(1, "Mon");
  dayOfWeek.set(2, "Tue");
  dayOfWeek.set(3, "Wed");
  dayOfWeek.set(4, "Thu");
  dayOfWeek.set(5, "Fri");
  dayOfWeek.set(6, "Sat");

  useEffect(() => {
    const startDate = new Date();
    const endDate = new Date();
    endDate.setDate(startDate.getDate() + 14);
    const dateList: Date[] = [];

    for (
      let date = startDate;
      date < endDate;
      date.setDate(date.getDate() + 1)
    ) {
      dateList.push(new Date(date));
    }
    setDates(dateList);
    setDate(startDate.toISOString());
  }, []);

  const handleDateSelect = (
    event: React.MouseEvent<HTMLElement>,
    date: string | null
  ) => {
    setDate(date);
  };

  return (
    <>
      <ToggleButtonGroup
        value={date}
        exclusive
        onChange={handleDateSelect}
        aria-label="date"
        sx={{ display: "flex", flexWrap: "wrap" }}
      >
        {dates
          ? dates.map((item) => (
              <ToggleButton
                value={item.toISOString()}
                key={item.toISOString()}
                sx={{ display: "flex", flexWrap: "wrap" }}
              >
                <Container
                  sx={{
                    display: "flex",
                    alignContent: "center",
                    backgroundColor: "",
                    padding: {
                      md: "0 0.5rem",
                    },
                    width: "5rem",
                  }}
                >
                  <Box>
                    <Box>{item.getMonth().toString()}</Box>
                    <Box>{dayOfWeek.get(item.getDay())}</Box>
                  </Box>
                  <Box
                    sx={{
                      alignSelf: "center",
                      fontSize: "2rem",
                      marginLeft: "0.5rem",
                    }}
                  >
                    {item.getDate().toString()}
                  </Box>
                </Container>
              </ToggleButton>
            ))
          : null}
      </ToggleButtonGroup>
    </>
  );
};

export default DateSelect;
