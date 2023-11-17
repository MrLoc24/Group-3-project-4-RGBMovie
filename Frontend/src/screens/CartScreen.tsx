/* eslint-disable @typescript-eslint/no-explicit-any */
import List from "@mui/material/List";
import Checkbox from "@mui/material/Checkbox";
import IconButton from "@mui/material/IconButton";
import { useEffect, useState } from "react";
import { Button, Container, Modal, Typography } from "@mui/material";
import {
  EditOutlined,
  HighlightOffOutlined,
  ShoppingCartCheckoutOutlined,
} from "@mui/icons-material";
import { useGetCartorHistoryMutation } from "../slices/bookingApiSlice";
import { toast } from "react-toastify";
import { useDispatch, useSelector } from "react-redux";
import { Checkout } from "../components";
import { addCart } from "../slices/cartSlice";

const CartScreen = () => {
  const [refresh, setRefresh] = useState(false);
  const [checked, setChecked] = useState<any>([]);
  const [listItem, setListItem] = useState<number[]>();
  const [listCheckout, setListCheckout] = useState<any>();

  const dispatch = useDispatch();

  const [open, setOpen] = useState(false);
  const handleClose = (event: object, reason: string) => {
    reason == "backdropClick" ? "" : setOpen(false);
  };
  const handleCheckout = () => {
    const records = checked.map((item: any) => {
      return {
        id: item.Reservation.pk,
        title: item.Movie.title,
        datetime: item.Screening.time
          .replace("T", " ")
          .replace(":", "h")
          .substring(0, 16),
        seats: item.Seat.map((item: any) => item + ", "),
        address: item.Theater.address,
        subtotal: item.Reservation.totalCost,
      };
    });
    console.log(records);

    setListCheckout(records);
    setOpen(true);
  };

  const [getCartorHistory] = useGetCartorHistoryMutation();
  const { customerDetail } = useSelector((state: any) => state.profile);

  useEffect(() => {
    try {
      getCartorHistory({
        action: "cart",
        id: customerDetail.data.pk,
      }).then((result: any) => {
        setListItem(result.data);
        dispatch(addCart(result.data));
      });
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  }, [refresh]);

  const handleToggle = (value: never | any) => () => {
    const currentIndex = checked.indexOf(value);
    const newChecked = [...checked];

    if (currentIndex === -1) {
      newChecked.push(value);
    } else {
      newChecked.splice(currentIndex, 1);
    }

    setChecked(newChecked);
    console.log(newChecked);
  };

  const handleCancel = async (pk: any) => {
    try {
      await getCartorHistory({
        action: "cancel",
        id: customerDetail.data.pk,
        resId: pk,
      });
      toast.success("Remove Item Successfully");
      setRefresh(!refresh);
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
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
          minWidth: "50vw",
          gap: "2rem",
          padding: "0rem",
          overflowY: "auto",
        }}
      >
        {listItem ? (
          listItem.map((value: any | never) => {
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
                <img src={value.Movie.mainImg} width={120} />
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
                  {value.Movie.title}
                </Typography>

                {/* Details */}
                <Container
                  component={"div"}
                  sx={{
                    maxWidth: "20vw",
                  }}
                >
                  <Typography>
                    Seats:{" "}
                    {value.Seat
                      ? value.Seat.map((item: any) => item + ", ")
                      : null}
                  </Typography>
                  <Typography>
                    Time & Date:
                    {value.Screening
                      ? " " +
                        value.Screening.time
                          .replace("T", " ")
                          .replace(":", "h")
                          .substring(0, 16)
                      : null}
                  </Typography>
                  <Typography>
                    Subtotal: $ {value.Reservation.totalCost}
                  </Typography>
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
                    Theater: RBG - {value.Theater.address}
                  </Typography>
                </Container>

                <div>
                  <IconButton aria-label="edit" size="small">
                    <EditOutlined />
                  </IconButton>
                  <IconButton
                    aria-label="cancel"
                    size="small"
                    onClick={() => handleCancel(value.Reservation.pk)}
                  >
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
          height: "80vh",
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
          <Typography>
            {checked
              ? "$ " +
                checked.reduce(
                  (total: any, subtotal: any) =>
                    total + subtotal.Reservation.totalCost,
                  0
                )
              : "0"}
          </Typography>
        </Container>
        <Button
          disabled={checked.length == 0}
          variant="outlined"
          fullWidth
          startIcon={<ShoppingCartCheckoutOutlined />}
          onClick={handleCheckout}
        >
          Checkout
        </Button>
      </Container>

      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Checkout listCheckout={listCheckout} handleClose={handleClose} />
      </Modal>
    </Container>
  );
};

export default CartScreen;
