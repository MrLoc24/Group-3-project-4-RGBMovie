// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'seat_model.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

SeatModel _$SeatModelFromJson(Map<String, dynamic> json) {
  return _SeatModel.fromJson(json);
}

/// @nodoc
mixin _$SeatModel {
  @JsonKey(includeIfNull: false)
  int? get pk => throw _privateConstructorUsedError;
  String get seatName => throw _privateConstructorUsedError;
  int? get auditorium => throw _privateConstructorUsedError;
  bool? get isOcuppied => throw _privateConstructorUsedError;
  bool? get isSelected => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $SeatModelCopyWith<SeatModel> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $SeatModelCopyWith<$Res> {
  factory $SeatModelCopyWith(SeatModel value, $Res Function(SeatModel) then) =
      _$SeatModelCopyWithImpl<$Res, SeatModel>;
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String seatName,
      int? auditorium,
      bool? isOcuppied,
      bool? isSelected});
}

/// @nodoc
class _$SeatModelCopyWithImpl<$Res, $Val extends SeatModel>
    implements $SeatModelCopyWith<$Res> {
  _$SeatModelCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? seatName = null,
    Object? auditorium = freezed,
    Object? isOcuppied = freezed,
    Object? isSelected = freezed,
  }) {
    return _then(_value.copyWith(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      seatName: null == seatName
          ? _value.seatName
          : seatName // ignore: cast_nullable_to_non_nullable
              as String,
      auditorium: freezed == auditorium
          ? _value.auditorium
          : auditorium // ignore: cast_nullable_to_non_nullable
              as int?,
      isOcuppied: freezed == isOcuppied
          ? _value.isOcuppied
          : isOcuppied // ignore: cast_nullable_to_non_nullable
              as bool?,
      isSelected: freezed == isSelected
          ? _value.isSelected
          : isSelected // ignore: cast_nullable_to_non_nullable
              as bool?,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$SeatModelImplCopyWith<$Res>
    implements $SeatModelCopyWith<$Res> {
  factory _$$SeatModelImplCopyWith(
          _$SeatModelImpl value, $Res Function(_$SeatModelImpl) then) =
      __$$SeatModelImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String seatName,
      int? auditorium,
      bool? isOcuppied,
      bool? isSelected});
}

/// @nodoc
class __$$SeatModelImplCopyWithImpl<$Res>
    extends _$SeatModelCopyWithImpl<$Res, _$SeatModelImpl>
    implements _$$SeatModelImplCopyWith<$Res> {
  __$$SeatModelImplCopyWithImpl(
      _$SeatModelImpl _value, $Res Function(_$SeatModelImpl) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? seatName = null,
    Object? auditorium = freezed,
    Object? isOcuppied = freezed,
    Object? isSelected = freezed,
  }) {
    return _then(_$SeatModelImpl(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      seatName: null == seatName
          ? _value.seatName
          : seatName // ignore: cast_nullable_to_non_nullable
              as String,
      auditorium: freezed == auditorium
          ? _value.auditorium
          : auditorium // ignore: cast_nullable_to_non_nullable
              as int?,
      isOcuppied: freezed == isOcuppied
          ? _value.isOcuppied
          : isOcuppied // ignore: cast_nullable_to_non_nullable
              as bool?,
      isSelected: freezed == isSelected
          ? _value.isSelected
          : isSelected // ignore: cast_nullable_to_non_nullable
              as bool?,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$SeatModelImpl extends _SeatModel {
  _$SeatModelImpl(
      {@JsonKey(includeIfNull: false) required this.pk,
      required this.seatName,
      required this.auditorium,
      required this.isOcuppied,
      required this.isSelected})
      : super._();

  factory _$SeatModelImpl.fromJson(Map<String, dynamic> json) =>
      _$$SeatModelImplFromJson(json);

  @override
  @JsonKey(includeIfNull: false)
  final int? pk;
  @override
  final String seatName;
  @override
  final int? auditorium;
  @override
  final bool? isOcuppied;
  @override
  final bool? isSelected;

  @override
  String toString() {
    return 'SeatModel(pk: $pk, seatName: $seatName, auditorium: $auditorium, isOcuppied: $isOcuppied, isSelected: $isSelected)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$SeatModelImpl &&
            (identical(other.pk, pk) || other.pk == pk) &&
            (identical(other.seatName, seatName) ||
                other.seatName == seatName) &&
            (identical(other.auditorium, auditorium) ||
                other.auditorium == auditorium) &&
            (identical(other.isOcuppied, isOcuppied) ||
                other.isOcuppied == isOcuppied) &&
            (identical(other.isSelected, isSelected) ||
                other.isSelected == isSelected));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(
      runtimeType, pk, seatName, auditorium, isOcuppied, isSelected);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$SeatModelImplCopyWith<_$SeatModelImpl> get copyWith =>
      __$$SeatModelImplCopyWithImpl<_$SeatModelImpl>(this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$SeatModelImplToJson(
      this,
    );
  }
}

abstract class _SeatModel extends SeatModel {
  factory _SeatModel(
      {@JsonKey(includeIfNull: false) required final int? pk,
      required final String seatName,
      required final int? auditorium,
      required final bool? isOcuppied,
      required final bool? isSelected}) = _$SeatModelImpl;
  _SeatModel._() : super._();

  factory _SeatModel.fromJson(Map<String, dynamic> json) =
      _$SeatModelImpl.fromJson;

  @override
  @JsonKey(includeIfNull: false)
  int? get pk;
  @override
  String get seatName;
  @override
  int? get auditorium;
  @override
  bool? get isOcuppied;
  @override
  bool? get isSelected;
  @override
  @JsonKey(ignore: true)
  _$$SeatModelImplCopyWith<_$SeatModelImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
