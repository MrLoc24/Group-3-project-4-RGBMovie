import 'package:flutter/material.dart';
import 'package:movie_app_ui/models/movie_model.dart';

import '../../../../core/data/models/movies.dart';
import './movie_info_table_item.dart';

class MovieInfoTable extends StatelessWidget {
  const MovieInfoTable({Key? key, required this.movie}) : super(key: key);

  final MovieModel movie;

  @override
  Widget build(BuildContext context) {
    return Row(
      mainAxisAlignment: MainAxisAlignment.spaceEvenly,
      children: [
        MovieInfoTableItem(title: 'Type', content: movie.genre),
        MovieInfoTableItem(title: 'Hour', content: '${movie.durationMin} hour'),
      ],
    );
  }
}
