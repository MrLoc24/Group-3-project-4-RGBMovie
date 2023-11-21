import 'package:flutter/material.dart';
import 'package:movie_app_ui/api/theater_api.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_seats_picker.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_showingtime_picker.dart';
import 'package:movie_app_ui/models/movie_model.dart';
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

  late Future<List<TheaterModel>> theaterList = setTheaters();
  late Future<List<String>> futureLocationList = setLocations();

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

  Future<List<String>> setLocations() async {
    Iterable<String> list = await setTheaters()
        .then((value) => value.map((e) => e.subLocation).toList());
    print(list);

    return Set.from(list) as Future<List<String>>;
  }

  Future<List<TheaterModel>> setTheaters() async {
    return TheaterApi().fetchTheaterModel();
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
          body: ShowingTimesPicker(
            onSelectLocation: (value) {
              setState(() {
                locationSelected = value!;
                print(value);
              });
            },
            theaterList: futureLocationList,
          ));
    });
  }

  @override
  void dispose() {
    _controller.dispose();
    super.dispose();
  }
}
