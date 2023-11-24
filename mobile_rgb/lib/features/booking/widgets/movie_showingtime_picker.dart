import 'package:flutter/material.dart';
import 'package:movie_app_ui/core/constants/app_colors.dart';
import 'package:movie_app_ui/features/booking/animations/booking_page_animation_controller.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_seats_picker.dart';
import 'package:movie_app_ui/models/auditorium_model.dart';
import 'package:movie_app_ui/models/screening_model.dart';
import 'package:movie_app_ui/models/theater_model.dart';

class ShowingTimesPicker extends StatefulWidget {
  const ShowingTimesPicker({
    super.key,
    required this.onSelectLocation,
    required this.theaterList,
    required this.onSelectTheater,
    this.screeningList,
    required this.maxHeight,
    required this.maxWidth,
    this.dateList,
    required this.bookingPageAnimationController,
    required this.mainImg,
    required this.onSelectScreening,
    this.auditorium,
    required this.isOcuppiedSeats,
    required this.onSelectSeats,
  });

  final Function(String value) onSelectLocation;
  final Function(String value) onSelectTheater;
  final Function(ScreeningModel value) onSelectScreening;
  final Function(String value) onSelectSeats;
  final Future<List<TheaterModel>> theaterList;
  final Future<List<DateTime>>? dateList;
  final Future<List<ScreeningModel>>? screeningList;
  final double maxHeight;
  final double maxWidth;
  final BookingPageAnimationController bookingPageAnimationController;
  final String mainImg;
  final AuditoriumModel? auditorium;
  final List<String> isOcuppiedSeats;

  @override
  State<ShowingTimesPicker> createState() => _ShowingTimesPickerState();
}

class _ShowingTimesPickerState extends State<ShowingTimesPicker> {
  final TextEditingController locationController = TextEditingController();
  final TextEditingController theaterController = TextEditingController();
  final TextEditingController dateController = TextEditingController();
  final TextEditingController screeningController = TextEditingController();
  String? selectedLocation;
  String? selectedTheater;
  String? selectedDate;
  ScreeningModel? selectedScreening;
  bool showSeatPicker = false;

