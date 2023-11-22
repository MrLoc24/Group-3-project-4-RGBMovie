import 'dart:convert';

import 'package:movie_app_ui/core/constants/url.dart';

import '../models/theater_model.dart';
import 'package:http/http.dart' as http;

class TheaterApi {
  Future<List<TheaterModel>> fetchTheaterModel() async {
    final response = await http.get(Uri.parse('${URLs.baseUrl}/theater/'));

    if (response.statusCode == 200) {
      // print(jsonDecode(response.body) as List);
      final parsed =
          (jsonDecode(response.body) as List).cast<Map<String, dynamic>>();
      // If the server did return a 200 CREATED response,
      // then parse the JSON.
      print(parsed);
      final result = parsed.map((json) => TheaterModel.fromJson(json)).toList();
      print(result);
      return result;
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load TheaterModel');
    }
  }
}
