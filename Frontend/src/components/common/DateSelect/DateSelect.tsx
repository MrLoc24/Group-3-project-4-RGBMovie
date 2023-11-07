/* eslint-disable @typescript-eslint/no-explicit-any */
import { Box, Container, ToggleButton, ToggleButtonGroup } from "@mui/material";

const DateSelect = ({ handleDateSelect, date, dates }: any) => {
  const dayOfWeek = new Map<number, string>();
  dayOfWeek.set(0, "Sun");
  dayOfWeek.set(1, "Mon");
  dayOfWeek.set(2, "Tue");
  dayOfWeek.set(3, "Wed");
  dayOfWeek.set(4, "Thu");
  dayOfWeek.set(5, "Fri");
  dayOfWeek.set(6, "Sat");

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
          ? dates.map((item:any) => (
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
