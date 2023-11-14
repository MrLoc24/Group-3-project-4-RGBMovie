/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { PayPalButtons } from "@paypal/react-paypal-js";
import { useEffect, useState } from "react";
import {
  usePaypalCreateOrderMutation,
  usePaypalOnApproveMutation,
} from "../../slices/paypalApiSlice";

const PaypalCheckoutButton = (props: any) => {
  const [paidFor, setPaidFor] = useState(false);
  const [error, setError] = useState<any>(null);
  const { id } = props;

  const [paypalCreateOrder] = usePaypalCreateOrderMutation();
  const [paypalOnApprove] = usePaypalOnApproveMutation();

  useEffect(() => {
    if (paidFor) {
      alert("Thank you for your purchase!");
    }

    if (error) {
      alert(error);
    }
  }, [paidFor, error]);

  function handleApprove(orderID: string) {
    setPaidFor(true);
  }

  async function createOrder(): Promise<any> {
    const orderId = await paypalCreateOrder(id)
      .then((response) => response.data)
      .then((order) => order.id);
    return orderId;
  }

  async function onApprove(data): Promise<any> {
    return await paypalOnApprove({ orderID: data.orderID, id: id })
      .then((response) => response)
      .then((orderData) => {
        alert(`Transaction completed`);
        window.location.reload();
      });
  }

  return (
    <PayPalButtons
      style={{
        shape: "pill",
        color: "silver",
      }}
      createOrder={createOrder}
      onApprove={onApprove}
      onError={(err) => {
        setError(err);
        console.error("Paypal Checkout onError", err);
      }}
      onCancel={() => {}}
      onClick={(data, actions) => {
        const hasAlreadyBought = false;
        if (hasAlreadyBought) {
          setError(
            "You already bought this ticket. Go to history to see your purchases"
          );
          return actions.reject();
        } else {
          return actions.resolve();
        }
      }}
    />
  );
};

export default PaypalCheckoutButton;
