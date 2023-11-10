/* eslint-disable @typescript-eslint/no-explicit-any */
import { Box, Button } from "@mui/material";
import { BasicTable, PaypalCheckoutButton } from "..";

const Checkout = ({ listCheckout, handleClose }: any) => {
  const product = {
    description: "RGB Ticket - Movie: Monster",
    price: 4,
  };
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
        overflowY: "auto",
        maxHeight: "80vh",
      }}
    >
      <BasicTable rows={listCheckout} />
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-between",
          gap: "1rem",
          alignItems: "center",
          margin: "1rem 0rem 0rem 0rem",
          padding: "0px !important",
        }}
      >
        <div className="paypal-button-container">
          <PaypalCheckoutButton product={product} />
        </div>
        <Button variant="outlined" fullWidth onClick={handleClose}>
          Cancel
        </Button>
      </div>
    </Box>
  );
};

export default Checkout;
