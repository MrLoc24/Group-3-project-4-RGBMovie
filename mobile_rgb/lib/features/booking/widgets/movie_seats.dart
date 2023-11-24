import 'package:flutter/material.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_seat_generate.dart';
import 'package:movie_app_ui/models/auditorium_model.dart';

import './movie_seat_section.dart';
import '../../../core/data/models/movies.dart';

class MovieSeats extends StatelessWidget {
  const MovieSeats({
    Key? key,
    required this.auditorium,
    required this.isOcuppiedSeats,
    required this.onSelectSeats,
    required this.maxHeight,
    required this.maxWidth,
  }) : super(key: key);

  final AuditoriumModel? auditorium;
  final List<String> isOcuppiedSeats;
  final Function(String value) onSelectSeats;
  final double maxHeight;
  final double maxWidth;

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          child: SingleChildScrollView(
            child: Container(
              width: maxWidth * 0.8,
              height: maxHeight * 0.6,
              child: Column(
                mainAxisAlignment: MainAxisAlignment.start,
                children: [
                  const SizedBox(height: 20),
                  MovieSeatGenerate(
                      auditorium: auditorium,
                      isOcuppiedSeats: isOcuppiedSeats,
                      onSelectSeats: onSelectSeats),
                ],
              ),
            ),
          ),
        ),
      ],
    );
  }
}
