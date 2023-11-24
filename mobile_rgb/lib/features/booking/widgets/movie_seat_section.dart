import 'package:flutter/material.dart';
import 'package:movie_app_ui/models/auditorium_model.dart';
import 'package:movie_app_ui/models/seat_model.dart';

import './movie_seat_box.dart';
import '../../../core/data/models/movies.dart';

class MovieSeatSection extends StatelessWidget {
  const MovieSeatSection(
      {Key? key,
      required this.auditorium,
      required this.isOcuppiedSeats,
      required this.onSelectSeats})
      : super(key: key);

  final AuditoriumModel? auditorium;
  final List<String> isOcuppiedSeats;
  final Function(String value) onSelectSeats;
  @override
  Widget build(BuildContext context) {
    return Expanded(
        child: GridView.builder(
      padding: const EdgeInsets.symmetric(
        horizontal: 10,
      ),
      physics: const NeverScrollableScrollPhysics(),
      shrinkWrap: true,
      itemCount: auditorium!.row * auditorium!.column ?? 0,
      gridDelegate: SliverGridDelegateWithFixedCrossAxisCount(
        crossAxisCount: auditorium!.column,
      ),
      itemBuilder: (_, index) {
        print("movie seat section");
        print(auditorium);
        print(isOcuppiedSeats);
        List<SeatModel> listSeat = List.empty();
        for (int char = 65; char < auditorium!.row + 65; char++) {
          for (int num = 1; num <= auditorium!.column; num++) {
            String seatName = String.fromCharCode(char) + num.toString();
            bool isOccupied;
            isOcuppiedSeats.contains(seatName)
                ? isOccupied = true
                : isOccupied = false;
            SeatModel seat = SeatModel(
                seatName: seatName,
                auditorium: auditorium!.pk,
                pk: index,
                isOcuppied: isOccupied,
                isSelected: false);
            print(seat);
            listSeat.add(seat);
          }
        }
        listSeat
            .map((e) => MovieSeatBox(seat: e, onSelectSeats: onSelectSeats));
      },
    ));
  }
}
