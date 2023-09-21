import { ReactNode } from "react";

export declare interface CardProps {
  title?: string;
  image: string;
  content?: string;
  rated?: string;
  primaryButton?: {
    label: string;
    icon: ReactNode;
  };
  secondaryButton?: boolean;
}
