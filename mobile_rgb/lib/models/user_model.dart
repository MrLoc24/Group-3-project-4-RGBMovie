import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'user_model.freezed.dart';

part 'user_model.g.dart';

@freezed
class UserModel with _$UserModel {
  UserModel._();

  factory UserModel({
    @JsonKey(includeIfNull: false) required int? pk,
    required String username,
    required String password,
    required String lastName,
    required String firstName,
    required String email,
    required String phoneNumber,
    required bool enabled,
  }) = _UserModel;

  factory UserModel.fromJson(JSON json) => _$UserModelFromJson(json);
}
