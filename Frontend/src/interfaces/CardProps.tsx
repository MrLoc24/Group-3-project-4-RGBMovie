import { ReactNode } from "react";

export declare interface CardProps {
  id?: number;
  title?: string;
  image?: string;
  content?: string;
  rated?: string;
  runningTime?: number;
  genres?: string;
  releaseDate?: string;
  primaryButton?: {
    label: string;
    icon: ReactNode;
  };
  secondaryButton?: boolean;
  handleClick?: React.FormEventHandler;
}
