// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'theater_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$TheaterModelImpl _$$TheaterModelImplFromJson(Map<String, dynamic> json) =>
    _$TheaterModelImpl(
      pk: json['pk'] as int?,
      address: json['address'] as String,
      location: json['location'] as String,
      subLocation: json['subLocation'] as String,
    );

Map<String, dynamic> _$$TheaterModelImplToJson(_$TheaterModelImpl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pk', instance.pk);
  val['address'] = instance.address;
  val['location'] = instance.location;
  val['subLocation'] = instance.subLocation;
  return val;
}
