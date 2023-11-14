import 'package:flutter/material.dart';

class MovieStars extends StatelessWidget {
  const MovieStars({Key? key, required this.stars}) : super(key: key);

  final double stars;

  @override
  Widget build(BuildContext context) {
    int calc_ranks(ranks) {
      double multiplier = .5;
      return (multiplier * ranks).round();
    }

    return Row(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        for (int i = 0; i < calc_ranks(stars); i++)
          const Icon(Icons.star, color: Colors.amber)
      ],
    );
  }
}
