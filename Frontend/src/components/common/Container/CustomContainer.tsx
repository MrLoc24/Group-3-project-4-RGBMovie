import { Container, styled } from "@mui/material";
import React, { ReactNode } from "react";

export declare interface CustomProps {
  children?: ReactNode;
}

const StyledContainer = styled(Container)({
  margin: "1rem 1rem",
  display: "flex",
  justifyContent: "center",
  color: "var(--textPrimary)",
});

const CustomContainer = ({ children }: CustomProps) => {
  return <StyledContainer>{children}</StyledContainer>;
};

export default CustomContainer;
