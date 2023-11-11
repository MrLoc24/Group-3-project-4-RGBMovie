/* eslint-disable @typescript-eslint/no-explicit-any */
import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Link from "@mui/material/Link";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import Container from "@mui/material/Container";
import { useNavigate } from "react-router-dom";
import { useState } from "react";
import { toast } from "react-toastify";
import { useRegisterMutation } from "../../slices/customersApiSlice";

export default function SignUp() {
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  const [register] = useRegisterMutation();

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (password !== confirmPassword) {
      toast.error("Password do not match");
    } else {
      try {
        await register({
          username,
          firstName,
          lastName,
          phoneNumber,
          email,
          password,
        });
        toast.success("Sign up successfully");
        navigate("/signin");
      } catch (error: any) {
        toast(error?.data?.message || error.error);
      }
    }
  };

  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate("/signin");
  };

  return (
    <Container
      component="main"
      maxWidth="xs"
      sx={{
        background:
          "#121212 linear-gradient(rgba(255, 255, 255, 0.11), rgba(255, 255, 255, 0.11))",
        paddingBottom: "2rem",
        boxShadow:
          "0px 3px 5px -1px rgba(0,0,0,0.2), 0px 6px 10px 0px rgba(0,0,0,0.14), 0px 1px 18px 0px rgba(0,0,0,0.12)",
      }}
    >
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}>
          <LockOutlinedIcon />
        </Avatar>
        <Typography component="h1" variant="h5">
          Sign up
        </Typography>
        <Box component="form" onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                error={firstName.length > 30}
                autoComplete="given-name"
                name="firstName"
                required
                fullWidth
                id="firstName"
                label="First Name"
                autoFocus
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
                helperText={firstName.length > 30 ? "Maximum 30 letters" : ""}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                error={lastName.length > 30}
                required
                fullWidth
                id="lastName"
                label="Last Name"
                name="lastName"
                autoComplete="family-name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
                helperText={lastName.length > 30 ? "Maximum 30 letters" : ""}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                error={!/^[a-z0-9_]+$/.test(username) && username.length != 0}
                required={true}
                fullWidth
                id="username"
                label="Username"
                name="username"
                autoComplete="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
                helperText={
                  !/^[a-z0-9_]+$/.test(username) && username.length != 0
                    ? "Only characters a-z, digits and '_' are  acceptable"
                    : ""
                }
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                error={
                  !/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/.test(email) &&
                  email.length !== 0
                }
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                helperText={
                  !/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[A-Za-z]+$/.test(email) &&
                  email.length !== 0
                    ? "Invalid email address"
                    : ""
                }
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                error={
                  !/[0-9]{10,}/.test(phoneNumber) && phoneNumber.length !== 0
                }
                required
                fullWidth
                id="phone"
                label="Phone Number"
                name="phone"
                autoComplete="phone"
                value={phoneNumber}
                onChange={(e) => setPhoneNumber(e.target.value)}
                helperText={
                  !/[0-9]{10,}/.test(phoneNumber) && phoneNumber.length !== 0
                    ? "Invalid phone number (at least 10 digits)"
                    : ""
                }
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="password"
                label="Password"
                type="password"
                id="password"
                autoComplete="new-password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                name="confirmPassword"
                label="Confirm Password"
                type="password"
                id="confirmPassword"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
              />
            </Grid>
          </Grid>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            Sign Up
          </Button>
          <Grid container justifyContent="flex-end">
            <Grid item>
              <Link href="#" variant="body2" onClick={handleNavigate}>
                Already have an account? Sign in
              </Link>
            </Grid>
          </Grid>
        </Box>
      </Box>
    </Container>
  );
}
