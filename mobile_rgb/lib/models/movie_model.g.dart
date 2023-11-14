// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'movie_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$MovieModelImpl _$$MovieModelImplFromJson(Map<String, dynamic> json) =>
    _$MovieModelImpl(
      pk: json['pk'] as int?,
      engTitle: json['engTitle'] as String,
      title: json['title'] as String,
      durationMin: json['durationMin'] as int,
      age: json['age'] as String,
      openingDate: DateTime.parse(json['openingDate'] as String),
      genre: json['genre'] as String,
      description: json['description'] as String,
      trailer: json['trailer'] as String?,
      reservationScore: (json['reservationScore'] as num?)?.toDouble(),
      mainImg: json['mainImg'] as String,
      thumbnailImg: json['thumbnailImg'] as String,
      price: (json['price'] as num).toDouble(),
    );

Map<String, dynamic> _$$MovieModelImplToJson(_$MovieModelImpl instance) {
  final val = <String, dynamic>{
    'pk': instance.pk,
    'engTitle': instance.engTitle,
    'title': instance.title,
    'durationMin': instance.durationMin,
    'age': instance.age,
    'openingDate': instance.openingDate.toIso8601String(),
    'genre': instance.genre,
    'description': instance.description,
    'trailer': instance.trailer,
  };

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('reservationScore', instance.reservationScore);
  val['mainImg'] = instance.mainImg;
  val['thumbnailImg'] = instance.thumbnailImg;
  val['price'] = instance.price;
  return val;
}
