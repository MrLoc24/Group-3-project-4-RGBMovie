import { Container } from "@mui/material";
import { SectionProps } from "../interfaces/SectionProps";
import { Title } from "../components";

const SectionScreen = (props: SectionProps) => {
  return (
    <Container sx={{ paddingBottom: "2rem", paddingTop: "0rem" }}>
      {props.title ? <Title label={props.title || ""} /> : null}

      <Container>{props.child}</Container>
    </Container>
  );
};

export default SectionScreen;
