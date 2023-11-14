// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'screening_model.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

ScreeningModel _$ScreeningModelFromJson(Map<String, dynamic> json) {
  return _ScreeningModel.fromJson(json);
}

/// @nodoc
mixin _$ScreeningModel {
  @JsonKey(includeIfNull: false)
  int? get pk => throw _privateConstructorUsedError;
  int get theater => throw _privateConstructorUsedError;
  int get auditorium => throw _privateConstructorUsedError;
  int get movie => throw _privateConstructorUsedError;
  DateTime get time => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $ScreeningModelCopyWith<ScreeningModel> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $ScreeningModelCopyWith<$Res> {
  factory $ScreeningModelCopyWith(
          ScreeningModel value, $Res Function(ScreeningModel) then) =
      _$ScreeningModelCopyWithImpl<$Res, ScreeningModel>;
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      int theater,
      int auditorium,
      int movie,
      DateTime time});
}

/// @nodoc
class _$ScreeningModelCopyWithImpl<$Res, $Val extends ScreeningModel>
    implements $ScreeningModelCopyWith<$Res> {
  _$ScreeningModelCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? theater = null,
    Object? auditorium = null,
    Object? movie = null,
    Object? time = null,
  }) {
    return _then(_value.copyWith(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      theater: null == theater
          ? _value.theater
          : theater // ignore: cast_nullable_to_non_nullable
              as int,
      auditorium: null == auditorium
          ? _value.auditorium
          : auditorium // ignore: cast_nullable_to_non_nullable
              as int,
      movie: null == movie
          ? _value.movie
          : movie // ignore: cast_nullable_to_non_nullable
              as int,
      time: null == time
          ? _value.time
          : time // ignore: cast_nullable_to_non_nullable
              as DateTime,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$ScreeningModelImplCopyWith<$Res>
    implements $ScreeningModelCopyWith<$Res> {
  factory _$$ScreeningModelImplCopyWith(_$ScreeningModelImpl value,
          $Res Function(_$ScreeningModelImpl) then) =
      __$$ScreeningModelImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      int theater,
      int auditorium,
      int movie,
      DateTime time});
}

/// @nodoc
class __$$ScreeningModelImplCopyWithImpl<$Res>
    extends _$ScreeningModelCopyWithImpl<$Res, _$ScreeningModelImpl>
    implements _$$ScreeningModelImplCopyWith<$Res> {
  __$$ScreeningModelImplCopyWithImpl(
      _$ScreeningModelImpl _value, $Res Function(_$ScreeningModelImpl) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? theater = null,
    Object? auditorium = null,
    Object? movie = null,
    Object? time = null,
  }) {
    return _then(_$ScreeningModelImpl(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      theater: null == theater
          ? _value.theater
          : theater // ignore: cast_nullable_to_non_nullable
              as int,
      auditorium: null == auditorium
          ? _value.auditorium
          : auditorium // ignore: cast_nullable_to_non_nullable
              as int,
      movie: null == movie
          ? _value.movie
          : movie // ignore: cast_nullable_to_non_nullable
              as int,
      time: null == time
          ? _value.time
          : time // ignore: cast_nullable_to_non_nullable
              as DateTime,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$ScreeningModelImpl extends _ScreeningModel {
  _$ScreeningModelImpl(
      {@JsonKey(includeIfNull: false) required this.pk,
      required this.theater,
      required this.auditorium,
      required this.movie,
      required this.time})
      : super._();

  factory _$ScreeningModelImpl.fromJson(Map<String, dynamic> json) =>
      _$$ScreeningModelImplFromJson(json);

  @override
  @JsonKey(includeIfNull: false)
  final int? pk;
  @override
  final int theater;
  @override
  final int auditorium;
  @override
  final int movie;
  @override
  final DateTime time;

  @override
  String toString() {
    return 'ScreeningModel(pk: $pk, theater: $theater, auditorium: $auditorium, movie: $movie, time: $time)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$ScreeningModelImpl &&
            (identical(other.pk, pk) || other.pk == pk) &&
            (identical(other.theater, theater) || other.theater == theater) &&
            (identical(other.auditorium, auditorium) ||
                other.auditorium == auditorium) &&
            (identical(other.movie, movie) || other.movie == movie) &&
            (identical(other.time, time) || other.time == time));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode =>
      Object.hash(runtimeType, pk, theater, auditorium, movie, time);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$ScreeningModelImplCopyWith<_$ScreeningModelImpl> get copyWith =>
      __$$ScreeningModelImplCopyWithImpl<_$ScreeningModelImpl>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$ScreeningModelImplToJson(
      this,
    );
  }
}

abstract class _ScreeningModel extends ScreeningModel {
  factory _ScreeningModel(
      {@JsonKey(includeIfNull: false) required final int? pk,
      required final int theater,
      required final int auditorium,
      required final int movie,
      required final DateTime time}) = _$ScreeningModelImpl;
  _ScreeningModel._() : super._();

  factory _ScreeningModel.fromJson(Map<String, dynamic> json) =
      _$ScreeningModelImpl.fromJson;

  @override
  @JsonKey(includeIfNull: false)
  int? get pk;
  @override
  int get theater;
  @override
  int get auditorium;
  @override
  int get movie;
  @override
  DateTime get time;
  @override
  @JsonKey(ignore: true)
  _$$ScreeningModelImplCopyWith<_$ScreeningModelImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
