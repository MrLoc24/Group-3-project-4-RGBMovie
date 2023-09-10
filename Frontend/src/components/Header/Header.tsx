import { AppBar, Toolbar } from "@mui/material";
import { HeaderProps } from "../../interfaces/HeaderProps";

const Header = ({children}: HeaderProps) => {
  return (
    <AppBar
      position="static"
      style={{
        backgroundColor: "transparent",
        justifyContent: "center",
        backgroundImage: "none",
      }}
    >
      <Toolbar style={{
        justifyContent: "center",
      }}>{children}</Toolbar>
    </AppBar>
  );
};

export default Header;
