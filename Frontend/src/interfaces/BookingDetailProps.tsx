export declare interface BookingDetailProps {
  title: string;
  runningTime: number;
  theater: string;
  location: string;
  dateTime: string;
  room: string;
  seats: [string];
  price: number;
  payment: string;
  primaryButton: {
    show: boolean;
    label: string;
  };
  secondaryButton: {
    show: boolean;
    label: string;
  };
}
