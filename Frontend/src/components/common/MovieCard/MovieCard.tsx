import Typography from "@mui/material/Typography";
import { styled } from "@mui/material/styles";
import "./MovieCard.css";
import { Button, Card, Container } from "@mui/material";
import { CardProps } from "../../../interfaces/CardProps";
import MovieDetail from "../../MovieDetail/MovieDetail";
import { ReceiptOutlined } from "@mui/icons-material";

const OverlayText = styled(Typography)({
  display: "none",
  "&:hover": {
    display: "block",
  },
  position: "absolute" /* Position the background text */,
  bottom: 0 /* At the bottom. Use top:0 to append it to the top */,
  background: "rgba(0, 0, 0, 0.7)" /* Black background with 0.5 opacity */,
  textShadow: "2px 2px rgba(0, 0, 0, 0.9)",
  color: "#f1f1f1" /* Grey text */,
  width: "auto" /* Full width */,
  padding: "20px" /* Some padding */,
  textAlign: "center",
});

const ButtonStyled = styled(Button)({
  display: "flex",
  width: "7.5rem",
});

export default function MovieCard(props: CardProps) {
  return (
    <Card
      className="movieCard"
      sx={{
        "&:hover .overlayText": {
          display: "block",
        },
      }}
    >
      <img src={props.image} alt="raven" width={300} />
      <OverlayText className="overlayText">
        <Typography variant="h4">{props.title}</Typography>
        <Typography>{props.content}</Typography>
        <Container
          className="blockButton"
          component={"div"}
          sx={{
            display: "flex",
            justifyContent: "space-between",
            paddingLeft: {
              sm: "0.3rem",
            },
            paddingRight: {
              sm: "0.3rem",
            },
            marginTop: "1rem",
          }}
        >
          <ButtonStyled variant="outlined" startIcon={<ReceiptOutlined />}>
            Book
          </ButtonStyled>
          <MovieDetail
            image={props.image}
            title={props.title}
            description={props.content}
          />
        </Container>
      </OverlayText>
    </Card>
  );
}
