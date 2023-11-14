// coverage:ignore-file
// GENERATED CODE - DO NOT MODIFY BY HAND
// ignore_for_file: type=lint
// ignore_for_file: unused_element, deprecated_member_use, deprecated_member_use_from_same_package, use_function_type_syntax_for_parameters, unnecessary_const, avoid_init_to_null, invalid_override_different_default_values_named, prefer_expression_function_bodies, annotate_overrides, invalid_annotation_target, unnecessary_question_mark

part of 'auditorium_model.dart';

// **************************************************************************
// FreezedGenerator
// **************************************************************************

T _$identity<T>(T value) => value;

final _privateConstructorUsedError = UnsupportedError(
    'It seems like you constructed your class using `MyClass._()`. This constructor is only meant to be used by freezed and you are not supposed to need it nor use it.\nPlease check the documentation here for more information: https://github.com/rrousselGit/freezed#custom-getters-and-methods');

AuditoriumModel _$AuditoriumModelFromJson(Map<String, dynamic> json) {
  return _AuditoriumModel.fromJson(json);
}

/// @nodoc
mixin _$AuditoriumModel {
  @JsonKey(includeIfNull: false)
  int? get pk => throw _privateConstructorUsedError;
  String get name => throw _privateConstructorUsedError;
  int get column => throw _privateConstructorUsedError;
  int get row => throw _privateConstructorUsedError;
  int get theater => throw _privateConstructorUsedError;

  Map<String, dynamic> toJson() => throw _privateConstructorUsedError;
  @JsonKey(ignore: true)
  $AuditoriumModelCopyWith<AuditoriumModel> get copyWith =>
      throw _privateConstructorUsedError;
}

/// @nodoc
abstract class $AuditoriumModelCopyWith<$Res> {
  factory $AuditoriumModelCopyWith(
          AuditoriumModel value, $Res Function(AuditoriumModel) then) =
      _$AuditoriumModelCopyWithImpl<$Res, AuditoriumModel>;
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String name,
      int column,
      int row,
      int theater});
}

/// @nodoc
class _$AuditoriumModelCopyWithImpl<$Res, $Val extends AuditoriumModel>
    implements $AuditoriumModelCopyWith<$Res> {
  _$AuditoriumModelCopyWithImpl(this._value, this._then);

  // ignore: unused_field
  final $Val _value;
  // ignore: unused_field
  final $Res Function($Val) _then;

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? name = null,
    Object? column = null,
    Object? row = null,
    Object? theater = null,
  }) {
    return _then(_value.copyWith(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      column: null == column
          ? _value.column
          : column // ignore: cast_nullable_to_non_nullable
              as int,
      row: null == row
          ? _value.row
          : row // ignore: cast_nullable_to_non_nullable
              as int,
      theater: null == theater
          ? _value.theater
          : theater // ignore: cast_nullable_to_non_nullable
              as int,
    ) as $Val);
  }
}

/// @nodoc
abstract class _$$AuditoriumModelImplCopyWith<$Res>
    implements $AuditoriumModelCopyWith<$Res> {
  factory _$$AuditoriumModelImplCopyWith(_$AuditoriumModelImpl value,
          $Res Function(_$AuditoriumModelImpl) then) =
      __$$AuditoriumModelImplCopyWithImpl<$Res>;
  @override
  @useResult
  $Res call(
      {@JsonKey(includeIfNull: false) int? pk,
      String name,
      int column,
      int row,
      int theater});
}

/// @nodoc
class __$$AuditoriumModelImplCopyWithImpl<$Res>
    extends _$AuditoriumModelCopyWithImpl<$Res, _$AuditoriumModelImpl>
    implements _$$AuditoriumModelImplCopyWith<$Res> {
  __$$AuditoriumModelImplCopyWithImpl(
      _$AuditoriumModelImpl _value, $Res Function(_$AuditoriumModelImpl) _then)
      : super(_value, _then);

  @pragma('vm:prefer-inline')
  @override
  $Res call({
    Object? pk = freezed,
    Object? name = null,
    Object? column = null,
    Object? row = null,
    Object? theater = null,
  }) {
    return _then(_$AuditoriumModelImpl(
      pk: freezed == pk
          ? _value.pk
          : pk // ignore: cast_nullable_to_non_nullable
              as int?,
      name: null == name
          ? _value.name
          : name // ignore: cast_nullable_to_non_nullable
              as String,
      column: null == column
          ? _value.column
          : column // ignore: cast_nullable_to_non_nullable
              as int,
      row: null == row
          ? _value.row
          : row // ignore: cast_nullable_to_non_nullable
              as int,
      theater: null == theater
          ? _value.theater
          : theater // ignore: cast_nullable_to_non_nullable
              as int,
    ));
  }
}

/// @nodoc
@JsonSerializable()
class _$AuditoriumModelImpl extends _AuditoriumModel {
  _$AuditoriumModelImpl(
      {@JsonKey(includeIfNull: false) required this.pk,
      required this.name,
      required this.column,
      required this.row,
      required this.theater})
      : super._();

  factory _$AuditoriumModelImpl.fromJson(Map<String, dynamic> json) =>
      _$$AuditoriumModelImplFromJson(json);

  @override
  @JsonKey(includeIfNull: false)
  final int? pk;
  @override
  final String name;
  @override
  final int column;
  @override
  final int row;
  @override
  final int theater;

  @override
  String toString() {
    return 'AuditoriumModel(pk: $pk, name: $name, column: $column, row: $row, theater: $theater)';
  }

  @override
  bool operator ==(dynamic other) {
    return identical(this, other) ||
        (other.runtimeType == runtimeType &&
            other is _$AuditoriumModelImpl &&
            (identical(other.pk, pk) || other.pk == pk) &&
            (identical(other.name, name) || other.name == name) &&
            (identical(other.column, column) || other.column == column) &&
            (identical(other.row, row) || other.row == row) &&
            (identical(other.theater, theater) || other.theater == theater));
  }

  @JsonKey(ignore: true)
  @override
  int get hashCode => Object.hash(runtimeType, pk, name, column, row, theater);

  @JsonKey(ignore: true)
  @override
  @pragma('vm:prefer-inline')
  _$$AuditoriumModelImplCopyWith<_$AuditoriumModelImpl> get copyWith =>
      __$$AuditoriumModelImplCopyWithImpl<_$AuditoriumModelImpl>(
          this, _$identity);

  @override
  Map<String, dynamic> toJson() {
    return _$$AuditoriumModelImplToJson(
      this,
    );
  }
}

abstract class _AuditoriumModel extends AuditoriumModel {
  factory _AuditoriumModel(
      {@JsonKey(includeIfNull: false) required final int? pk,
      required final String name,
      required final int column,
      required final int row,
      required final int theater}) = _$AuditoriumModelImpl;
  _AuditoriumModel._() : super._();

  factory _AuditoriumModel.fromJson(Map<String, dynamic> json) =
      _$AuditoriumModelImpl.fromJson;

  @override
  @JsonKey(includeIfNull: false)
  int? get pk;
  @override
  String get name;
  @override
  int get column;
  @override
  int get row;
  @override
  int get theater;
  @override
  @JsonKey(ignore: true)
  _$$AuditoriumModelImplCopyWith<_$AuditoriumModelImpl> get copyWith =>
      throw _privateConstructorUsedError;
}
