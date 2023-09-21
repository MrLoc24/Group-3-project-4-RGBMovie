import React from "react";
import { styled, Container } from "@mui/material";
import { SectionProps } from "../interfaces/SectionProps";

const LoginScreen = ({ child }: SectionProps) => {
  const SectionLogin = styled(Container)({ padding: "1.5rem" });
  return <SectionLogin>{child}</SectionLogin>;
};

export default LoginScreen;
