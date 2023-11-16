/* eslint-disable @typescript-eslint/no-explicit-any */
import {
  Avatar,
  Box,
  Button,
  Container,
  CssBaseline,
  Grid,
  Modal,
  Paper,
  TextField,
  Typography,
} from "@mui/material";
import React, { useEffect, useState } from "react";
import { toast } from "react-toastify";
import {
  useChangePasswordMutation,
  useProfileMutation,
  useUpdateCustomerMutation,
} from "../slices/customersApiSlice";
import { useDispatch, useSelector } from "react-redux";
import { setProfile } from "../slices/profileSlice";

const ProfileScreen = () => {
  const [pk, setPk] = useState("");
  const [username, setUsername] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [oldPassword, setOldPassword] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [email, setEmail] = useState("");
  const [phoneNumber, setPhoneNumber] = useState("");

  const [open, setOpen] = useState(false);
  const handleClose = () => {
    setOpen(false);
  };
  const handleOpenModal = (): void => {
    setOpen(true);
  };

  const { customerDetail } = useSelector((state: any) => state.profile);

  useEffect(() => {
    setPk(customerDetail.data.pk);
    setUsername(customerDetail.data.username);
    setFirstName(customerDetail.data.firstName);
    setLastName(customerDetail.data.lastName);
    setEmail(customerDetail.data.email);
    setPhoneNumber(customerDetail.data.phoneNumber);
  }, [customerDetail]);

  const [update] = useUpdateCustomerMutation();
  const [profile] = useProfileMutation();
  const [changePassword] = useChangePasswordMutation();
  const dispatch = useDispatch();

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    if (password !== confirmPassword) {
      toast.error("Password do not match");
    } else {
      try {
        await update({
          pk,
          username,
          firstName,
          lastName,
          phoneNumber,
          email,
        });
        toast.success("Update successfully");
        const profileDetail: any = await profile(username);
        if (profileDetail.error) {
          toast(profileDetail.error.error);
        } else {
          dispatch(setProfile({ ...profileDetail }));
        }
        window.location.reload();
      } catch (error: any) {
        toast(error?.data?.message || error.error);
      }
    }
  };

  const handleChangePassword = async (
    event: React.FormEvent<HTMLFormElement>
  ) => {
    event.preventDefault();
    if (password !== confirmPassword) {
      toast.error("Password do not match");
    } else if (password === oldPassword) {
      toast.error("New password is the same as current password");
    } else {
      try {
        const result: any = await changePassword({
          username: username,
          body: {
            password: oldPassword,
            newPassword: password,
          },
        });
        if (result.error.originalStatus == 400) {
          toast.error("Current password is wrong");
        } else {
          toast.success("Update Password Successfully");
          window.location.reload();
        }
      } catch (error: any) {
        toast(error?.data?.message || error.error);
      }
    }
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
        <Avatar sx={{ m: 1, bgcolor: "secondary.main" }}></Avatar>
        <Typography component="h1" variant="h5">
          Profile
        </Typography>
        <Box component="form" noValidate onSubmit={handleSubmit} sx={{ mt: 3 }}>
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <TextField
                autoComplete="given-name"
                name="firstName"
                required
                fullWidth
                id="firstName"
                label="First Name"
                autoFocus
                value={firstName}
                onChange={(e) => setFirstName(e.target.value)}
              />
            </Grid>
            <Grid item xs={12} sm={6}>
              <TextField
                required
                fullWidth
                id="lastName"
                label="Last Name"
                name="lastName"
                autoComplete="family-name"
                value={lastName}
                onChange={(e) => setLastName(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="username"
                label="Username"
                name="username"
                autoComplete="username"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="email"
                label="Email Address"
                name="email"
                autoComplete="email"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                required
                fullWidth
                id="phone"
                label="Phone Number"
                name="phone"
                autoComplete="phone"
                value={phoneNumber}
                onChange={(e) => setPhoneNumber(e.target.value)}
              />
            </Grid>
          </Grid>
          <Button
            fullWidth
            variant="contained"
            onClick={handleOpenModal}
            sx={{ mt: 3, mb: 2 }}
          >
            Change Password
          </Button>
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            Save
          </Button>
        </Box>
      </Box>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Container
          component={Paper}
          sx={{
            width: "30vw",
            position: "absolute",
            top: "20%",
            left: "35%",
          }}
        >
          <Container
            component={"form"}
            onSubmit={handleChangePassword}
            sx={{
              display: "flex",
              flexDirection: "column",
              justifyContent: "space-between",
              alignItems: "center",
              gap: "1rem",
              padding: "3rem 2rem",
            }}
          >
            <Typography
              variant="h5"
              sx={{
                fontSize: {
                  sm: "1rem",
                  md: "1.6rem",
                },
              }}
            >
              New Password
            </Typography>
            <TextField
              required
              fullWidth
              name="oldPassword"
              label="Old Password"
              type="password"
              id="oldPassword"
              autoComplete="old-password"
              value={oldPassword}
              onChange={(e) => setOldPassword(e.target.value)}
            />
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
            <Button fullWidth variant="contained" type="submit">
              Save
            </Button>
            <Button fullWidth onClick={handleClose} variant="outlined">
              Cancel
            </Button>
          </Container>
        </Container>
      </Modal>
    </Container>
  );
};

export default ProfileScreen;
