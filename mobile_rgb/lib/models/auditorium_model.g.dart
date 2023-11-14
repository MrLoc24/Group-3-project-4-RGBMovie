// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'auditorium_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$AuditoriumModelImpl _$$AuditoriumModelImplFromJson(
        Map<String, dynamic> json) =>
    _$AuditoriumModelImpl(
      pk: json['pk'] as int?,
      name: json['name'] as String,
      column: json['column'] as int,
      row: json['row'] as int,
      theater: json['theater'] as int,
    );

Map<String, dynamic> _$$AuditoriumModelImplToJson(
    _$AuditoriumModelImpl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pk', instance.pk);
  val['name'] = instance.name;
  val['column'] = instance.column;
  val['row'] = instance.row;
  val['theater'] = instance.theater;
  return val;
}
