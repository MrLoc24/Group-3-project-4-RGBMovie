import React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Typography from "@mui/material/Typography";
import Modal from "@mui/material/Modal";
import { Card, Container, styled } from "@mui/material";
import { DetailProps } from "../../interfaces";
import {
  CreditCardOutlined,
  HighlightOffOutlined,
  InfoOutlined,
} from "@mui/icons-material";

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

const MovieDetail = ({ image, title, description }: DetailProps) => {
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
          <Container sx={{ justifyContent: "center", display: "flex" }}>
            {image ? (
              <Card
                className="movieCard"
                sx={{
                  "&:hover .overlayText": {
                    display: "block",
                  },
                }}
              >
                <img src={image} alt="raven" width={300} />
              </Card>
            ) : null}
          </Container>
          <Container>
            <Typography variant="h4" color={"white"}>
              {title}
            </Typography>
            <Typography color={"white"}>{description}</Typography>
            <Container>
              <Button variant="outlined" startIcon={<CreditCardOutlined />}>
                Book
              </Button>
              <Button
                variant="outlined"
                startIcon={<HighlightOffOutlined />}
                onClick={handleClose}
              >
                Close
              </Button>
            </Container>
          </Container>
        </Box>
      </Modal>
    </div>
  );
};

export default MovieDetail;
