/* eslint-disable @typescript-eslint/no-explicit-any */
import List from "@mui/material/List";
import { useEffect, useState } from "react";
import { Container, Typography } from "@mui/material";
import { useGetCartorHistoryMutation } from "../slices/bookingApiSlice";
import { toast } from "react-toastify";
import { useDispatch, useSelector } from "react-redux";
import { addCart } from "../slices/cartSlice";

const CartScreen = () => {
  const [listItem, setListItem] = useState<number[]>();

  const dispatch = useDispatch();

  const [getCartorHistory] = useGetCartorHistoryMutation();
  const { customerDetail } = useSelector((state: any) => state.profile);

  useEffect(() => {
    try {
      getCartorHistory({
        action: "history",
        id: customerDetail.data.pk,
      }).then((result: any) => {
        setListItem(result.data);
        dispatch(addCart(result.data));
      });
    } catch (error: any) {
      toast(error?.data?.message || error.error);
    }
  }, []);

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

                <Typography>
                  Status:{" "}
                  {value.Reservation.getPaid == 0 ? "Cancel" : "Finished"}
                </Typography>
              </Container>
            );
          })
        ) : (
          <Typography>Not found data</Typography>
        )}
      </List>
    </Container>
  );
};

export default CartScreen;
