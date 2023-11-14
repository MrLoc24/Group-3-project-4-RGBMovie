// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'screening_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$ScreeningModelImpl _$$ScreeningModelImplFromJson(Map<String, dynamic> json) =>
    _$ScreeningModelImpl(
      pk: json['pk'] as int?,
      theater: json['theater'] as int,
      auditorium: json['auditorium'] as int,
      movie: json['movie'] as int,
      time: DateTime.parse(json['time'] as String),
    );

Map<String, dynamic> _$$ScreeningModelImplToJson(
    _$ScreeningModelImpl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pk', instance.pk);
  val['theater'] = instance.theater;
  val['auditorium'] = instance.auditorium;
  val['movie'] = instance.movie;
  val['time'] = instance.time.toIso8601String();
  return val;
}
