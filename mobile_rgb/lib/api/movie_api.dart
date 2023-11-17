import 'dart:convert';

import 'package:movie_app_ui/core/constants/url.dart';

import '../models/movie_model.dart';
import 'package:http/http.dart' as http;

class MovieApi {
  List<MovieModel> parseMovieModels(String responseBody) {
    final parsed =
        (jsonDecode(responseBody) as List).cast<Map<String, dynamic>>();

    return parsed.map<MovieModel>((json) => MovieModel.fromJson(json)).toList();
  }

  Future<List<MovieModel>> fetchMovieModel() async {
    final response = await http.get(Uri.parse('${URLs.baseUrl}/movie'));

    if (response.statusCode == 200) {
      // If the server did return a 200 CREATED response,
      // then parse the JSON.
      return parseMovieModels(response.body);
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load MovieModel');
    }
  }

  // Future<MovieModel> fetchMovieModelById() async {
  //   final response = await http.get(Uri.parse('${URLs.baseUrl}/movie/'));

  //   if (response.statusCode == 200) {
  //     // If the server did return a 200 CREATED response,
  //     // then parse the JSON.
  //     return MovieModel.fromJson(jsonDecode(response.body));
  //   } else {
  //     // If the server did not return a 200 OK response,
  //     // then throw an exception.
  //     throw Exception('Failed to load MovieModel');
  //   }
  // }
}
