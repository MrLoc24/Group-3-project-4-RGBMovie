import 'package:flutter/material.dart';
import 'package:movie_app_ui/features/booking/widgets/show_dates_list.dart';
import 'package:movie_app_ui/features/booking/widgets/show_times_list.dart';
import 'package:movie_app_ui/models/theater_model.dart';

class ShowingTimesPicker extends StatefulWidget {
  const ShowingTimesPicker({
    super.key,
    required this.onSelectLocation,
    required this.theaterList,
  });

  final Function(dynamic value) onSelectLocation;
  final Future<List<String>> theaterList;

  @override
  State<ShowingTimesPicker> createState() => _ShowingTimesPickerState();
}

class _ShowingTimesPickerState extends State<ShowingTimesPicker> {
  final TextEditingController iconController = TextEditingController();
  String? selectedLocation;

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      body: SafeArea(
          child: Column(
        children: <Widget>[
          Padding(
              padding: const EdgeInsets.symmetric(vertical: 20),
              child: FutureBuilder<List<String>>(
                  future: widget.theaterList,
                  builder: (BuildContext context,
                      AsyncSnapshot<List<String>> snapshot) {
                    if (snapshot.hasData) {
                      return Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            const SizedBox(width: 24),
                            DropdownMenu<String>(
                                initialSelection: snapshot.data!.first,
                                controller: iconController,
                                enableFilter: true,
                                requestFocusOnTap: true,
                                label: const Text('Theater'),
                                inputDecorationTheme:
                                    const InputDecorationTheme(
                                  filled: true,
                                  contentPadding:
                                      EdgeInsets.symmetric(vertical: 5.0),
                                ),
                                onSelected: (String? value) {
                                  setState(() {
                                    selectedLocation = value;
                                  });
                                  widget.onSelectLocation(value);
                                },
                                dropdownMenuEntries: snapshot.data!
                                    .map<DropdownMenuEntry<String>>(
                                  (String value) {
                                    return DropdownMenuEntry<String>(
                                      value: value,
                                      label: value,
                                    );
                                  },
                                ).toList())
                          ]);
                    } else if (snapshot.hasError) {
                      return Text('Error: ${snapshot.error}');
                    }
                    return CircularProgressIndicator();
                  }))
        ],
      )),
    );
  }
}
