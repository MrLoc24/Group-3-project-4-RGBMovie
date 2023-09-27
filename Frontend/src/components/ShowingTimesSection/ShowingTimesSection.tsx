import { Card, Container } from "@mui/material";
import { CustomContainer, ShowingTime } from "..";

export declare interface ShowingTimesSectionProps {
  films: [
    {
      name?: string;
      image?: string;
      format?: [];
    }
  ];
}

const ShowingTimesSection = ({ films }: any) => {
  return (
    <Container>
      {/* eslint-disable-next-line @typescript-eslint/no-explicit-any */}
      {films.map((film: any) => {
        return film ? (
          <CustomContainer>
            <Container
              sx={{
                justifyContent: "left",
                display: "flex",
                width: "fit-content",
              }}
            >
              <Card>
                <img src={film.image} alt={film.name} width={300} />
              </Card>
            </Container>
            <Container
              sx={{
                display: "block",
                justifyContent: "center",
                color: "var(--textPrimary)",
              }}
            >
              {
                // eslint-disable-next-line @typescript-eslint/no-explicit-any
                film?.format.map(({ name, showingTimes }: any) => (
                  <ShowingTime format={name} showingTime={showingTimes} />
                ))
              }
            </Container>
          </CustomContainer>
        ) : null;
      })}
    </Container>
  );
};

export default ShowingTimesSection;
