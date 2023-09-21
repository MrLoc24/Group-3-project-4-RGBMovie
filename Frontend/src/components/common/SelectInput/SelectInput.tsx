import * as React from "react";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";

export declare interface SelectInputProps {
  status: Array<string>;
}

export default function SelectInput({ status }: SelectInputProps) {
  return (
    <Box
      component="form"
      sx={{
        "& .MuiTextField-root": { m: 1, width: "25ch" },
      }}
      noValidate
      autoComplete="off"
    >
      <div>
        <TextField
          id="outlined-select-currency-native"
          select
          label=""
          defaultValue="EUR"
          SelectProps={{
            native: true,
          }}
        >
          {status.map((value: string) => (
            <option key={value} value={value}>
              {value}
            </option>
          ))}
        </TextField>
      </div>
    </Box>
  );
}
