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
      await storage.delete(key: 'token');
      await storage.delete(key: 'username');
      await storage.write(key: 'token', value: data['accessToken']);
      await storage.write(key: 'username', value: data['username']);
      return "Success";
    } else {
      return "Invalid username or password";
    }
  }

  Future<UserModel> getUser(String username) async {
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

  Future<UserModel> editUser(UserModel data) async {
    final String? auth = await storage.read(key: 'token');
    final response = await http.post(Uri.parse('${URLs.baseUrl}/user/edit'),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
          'Authorization': 'Bearer ${auth}'
        },
        body: jsonEncode(data));
    if (response.statusCode == 200) {
      await storage.delete(key: 'username');
      await storage.write(key: 'username', value: data.username);
      return await getUser(data.username);
    } else {
      throw Exception("Something went wrong");
    }
  }

  Future<String> changePassword(data) async {
    final String? auth = await storage.read(key: 'token');
    final String? username = await storage.read(key: 'username');
    final response = await http.post(
        Uri.parse('${URLs.baseUrl}/user/edit/password/${username}'),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
          'Authorization': 'Bearer ${auth}'
        },
        body: jsonEncode(data));
    if (response.statusCode == 200) {
      return response.body;
    } else {
      return "Something went wrong";
    }
  }

  Future<String> signUp(data) async {
    final response = await http.post(Uri.parse('${URLs.baseUrl}/signup'),
        headers: <String, String>{
          'Content-Type': 'application/json; charset=UTF-8',
        },
        body: jsonEncode(data));
    if (response.statusCode == 200) {
      return "Success";
    }
    return response.body;
  }

  void logout() async {
    await storage.delete(key: 'token');
    await storage.delete(key: 'username');
  }
}
