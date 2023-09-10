import { useEffect } from "react";
import { TitleProps } from "../../../interfaces";
import "./Title.css";

const Title = ({ label }: TitleProps) => {
  useEffect(() => {
    const target: HTMLElement = document.getElementsByClassName(
      "sectionTitle"
    )[0] as HTMLElement;

    const flickerLetter = (letter: string) =>
      `<span style="animation: text-flicker-in-glow ${
        Math.random() * 4
      }s linear both ">${letter}</span>`;

    const colorLetter = (letter: string) =>
      `<span style="color: hsla(${
        Math.random() * 360
      }, 100%, 80%, 1);">${letter}</span>`;

    const flickerAndColorText = (text: string) =>
      text.split("").map(flickerLetter).map(colorLetter).join("");

    const neonGlory = (target: HTMLElement) =>
      (target.innerHTML = flickerAndColorText(
        target.textContent || "Not found"
      ));

    neonGlory(target);
  });
  // target.click = ({ target }) => neonGlory(target);
  return <div className="sectionTitle neonImageBlue">{label}</div>;
};

export default Title;
