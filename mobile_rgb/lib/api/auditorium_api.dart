import 'dart:convert';

import 'package:movie_app_ui/api/user_api.dart';
import 'package:movie_app_ui/core/constants/url.dart';
import 'package:http/http.dart' as http;
import 'package:movie_app_ui/models/auditorium_model.dart';

class AuditoriumApi {
  final List<String> isOcuppiedSeats = List.empty();
  Future<AuditoriumModel> fetchAuditoriumModel(String auditoriumId) async {
    final String? auth = await UserApi().getToken();
    final response = await http.get(
      Uri.parse('${URLs.baseUrl}/auditorium/$auditoriumId'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
        'Authorization': 'Bearer ${auth}'
      },
    );
    if (response.statusCode == 200) {
      // print(jsonDecode(response.body) as List);
      final parsed = (jsonDecode(response.body));
      // If the server did return a 200 CREATED response,
      // then parse the JSON.
      final seats = parsed['Seat'];
      seats.map((e) => isOcuppiedSeats.add(e.toString()));
      final result = AuditoriumModel.fromJson(parsed['Audi']);
      return result;
    } else {
      // If the server did not return a 200 OK response,
      // then throw an exception.
      throw Exception('Failed to load ScreeningModel');
    }
  }

  Future<List<String>> getOcuppied() async {
    print(isOcuppiedSeats);
    return isOcuppiedSeats;
  }
}
