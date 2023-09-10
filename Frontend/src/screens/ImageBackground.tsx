import { styled } from "@mui/material/styles";
import Box from "@mui/material/Box";
import { HeaderProps } from "../interfaces/HeaderProps";

const TransparentBodySection = styled(Box)({
  // backgroundColor: "transparent",
  // backgroundImage: `url(${Black})`,
  // backgroundRepeat: "no-repeat" , 
  background: `transparent url(${"https://res.cloudinary.com/dlv6zjsif/image/upload/v1694070784/cinemas/neonbackgroudn_mu2grb.jpg"}) no-repeat top` ,
  paddingLeft: "10rem",
  paddingRight: "10rem",
  paddingTop: "1rem",
  paddingBottom: "1rem",
  boxShadow: '0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19)'
});

export default function ImageBackground({ children }: HeaderProps) {
  return (
    <TransparentBodySection>
      {/* Body section content goes here */}
      {children}
    </TransparentBodySection>
  );
}
