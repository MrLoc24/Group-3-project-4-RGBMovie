import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'screening_model.freezed.dart';

part 'screening_model.g.dart';

@freezed
class ScreeningModel with _$ScreeningModel {
  ScreeningModel._();

  factory ScreeningModel({
    @JsonKey(includeIfNull: false) required int? pk,
    required int theater,
    required int auditorium,
    required int movie,
    required DateTime time,
  }) = _ScreeningModel;

  factory ScreeningModel.fromJson(JSON json) => _$ScreeningModelFromJson(json);
}
