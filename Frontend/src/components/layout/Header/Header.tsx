import { Container } from "@mui/material";
import { HeaderProps } from "../../../interfaces/HeaderProps";

const Header = ({ children }: HeaderProps) => {
  return (
    <Container
      sx={{
        width: "100vw",
        backgroundColor: "black",
      }}
    >
      {children}
    </Container>
  );
};

export default Header;
