import 'dart:convert';

import 'package:movie_app_ui/core/constants/url.dart';
import 'package:http/http.dart' as http;
import 'package:movie_app_ui/models/screening_model.dart';

class ScreeningApi {
  Future<List<ScreeningModel>> fetchScreeningModel(
      String theaterId, String movieId) async {
    final response = await http.get(Uri.parse(
        '${URLs.baseUrl}/screening?theater=$theaterId&movie=$movieId'));

    if (response.statusCode == 200) {
      // print(jsonDecode(response.body) as List);
      final parsed =
          (jsonDecode(response.body) as List).cast<Map<String, dynamic>>();
      // If the server did return a 200 CREATED response,
      // then parse the JSON.
      final result = parsed
          .map<ScreeningModel>((json) => ScreeningModel.fromJson(json))
          .toList();
      return result;
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load ScreeningModel');
    }
  }
}
