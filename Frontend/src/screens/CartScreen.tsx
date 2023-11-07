import List from "@mui/material/List";
import Checkbox from "@mui/material/Checkbox";
import IconButton from "@mui/material/IconButton";
import { useEffect, useState } from "react";
import { Button, Container, Typography } from "@mui/material";
import { CinemaBackground } from "../assets";
import {
  EditOutlined,
  HighlightOffOutlined,
  ShoppingCartCheckoutOutlined,
} from "@mui/icons-material";

const CartScreen = () => {
  const [checked, setChecked] = useState([0]);
  const [listItem, setListItem] = useState<number[]>();

  useEffect(() => {
    setListItem([0, 1, 2, 3]);
  }, []);

  const handleToggle = (value: number) => () => {
    const currentIndex = checked.indexOf(value);
    const newChecked = [...checked];

    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }

    setChecked(newChecked);
  };

  return (
    <Container
      component={"div"}
      sx={{
        display: "flex",
        justifyContent: "space-between",
      }}
    >
      <List
        sx={{
          display: "flex",
          flexDirection: "column",
          width: "100%",
          gap: "2rem",
          padding: "0rem",
        }}
      >
        {listItem ? (
          listItem.map((value) => {
            return (
              <Container
                sx={{
                  display: "flex",
                  flexDirection: "row",
                  justifyContent: "space-between",
                  alignItems: "center",
                  minHeight: "6rem",
                  minWidth: "50vw",
                  bgcolor: "background.paper",
                  gap: "0 0.5rem",
                }}
              >
                <Checkbox
                  onClick={handleToggle(value)}
                  edge="start"
                  checked={checked.indexOf(value) !== -1}
                  tabIndex={-1}
                  disableRipple
                />
                <img src={CinemaBackground} width={120} />
                <Typography
                  sx={{
                    fontSize: {
                      xs: "0.5rem",
                      md: "1.2rem",
                    },
                    width: "15vw",
                    maxHeight: "10vh",
                    // whiteSpace: "nowrap",
                    textOverflow: "ellipsis",
                    overflow: "hidden",
                    display: "-webkit-box",
                    WebkitLineClamp: "2",
                    WebkitBoxOrient: "vertical",
                  }}
                >
                  Raven: The Final Chapter
                </Typography>
                <Container
                  component={"div"}
                  sx={{
                    maxWidth: "20vw",
                  }}
                >
                  <Typography>Seats: 6</Typography>
                  <Typography>Subtotal: $ 52.5</Typography>
                  <Typography
                    sx={{
                      // whiteSpace: "nowrap",
                      textOverflow: "ellipsis",
                      overflow: "hidden",
                      display: "-webkit-box",
                      WebkitLineClamp: "2",
                      WebkitBoxOrient: "vertical",
                    }}
                  >
                    Theater: RBG Ly Chinh Thang - Somewhere on Earth Lorem ipsum
                    dolor sit amet consectetur adipisicing elit. At, tempora?
                  </Typography>
                </Container>

                <div>
                  <IconButton aria-label="edit" size="small">
                    <EditOutlined />
                  </IconButton>
                  <IconButton aria-label="edit" size="small">
                    <HighlightOffOutlined />
                  </IconButton>
                </div>
              </Container>
            );
          })
        ) : (
          <Typography>Empty Cart</Typography>
        )}
      </List>

      <Container
        sx={{
          display: "flex",
          flexDirection: "column",
          justifyContent: "space-between",
          marginLeft: "1rem",
          padding: "1rem 0rem",
          bgcolor: "background.paper",
        }}
      >
        <Container
          component={"div"}
          sx={{
            padding: {
              xs: "0px",
              md: "0px",
            },
            display: "flex",
            justifyContent: "space-between",
          }}
        >
          <Typography>Total Price:</Typography>
          <Typography>75$</Typography>
        </Container>
        <Button
          variant="outlined"
          fullWidth
          startIcon={<ShoppingCartCheckoutOutlined />}
        >
          Checkout
        </Button>
      </Container>
    </Container>
  );
};

export default CartScreen;
