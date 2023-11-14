/* eslint-disable @typescript-eslint/no-explicit-any */
import React, { useState } from "react";
import { useRecoverPasswordMutation } from "../../slices/customersApiSlice";
import { Button, Container, Paper, TextField, Typography } from "@mui/material";
import { KeyOutlined } from "@mui/icons-material";

const ForgotPassword = () => {
  const [email, setEmail] = useState("");
  const [hide, setHide] = useState(false);
  const [recoverPassword] = useRecoverPasswordMutation();

  async function handleSubmit(event: any): Promise<void> {
    event.preventDefault();
    const res = await recoverPassword(email);
    console.log(res);
    setHide(true);
  }

  return (
    <Container
      component={Paper}
      elevation={3}
      sx={{
        width: "30vw",
        padding: "2rem 5rem",
        display: "flex",
        flexDirection: "column",
        gap: "2rem",
        justifyContent: "space-between",
        alignItems: "center",
        position: "fixed",
        top: "20%",
        right: "35%",
      }}
    >
      {!hide ? (
        <>
          <KeyOutlined />
          <Typography
            sx={{
              fontSize: {
                md: "1.8rem",
                sm: "1rem",
              },
            }}
          >
            Password Recovery
          </Typography>
          <TextField
            fullWidth
            required
            label={"Recovery Email"}
            variant="standard"
            onChange={(e: object) => setEmail(e.target.value)}
          />
          <Button
            variant="contained"
            fullWidth
            onClick={handleSubmit}
            sx={{
              fontSize: {
                sm: "0.5rem",
                md: "1rem",
              },
            }}
          >
            Confirm
          </Button>
        </>
      ) : (
        <Container
          sx={{
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
            gap: "2rem",
          }}
        >
          <Typography variant="h5">Password Reset</Typography>
          <Typography
            align="center"
            bgcolor={"background.paper"}
            padding={"1rem"}
          >
            An email has been sent to {email} with instructions for resetting
            your password
          </Typography>
        </Container>
      )}
    </Container>
  );
};

export default ForgotPassword;
