import { ReactNode, ReactElement } from "react";

export declare interface SectionProps {
  title?: string;
  backgroundImage?: string;
  child?: ReactNode;
  searchInput?: string;
  selectInput?: Array<string>;
  children?: Element | ReactElement;
}
