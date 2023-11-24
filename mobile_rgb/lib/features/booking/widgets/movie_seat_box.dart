import 'package:flutter/material.dart';
import 'package:movie_app_ui/models/seat_model.dart';

import '../../../core/data/models/movies.dart';
import '../../../core/constants/constants.dart';

class MovieSeatBox extends StatefulWidget {
  const MovieSeatBox(
      {Key? key, required this.seat, required this.onSelectSeats})
      : super(key: key);

  final SeatModel seat;
  final Function(String value) onSelectSeats;

  @override
  State<MovieSeatBox> createState() => _SeatBoxState();
}

class _SeatBoxState extends State<MovieSeatBox> {
  bool _isSelected = false;

  @override
  Widget build(BuildContext context) {
    final color = widget.seat.isOcuppied!
        ? Colors.black
        : _isSelected
            ? AppColors.primaryColor
            : Colors.grey.shade200;
    return GestureDetector(
      onTap: () {
        setState(() {
          _isSelected = !_isSelected;
          widget.onSelectSeats(widget.seat.seatName);
        });
      },
      child: AnimatedContainer(
        width: 3,
        height: 3,
        duration: const Duration(milliseconds: 300),
        decoration: BoxDecoration(
          color: color,
          borderRadius: const BorderRadius.all(
            Radius.circular(3),
          ),
        ),
      ),
    );
  }
}
