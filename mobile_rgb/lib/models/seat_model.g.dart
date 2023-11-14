// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'seat_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$SeatModelImpl _$$SeatModelImplFromJson(Map<String, dynamic> json) =>
    _$SeatModelImpl(
      pk: json['pk'] as int?,
      seatName: json['seatName'] as String,
      auditorium: json['auditorium'] as int,
    );

Map<String, dynamic> _$$SeatModelImplToJson(_$SeatModelImpl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pk', instance.pk);
  val['seatName'] = instance.seatName;
  val['auditorium'] = instance.auditorium;
  return val;
}
