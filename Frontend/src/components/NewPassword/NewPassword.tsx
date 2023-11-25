/* eslint-disable @typescript-eslint/no-explicit-any */
import { Button, Container, Paper, TextField, Typography } from "@mui/material";
import React, { useEffect, useState } from "react";
import { useNavigate, useSearchParams } from "react-router-dom";
import {
  useResetPasswordMutation,
  useShowChangePasswordPageMutation,
} from "../../slices/customersApiSlice";
import { toast } from "react-toastify";

const NewPassword = () => {
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [token, setToken] = useState<string | null>("");
  const [userId, setUserId] = useState<string | null | number>(null);

  const navigate = useNavigate();

  const [showChangePasswordPage] = useShowChangePasswordPageMutation();
  const [resetPassword] = useResetPasswordMutation();
  const [queryParam] = useSearchParams();

  useEffect(() => {
    setToken(queryParam.get("token"));
    showChangePasswordPage(queryParam.get("token")).then((result: any) =>
      setUserId(result.data)
    );
  }, []);

  const handleSave = async () => {
    if (password !== confirmPassword) {
      toast.error("Password do not match");
    } else {
      await resetPassword({
        token: token,
        userId: userId as string,
        newPassword: password,
      }).then((result: any) => {
        if (result.error.originalStatus === 400) {
          toast.error("New password can not be the same as old password");
        } else {
          toast.success("Successfully changed your password!");
          navigate("/signin");
        }
      });
      // navigate("/signin", { replace: true });
    }
  };

  return (
    <Container
      component={Paper}
      sx={{
        display: "flex",
        flexDirection: "column",
        justifyContent: "space-between",
        alignItems: "center",
        gap: "1rem",
        padding: "3rem 2rem",
        width: "30vw",
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
      <Button fullWidth variant="contained" onClick={handleSave}>
        Save
      </Button>
    </Container>
  );
};

export default NewPassword;
