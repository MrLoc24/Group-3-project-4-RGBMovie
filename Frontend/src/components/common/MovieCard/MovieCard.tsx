import Typography from "@mui/material/Typography";
import { styled } from "@mui/material/styles";
import "./MovieCard.css";
import { Button, Card, Container, Modal } from "@mui/material";
import { CardProps } from "../../../interfaces/CardProps";
import MovieDetail from "../../MovieDetail/MovieDetail";
import { ReceiptOutlined } from "@mui/icons-material";
import { QuickBooking } from "../..";
import { useState } from "react";

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
  const [open, setOpen] = useState(false);
  const handleClose = (event: object, reason: string) => {
    reason == "backdropClick" ? "" : setOpen(false);
  };
  const handleOpen = () => {
    setOpen(true);
  };
  return (
    <>
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
            <ButtonStyled
              variant="outlined"
              onClick={handleOpen}
              startIcon={<ReceiptOutlined />}
            >
              Book
            </ButtonStyled>
            <MovieDetail {...props} />
          </Container>
        </OverlayText>
      </Card>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <QuickBooking handleClose={handleClose} movie={props.id} />
      </Modal>
    </>
  );
}
