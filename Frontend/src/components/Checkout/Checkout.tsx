/* eslint-disable @typescript-eslint/no-explicit-any */
import { Box, Button, Container } from "@mui/material";
import { BasicTable } from "..";

const Checkout = ({ listCheckout, handleClose }: any) => {
  return (
    <Box
      sx={{
        display: "flex",
        flexDirection: "column",
        position: "absolute",
        top: "50%",
        left: "50%",
        transform: "translate(-50%, -50%)",
        width: "90vw",
        bgcolor: "background.paper",
        border: "2px solid #000",
        boxShadow: 24,
        p: 4,
      }}
    >
      <BasicTable rows={listCheckout} />
      <div
        style={{
          display: "flex",
          justifyContent: "space-around",
          margin: "1rem 0rem 0rem 0rem",
          padding: "0px !important",
        }}
      >
        <Button variant="outlined" fullWidth>
          Payment
        </Button>
        <Button variant="outlined" fullWidth onClick={handleClose}>
          Cancel
        </Button>
      </div>
    </Box>
  );
};

export default Checkout;
