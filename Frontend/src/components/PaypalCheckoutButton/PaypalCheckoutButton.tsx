/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-explicit-any */
import { PayPalButtons } from "@paypal/react-paypal-js";
import { useEffect, useState } from "react";

const PaypalCheckoutButton = (props: any) => {
  const [paidFor, setPaidFor] = useState(false);
  const [error, setError] = useState<any>(null);
  const { product } = props;

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

  return (
    <PayPalButtons
      style={{
        shape: "pill",
        color: "silver",
      }}
      createOrder={(data, actions) => {
        return actions.order.create({
          purchase_units: [
            {
              description: product.description,
              amount: {
                value: product.price,
              },
            },
          ],
        });
      }}
      onApprove={async (data, actions) => {
        const order = await actions.order?.capture();
        console.log("order", order);
        handleApprove(data.orderID);
      }}
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
