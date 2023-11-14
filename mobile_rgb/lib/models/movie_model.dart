import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:intl/intl.dart';
import 'package:json_annotation/json_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'movie_model.freezed.dart';

part 'movie_model.g.dart';

@freezed
class MovieModel with _$MovieModel {
  MovieModel._();

  factory MovieModel({
    required int? pk,
    required String engTitle,
    required String title,
    required int durationMin,
    required String age,
    required DateTime openingDate,
    required String genre,
    required String description,
    required String? trailer,
    @JsonKey(includeIfNull: false) double? reservationScore,
    required String mainImg,
    required String thumbnailImg,
    required double price,
  }) = _MovieModel;

  factory MovieModel.fromJson(JSON json) => _$MovieModelFromJson(json);
}
