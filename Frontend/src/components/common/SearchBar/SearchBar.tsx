import * as React from "react";
import { Box, TextField } from "@mui/material";
import "./SearchBar.css";

const SearchBar = ({ placeholder }: { placeholder: string }) => {
  return (
    <Box sx={{ "& > :not(style)": { m: 1 } }}>
      <Box
        sx={{
          display: "flex",
          alignItems: "flex-end",
          justifyContent: "center",
        }}
      >
        <TextField id="input-with-sx" label={placeholder} variant="outlined" />
      </Box>
    </Box>
  );
};

export default SearchBar;
