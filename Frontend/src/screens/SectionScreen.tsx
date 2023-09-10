import { Container } from "@mui/material";
import { SectionProps } from "../interfaces/SectionProps";
import { SearchBar, SelectInput, Title } from "../components";

const SectionScreen = (props: SectionProps) => {
  return (
    <Container sx={{paddingBottom: '3rem'}}>
      {props.title ? <Title label={props.title || ""} /> : null}
      <Container
        sx={{ marginBottom: "1rem", display: "flex", justifyContent: "center" }}
      >
        {props.selectInput ? <SelectInput status={props.selectInput} /> : null}
        {props.searchInput ? (
          <SearchBar placeholder={props.searchInput || ""} />
        ) : null}
      </Container>
      <Container>{props.child}</Container>
    </Container>
  );
};

export default SectionScreen;
