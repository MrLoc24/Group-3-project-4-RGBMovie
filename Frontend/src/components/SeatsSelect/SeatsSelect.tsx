/* eslint-disable @typescript-eslint/no-explicit-any */
import "./SeatsSelect.css";
import React, { useEffect, useState } from "react";
import clsx from "clsx";
import { Container } from "@mui/material";

export default function SeatsSelect({ occupied, price, row, column }) {
  const [selectedSeats, setSelectedSeats] = useState([]);
  const [seats, setSeats] = useState<string[]>();

  useEffect(() => {
    const seatList = [];
    for (let char = 65; char < row + 65; char++) {
      for (let num = 1; num <= column; num++) {
        seatList.push(String.fromCharCode(char) + num);
      }
    }
    setSeats(seatList);
  }, []);

  return (
    <div className="App">
      <ShowCase />
      <Cinema
        column={column}
        seats={seats}
        occupied={occupied}
        selectedSeats={selectedSeats}
        onSelectedSeatsChange={(selectedSeats) =>
          setSelectedSeats(selectedSeats)
        }
      />

      <p className="info">
        You have selected <span className="count">{selectedSeats.length}</span>{" "}
        seats for the price of{" "}
        <span className="total">{selectedSeats.length * price}$</span>
      </p>
    </div>
  );
}

function ShowCase() {
  return (
    <ul className="ShowCase">
      <li>
        <span className="seat" /> <small>N/A</small>
      </li>
      <li>
        <span className="seat selected" /> <small>Selected</small>
      </li>
      <li>
        <span className="seat occupied" /> <small>Occupied</small>
      </li>
    </ul>
  );
}

function Cinema({
  occupied,
  selectedSeats,
  onSelectedSeatsChange,
  seats,
  column,
}) {
  function handleSelectedState(seat) {
    const isSelected = selectedSeats.includes(seat);
    if (isSelected) {
      onSelectedSeatsChange(
        selectedSeats.filter((selectedSeat) => selectedSeat !== seat)
      );
    } else {
      onSelectedSeatsChange([...selectedSeats, seat]);
    }
  }

  return (
    <div className="Cinema">
      <div className="screen" />

      <Container
        className="seats"
        sx={{
          gridTemplateColumns: `repeat(${column}, min-content)`
        }}
      >
        {seats
          ? seats.map((seat: any) => {
              const isSelected = selectedSeats.includes(seat);
              const isOccupied = occupied.includes(seat);
              return (
                <span
                  tabIndex={0}
                  key={seat}
                  className={clsx(
                    "seat",
                    isSelected && "selected",
                    isOccupied && "occupied"
                  )}
                  onClick={isOccupied ? null : () => handleSelectedState(seat)}
                  onKeyPress={
                    isOccupied
                      ? null
                      : (e) => {
                          if (e.key === "Enter") {
                            handleSelectedState(seat);
                          }
                        }
                  }
                >
                  {seat}
                </span>
              );
            })
          : null}
      </Container>
    </div>
  );
}
