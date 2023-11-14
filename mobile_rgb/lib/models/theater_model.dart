import 'package:freezed_annotation/freezed_annotation.dart';
import 'package:movie_app_ui/helper/typedefs.dart';

part 'theater_model.freezed.dart';

part 'theater_model.g.dart';

@freezed
class TheaterModel with _$TheaterModel {
  TheaterModel._();

  factory TheaterModel({
    @JsonKey(includeIfNull: false) required int? pk,
    required String address,
    required String location,
    required String subLocation,
  }) = _TheaterModel;

  factory TheaterModel.fromJson(JSON json) => _$TheaterModelFromJson(json);
}
