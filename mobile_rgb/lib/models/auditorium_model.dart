import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'auditorium_model.freezed.dart';

part 'auditorium_model.g.dart';

@freezed
class AuditoriumModel with _$AuditoriumModel {
  AuditoriumModel._();

  factory AuditoriumModel({
    @JsonKey(includeIfNull: false) required int? pk,
    required String name,
    required int column,
    required int row,
    required int theater,
  }) = _AuditoriumModel;

  factory AuditoriumModel.fromJson(JSON json) =>
      _$AuditoriumModelFromJson(json);
}
