/* eslint-disable @typescript-eslint/no-explicit-any */
import * as React from "react";
import Avatar from "@mui/material/Avatar";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import FormControlLabel from "@mui/material/FormControlLabel";
import Checkbox from "@mui/material/Checkbox";
import Link from "@mui/material/Link";
import Paper from "@mui/material/Paper";
import Box from "@mui/material/Box";
import Grid from "@mui/material/Grid";
import LockOutlinedIcon from "@mui/icons-material/LockOutlined";
import Typography from "@mui/material/Typography";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { useDispatch } from "react-redux";
import { setCredentials } from "../../slices/authSlice";
import {
  useLoginMutation,
  useProfileMutation,
} from "../../slices/customersApiSlice";
import { useState } from "react";
import { setProfile } from "../../slices/profileSlice";
import { useGetCartorHistoryMutation } from "../../slices/bookingApiSlice";
import { addCart } from "../../slices/cartSlice";

export default function SignIn() {
  const [username, setUsername] = useState("");
  const [password, SetPassword] = useState("");

  const dispatch = useDispatch();
  const [login] = useLoginMutation();
  const [profile] = useProfileMutation();
  const [getCartorHistory] = useGetCartorHistoryMutation();

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    try {
      const res: any = await login({
        username,
        password,
      });
      if (!res.error) {
        toast.success("Login successfully!");
        const timestamp = new Date();
        const timestampString = timestamp.toISOString();
        dispatch(setCredentials({ ...res.data, timestamp: timestampString }));

        const profileDetail: any = await profile(res.data.username);
        if (profileDetail.error) {
          toast(profileDetail.error.error);
        } else {
          dispatch(setProfile({ ...profileDetail }));
        }

        const cart: any = await getCartorHistory({
          action: "cart",
          id: profileDetail.data.pk,
        });
        dispatch(addCart(cart.data));

        navigate("/");
      } else {
        toast.error("Invalid username or password");
      }

      // eslint-disable-next-line @typescript-eslint/no-explicit-any
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  };

  const navigate = useNavigate();

  const handleNavigate = () => {
    navigate("/signup");
  };

  const handleForgotPassword = () => {
    navigate("/forgot");
  };

  return (
    <Grid container component="main" sx={{ height: "fit-content" }}>
      <CssBaseline />
      <Grid
        item
        xs={false}
        sm={4}
        md={7}
        sx={{
          backgroundImage:
            "url(https://res.cloudinary.com/dlv6zjsif/image/upload/v1694070784/cinemas/neonbackgroudn_mu2grb.jpg)",
          backgroundRepeat: "no-repeat",
          backgroundColor: (t) =>
            t.palette.mode === "light"
              ? t.palette.grey[50]
              : t.palette.grey[900],
          backgroundSize: "cover",
          backgroundPosition: "center",
        }}
      ></Grid>
      <Grid item xs={12} sm={8} md={5} component={Paper} elevation={6} square>
        <Box
          sx={{
            my: 4,
            mx: 4,
            display: "flex",
            flexDirection: "column",
            alignItems: "center",
          }}
        >
          <Avatar sx={{ m: 1 }}>
            <LockOutlinedIcon />
          </Avatar>
          <Typography component="h1" variant="h5">
            Sign in
          </Typography>
          <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
            <TextField
              margin="normal"
              required
              fullWidth
              id="username"
              label="Username"
              name="username"
              autoComplete="username"
              autoFocus
              value={username}
              onChange={(e) => setUsername(e.target.value)}
            />
            <TextField
              margin="normal"
              required
              fullWidth
              name="password"
              label="Password"
              type="password"
              id="password"
              autoComplete="current-password"
              value={password}
              onChange={(e) => SetPassword(e.target.value)}
            />
            <FormControlLabel
              control={<Checkbox value="remember" color="primary" />}
              label="Remember me"
            />
            <Button
              type="submit"
              fullWidth
              variant="contained"
              sx={{ mt: 3, mb: 2 }}
            >
              Sign In
            </Button>
            <Grid container>
              <Grid item xs>
                <Link href="#" variant="body2" onClick={handleForgotPassword}>
                  Forgot password?
                </Link>
              </Grid>
              <Grid item>
                <Link onClick={handleNavigate} variant="body2" href="#">
                  Don't have an account? Sign Up
                </Link>
              </Grid>
            </Grid>
          </Box>
        </Box>
      </Grid>
    </Grid>
  );
}