  @override
  Widget build(BuildContext context) {
    print("movie showing time picker!!!");
    print(widget.auditorium);
    // TODO: implement build
    return LayoutBuilder(
      builder: (context, constraints) {
        return SingleChildScrollView(
            child: ConstrainedBox(
          constraints: BoxConstraints(
              maxHeight: constraints.maxHeight, maxWidth: constraints.maxWidth),
          child: !showSeatPicker
              ? Column(
                  mainAxisSize: MainAxisSize.min,
                  mainAxisAlignment: MainAxisAlignment.spaceAround,
                  crossAxisAlignment: CrossAxisAlignment.center,
                  children: <Widget>[
                    // Theater Select
                    SizedBox(
                      child: Padding(
                          padding: const EdgeInsets.symmetric(vertical: 12),
                          child: FutureBuilder<List<TheaterModel>>(
                              future: widget.theaterList,
                              builder: (BuildContext context,
                                  AsyncSnapshot<List<TheaterModel>> snapshot) {
                                if (snapshot.hasData) {
                                  Iterable<String> getLocation = snapshot.data
                                          ?.map((item) => item.subLocation)
                                      as Iterable<String>;
                                  final locations =
                                      Set<String>.from(getLocation).toList();
                                  final theaters = snapshot.data
                                      ?.where((element) =>
                                          element.subLocation ==
                                          selectedLocation)
                                      .map((e) => e.address)
                                      .toList();
                                  return Row(
                                      mainAxisAlignment:
                                          MainAxisAlignment.center,
                                      children: [
                                        DropdownMenu<String>(
                                            controller: locationController,
                                            enableFilter: true,
                                            requestFocusOnTap: true,
                                            label: const Text('Location'),
                                            inputDecorationTheme:
                                                const InputDecorationTheme(
                                              filled: true,
                                              contentPadding:
                                                  EdgeInsets.symmetric(
                                                      vertical: 5.0),
                                            ),
                                            onSelected: (String? value) {
                                              setState(() {
                                                selectedLocation = value;
                                              });
                                              widget.onSelectLocation(value!);
                                            },
                                            dropdownMenuEntries: locations!
                                                .map<DropdownMenuEntry<String>>(
                                              (dynamic value) {
                                                return DropdownMenuEntry<
                                                    String>(
                                                  value: value,
                                                  label: value,
                                                );
                                              },
                                            ).toList()),
                                        const SizedBox(width: 10),
                                        DropdownMenu<String>(
                                            controller: theaterController,
                                            enableFilter: true,
                                            requestFocusOnTap: true,
                                            label: const Text('Theater'),
                                            inputDecorationTheme:
                                                const InputDecorationTheme(
                                              filled: true,
                                              contentPadding:
                                                  EdgeInsets.symmetric(
                                                      vertical: 5.0),
                                            ),
                                            onSelected: (String? value) {
                                              setState(() {
                                                selectedTheater = value;
                                              });
                                              final theaterId = snapshot.data
                                                  ?.where((element) =>
                                                      element.address == value)
                                                  .toList()
                                                  .first;
                                              widget.onSelectTheater(
                                                  theaterId!.pk.toString());
                                            },
                                            dropdownMenuEntries: theaters!
                                                .map<DropdownMenuEntry<String>>(
                                              (dynamic value) {
                                                return DropdownMenuEntry<
                                                    String>(
                                                  value: value,
                                                  label: value,
                                                );
                                              },
                                            ).toList())
                                      ]);
                                } else if (snapshot.hasError) {
                                  return Container(
                                      width: 200,
                                      height: 200,
                                      child: Text('Error: ${snapshot.error}'));
                                }
                                return CircularProgressIndicator();
                              })),
                    ),
                    // Date Select
                    SizedBox(
                      child: Padding(
                          padding: const EdgeInsets.symmetric(vertical: 20),
                          child: FutureBuilder<List<DateTime>>(
                            future: widget.dateList,
                            builder: (context, snapshot) {
                              if (snapshot.hasData) {
                                List<String>? dates = snapshot.data!
                                    .map((e) =>
                                        e.toIso8601String().substring(0, 10))
                                    .toSet()
                                    .toList();
                                return Row(
                                  mainAxisAlignment: MainAxisAlignment.center,
                                  children: [
                                    DropdownMenu<String>(
                                        width: constraints.maxWidth * 0.8,
                                        controller: dateController,
                                        enableFilter: true,
                                        requestFocusOnTap: true,
                                        label: const Text('Choose Date'),
                                        inputDecorationTheme:
                                            const InputDecorationTheme(
                                          filled: true,
                                          contentPadding: EdgeInsets.symmetric(
                                              vertical: 5.0, horizontal: 5.0),
                                        ),
                                        onSelected: (String? value) {
                                          setState(() {
                                            selectedDate = value;
                                          });
                                        },
                                        dropdownMenuEntries: dates!
                                            .map<DropdownMenuEntry<String>>(
                                          (String value) {
                                            return DropdownMenuEntry<String>(
                                              value: value,
                                              label: value,
                                            );
                                          },
                                        ).toList())
                                  ],
                                );
                              }
                              return CircularProgressIndicator();
                            },
                          )),
                    ),
                    // Screening Select
                    SizedBox(
                      child: Padding(
                          padding: const EdgeInsets.symmetric(vertical: 20),
                          child: FutureBuilder<List<ScreeningModel>>(
                            future: widget.screeningList,
                            builder: (context, snapshot) {
                              if (snapshot.hasData) {
                                List<ScreeningModel> screenings = snapshot.data!
                                    .where((element) =>
                                        element.time
                                            .toIso8601String()
                                            .substring(0, 10) ==
                                        selectedDate)
                                    .toList();
                                return SizedBox(
                                  height: constraints.maxHeight * 0.1,
                                  width: constraints.maxWidth * 0.8,
                                  child: ListView(
                                      scrollDirection: Axis.horizontal,
                                      children: screenings.map<Widget>((e) {
                                        return Padding(
                                          padding: const EdgeInsets.all(8.0),
                                          child: ElevatedButton(
                                              style: ElevatedButton.styleFrom(
                                                  textStyle: const TextStyle(
                                                      fontSize: 20)),
                                              onPressed: () {
                                                setState(() {
                                                  selectedScreening = e;
                                                });
                                                widget.onSelectScreening(e);
                                              },
                                              child: Text(e.time.hour
                                                      .toString() +
                                                  ':' +
                                                  e.time.minute.toString())),
                                        );
                                      }).toList()),
                                );
                              }
                              return CircularProgressIndicator();
                            },
                          )),
                    ),
                    // To Seat Select
                    SizedBox(
                      child: ElevatedButton(
                          style: ElevatedButton.styleFrom(
                              fixedSize: Size(widget.maxWidth * 0.8,
                                  widget.maxHeight * 0.06)),
                          onPressed: () {
                            setState(() {
                              showSeatPicker = true;
                            });
                          },
                          child: Text("Submit")),
                    )
                  ],
                )
              : SeatsPicker(
                  isOcuppiedSeats: widget.isOcuppiedSeats,
                  auditorium: widget.auditorium,
                  maxHeight: widget.maxHeight,
                  maxWidth: widget.maxWidth,
                  controller: widget.bookingPageAnimationController,
                  mainImg: widget.mainImg,
                  onSelectSeats: widget.onSelectSeats,
                ),
        ));
      },
    );
  }
}
