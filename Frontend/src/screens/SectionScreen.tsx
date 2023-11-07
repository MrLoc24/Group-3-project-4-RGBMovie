import { Container } from "@mui/material";
import { SectionProps } from "../interfaces/SectionProps";
import { Title } from "../components";

const SectionScreen = (props: SectionProps) => {
  return (
    <Container
      sx={{
        paddingBottom: "2rem",
        paddingTop: "0rem",
        height: "100%",
        width: "100%",
      }}
    >
      {props.title ? <Title label={props.title || ""} /> : null}

      <Container
        sx={{
          paddingBottom: "0.8rem",
        }}
      >
        {props.child}
      </Container>
    </Container>
  );
};

export default SectionScreen;
