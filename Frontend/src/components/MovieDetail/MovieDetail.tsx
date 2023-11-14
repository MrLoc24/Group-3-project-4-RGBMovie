import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import { Card, Container, styled } from "@mui/material";
import { HighlightOffOutlined, InfoOutlined } from "@mui/icons-material";
import { CardProps } from "../../interfaces";
const style = {
  display: "flex",
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: "70rem",
  bgcolor: "background.paper",
  border: "2px solid #000",
  boxShadow: 24,
  p: 4,
};

const ButtonStyled = styled(Button)({
  display: "flex",
  width: "7.5rem",
});

const MovieDetail = (props: CardProps) => {
  const [open, setOpen] = React.useState(false);
  const handleOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  return (
    <div>
      <ButtonStyled
        variant="outlined"
        onClick={handleOpen}
        startIcon={<InfoOutlined />}
      >
        Detail
      </ButtonStyled>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <Container
            sx={{ justifyContent: "center", display: "flex", gap: "0.5rem" }}
          >
            {props.image ? (
              <Card
                className="movieCard"
                sx={{
                  "&:hover .overlayText": {
                    display: "block",
                  },
                }}
              >
                <img src={props.image} alt="raven" width={300} />
              </Card>
            ) : null}
          </Container>
          <Container
            sx={{
              display: "flex",
              flexDirection: "column",
              justifyContent: "space-evenly",
            }}
          >
            <Typography variant="h4" color={"white"}>
              {props.title}
            </Typography>
            <Typography>Release Date: {props.releaseDate}</Typography>
            <Typography>
              Running Times: {props.runningTime + " minutes"}
            </Typography>
            <Typography>Rated: {props.rated}</Typography>
            <Typography>Genres: {props.genres}</Typography>
            <Typography color={"white"}>
              Description: {props.content}
            </Typography>
            <Button
              variant="outlined"
              startIcon={<HighlightOffOutlined />}
              onClick={handleClose}
            >
              Close
            </Button>
          </Container>
        </Box>
      </Modal>
    </div>
  );
};

export default MovieDetail;
