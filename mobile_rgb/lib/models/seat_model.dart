import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'seat_model.freezed.dart';

part 'seat_model.g.dart';

@freezed
class SeatModel with _$SeatModel {
  SeatModel._();

  factory SeatModel({
    @JsonKey(includeIfNull: false) required int? pk,
    required String seatName,
    required int? auditorium,
    required bool? isOcuppied,
    required bool? isSelected,
  }) = _SeatModel;

  factory SeatModel.fromJson(JSON json) => _$SeatModelFromJson(json);
}
