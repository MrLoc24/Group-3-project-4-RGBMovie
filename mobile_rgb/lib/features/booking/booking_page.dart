import 'package:flutter/material.dart';
import 'package:movie_app_ui/api/auditorium_api.dart';
import 'package:movie_app_ui/api/screening_api.dart';
import 'package:movie_app_ui/api/theater_api.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_seats_picker.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_showingtime_picker.dart';
import 'package:movie_app_ui/models/auditorium_model.dart';
import 'package:movie_app_ui/models/movie_model.dart';
import 'package:movie_app_ui/models/screening_model.dart';
import 'package:movie_app_ui/models/theater_model.dart';

import './widgets/widgets.dart';
import './animations/animations.dart';

class BookingPage extends StatefulWidget {
  const BookingPage({Key? key, required this.movie}) : super(key: key);

  final MovieModel movie;

  @override
  State<BookingPage> createState() => _BookingPageState();
}

class _BookingPageState extends State<BookingPage>
    with TickerProviderStateMixin {
  late final BookingPageAnimationController _controller;
  String locationSelected = '';
  String theaterSelected = '';
  ScreeningModel? screeningSelected;
  AuditoriumModel auditorium =
      AuditoriumModel(pk: 1, name: 'not found', column: 4, row: 4, theater: 1);
  List<String> isOcuppiedSeats = List.empty();
  List<String> seatsSelected = List.empty();

  late Future<List<TheaterModel>> theaterList = setTheaters();
  Future<List<ScreeningModel>>? screeningList;
  Future<List<DateTime>>? dateList;

  @override
  void initState() {
    _controller = BookingPageAnimationController(
      buttonController: AnimationController(
        duration: const Duration(milliseconds: 750),
        vsync: this,
      ),
      contentController: AnimationController(
        duration: const Duration(milliseconds: 750),
        vsync: this,
      ),
    );
    WidgetsBinding.instance?.addPostFrameCallback((_) async {
      await _controller.buttonController.forward();
      await _controller.buttonController.reverse();
      await _controller.contentController.forward();
    });
    super.initState();
  }

  Future<List<TheaterModel>> setTheaters() async {
    return TheaterApi().fetchTheaterModel();
  }

  void onSelectLocation(String value) {
    setState(() {
      locationSelected = value!;
      print(value);
    });
  }

  void onSelectTheater(String value) {
    setState(() {
      theaterSelected = value;
      print(value);
      Future<List<ScreeningModel>> result = ScreeningApi()
          .fetchScreeningModel(value.toString(), widget.movie.pk.toString());
      screeningList = result;
      dateList = result.then((value) => value.map((e) => e.time).toList());
    });
  }

  void onSelectSeats(String value) {
    setState(() {
      seatsSelected.add(value);
    });
  }

  onSelectedScreening(ScreeningModel value) {
    print(value);
    // Call booking API here
    setState(() async {
      screeningSelected = value!;
      auditorium = await AuditoriumApi()
          .fetchAuditoriumModel(value!.auditorium.toString());
      isOcuppiedSeats = await AuditoriumApi().getOcuppied();
    });
  }

  @override
  Widget build(BuildContext context) {
    return LayoutBuilder(builder: (context, constraints) {
      final w = constraints.maxWidth;
      final h = constraints.maxHeight;

      return Scaffold(
          extendBodyBehindAppBar: true,
          appBar: PreferredSize(
            preferredSize: const Size.fromHeight(kToolbarHeight),
            child: CustomAnimatedOpacity(
              animation: _controller.topOpacityAnimation,
              child: MovieAppBar(title: widget.movie.title),
            ),
          ),
          body: SafeArea(
            child: ShowingTimesPicker(
                onSelectScreening: onSelectedScreening,
                onSelectLocation: onSelectLocation,
                onSelectTheater: onSelectTheater,
                onSelectSeats: onSelectSeats,
                theaterList: theaterList,
                dateList: dateList,
                screeningList: screeningList,
                auditorium: auditorium,
                isOcuppiedSeats: isOcuppiedSeats,
                maxHeight: constraints.maxHeight,
                maxWidth: constraints.maxWidth,
                bookingPageAnimationController: _controller,
                mainImg: widget.movie.mainImg),
          ));
    });
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
