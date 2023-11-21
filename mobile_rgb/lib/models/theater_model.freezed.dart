// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'theater_model.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

TheaterModel _$TheaterModelFromJson(Map<String, dynamic> json) {
  return _TheaterModel.fromJson(json);
}

/// @nodoc
mixin _$TheaterModel {
  @JsonKey(includeIfNull: false)
  int? get pk => throw _privateConstructorUsedError;
  String get address => throw _privateConstructorUsedError;
  @JsonKey(includeIfNull: false)
  String get location => throw _privateConstructorUsedError;
  String get subLocation => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $TheaterModelCopyWith<TheaterModel> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $TheaterModelCopyWith<$Res> {
  factory $TheaterModelCopyWith(
          TheaterModel value, $Res Function(TheaterModel) then) =
      _$TheaterModelCopyWithImpl<$Res, TheaterModel>;
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String address,
      @JsonKey(includeIfNull: false) String location,
      String subLocation});
}

/// @nodoc
class _$TheaterModelCopyWithImpl<$Res, $Val extends TheaterModel>
    implements $TheaterModelCopyWith<$Res> {
  _$TheaterModelCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? address = null,
    Object? location = null,
    Object? subLocation = null,
  }) {
    return _then(_value.copyWith(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      address: null == address
          ? _value.address
          : address // ignore: cast_nullable_to_non_nullable
              as String,
      location: null == location
          ? _value.location
          : location // ignore: cast_nullable_to_non_nullable
              as String,
      subLocation: null == subLocation
          ? _value.subLocation
          : subLocation // ignore: cast_nullable_to_non_nullable
              as String,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$TheaterModelImplCopyWith<$Res>
    implements $TheaterModelCopyWith<$Res> {
  factory _$$TheaterModelImplCopyWith(
          _$TheaterModelImpl value, $Res Function(_$TheaterModelImpl) then) =
      __$$TheaterModelImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String address,
      @JsonKey(includeIfNull: false) String location,
      String subLocation});
}

/// @nodoc
class __$$TheaterModelImplCopyWithImpl<$Res>
    extends _$TheaterModelCopyWithImpl<$Res, _$TheaterModelImpl>
    implements _$$TheaterModelImplCopyWith<$Res> {
  __$$TheaterModelImplCopyWithImpl(
      _$TheaterModelImpl _value, $Res Function(_$TheaterModelImpl) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? address = null,
    Object? location = null,
    Object? subLocation = null,
  }) {
    return _then(_$TheaterModelImpl(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      address: null == address
          ? _value.address
          : address // ignore: cast_nullable_to_non_nullable
              as String,
      location: null == location
          ? _value.location
          : location // ignore: cast_nullable_to_non_nullable
              as String,
      subLocation: null == subLocation
          ? _value.subLocation
          : subLocation // ignore: cast_nullable_to_non_nullable
              as String,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$TheaterModelImpl extends _TheaterModel {
  _$TheaterModelImpl(
      {@JsonKey(includeIfNull: false) required this.pk,
      required this.address,
      @JsonKey(includeIfNull: false) required this.location,
      required this.subLocation})
      : super._();

  factory _$TheaterModelImpl.fromJson(Map<String, dynamic> json) =>
      _$$TheaterModelImplFromJson(json);

  @override
  @JsonKey(includeIfNull: false)
  final int? pk;
  @override
  final String address;
  @override
  @JsonKey(includeIfNull: false)
  final String location;
  @override
  final String subLocation;

  @override
  String toString() {
    return 'TheaterModel(pk: $pk, address: $address, location: $location, subLocation: $subLocation)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$TheaterModelImpl &&
            (identical(other.pk, pk) || other.pk == pk) &&
            (identical(other.address, address) || other.address == address) &&
            (identical(other.location, location) ||
                other.location == location) &&
            (identical(other.subLocation, subLocation) ||
                other.subLocation == subLocation));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode =>
      Object.hash(runtimeType, pk, address, location, subLocation);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$TheaterModelImplCopyWith<_$TheaterModelImpl> get copyWith =>
      __$$TheaterModelImplCopyWithImpl<_$TheaterModelImpl>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$TheaterModelImplToJson(
      this,
    );
  }
}

abstract class _TheaterModel extends TheaterModel {
  factory _TheaterModel(
      {@JsonKey(includeIfNull: false) required final int? pk,
      required final String address,
      @JsonKey(includeIfNull: false) required final String location,
      required final String subLocation}) = _$TheaterModelImpl;
  _TheaterModel._() : super._();

  factory _TheaterModel.fromJson(Map<String, dynamic> json) =
      _$TheaterModelImpl.fromJson;

  @override
  @JsonKey(includeIfNull: false)
  int? get pk;
  @override
  String get address;
  @override
  @JsonKey(includeIfNull: false)
  String get location;
  @override
  String get subLocation;
  @override
  @JsonKey(ignore: true)
  _$$TheaterModelImplCopyWith<_$TheaterModelImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
