// GENERATED CODE - DO NOT MODIFY BY HAND

part of 'user_model.dart';

// **************************************************************************
// JsonSerializableGenerator
// **************************************************************************

_$UserModelImpl _$$UserModelImplFromJson(Map<String, dynamic> json) =>
    _$UserModelImpl(
      pk: json['pk'] as int?,
      username: json['username'] as String,
      password: json['password'] as String,
      lastName: json['lastName'] as String,
      firstName: json['firstName'] as String,
      email: json['email'] as String,
      phoneNumber: json['phoneNumber'] as String,
      enabled: json['enabled'] as bool,
    );

Map<String, dynamic> _$$UserModelImplToJson(_$UserModelImpl instance) {
  final val = <String, dynamic>{};

  void writeNotNull(String key, dynamic value) {
    if (value != null) {
      val[key] = value;
    }
  }

  writeNotNull('pk', instance.pk);
  val['username'] = instance.username;
  val['password'] = instance.password;
  val['lastName'] = instance.lastName;
  val['firstName'] = instance.firstName;
  val['email'] = instance.email;
  val['phoneNumber'] = instance.phoneNumber;
  val['enabled'] = instance.enabled;
  return val;
}
