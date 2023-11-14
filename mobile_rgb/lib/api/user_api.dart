import 'dart:convert';

import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:movie_app_ui/core/constants/url.dart';

import 'package:http/http.dart' as http;
import 'package:movie_app_ui/models/user_model.dart';

class UserApi {
  final storage = const FlutterSecureStorage();
  Future<String> login(data) async {
    final response = await http.post(Uri.parse('${URLs.baseUrl}/auth'),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(data));
    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);

      await storage.write(key: 'token', value: data['accessToken']);
      await storage.write(key: 'username', value: data['username']);
      return "Success";
    } else {
      throw Exception("Invalid username or password");
    }
  }

  Future<UserModel> getUser(username) async {
    final String? auth = await storage.read(key: 'token');
    final response = await http.get(
      Uri.parse('${URLs.baseUrl}/user/profile/${username}'),
      headers: <String, String>{
        'Content-Type': 'application/json; charset=UTF-8',
        'Authorization': 'Bearer ${auth}'
      },
    );
    if (response.statusCode == 200) {
      final data = jsonDecode(response.body);
      return UserModel.fromJson(data);
    } else {
      throw Exception("Something went wrong");
    }
  }

  void logout() async {
    await storage.delete(key: 'token');
    await storage.delete(key: 'username');
  }
}