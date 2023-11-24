import 'package:flutter/material.dart';
import 'package:movie_app_ui/models/auditorium_model.dart';
import 'package:movie_app_ui/models/seat_model.dart';

import './movie_seat_box.dart';
import '../../../core/data/models/movies.dart';

class MovieSeatGenerate extends StatefulWidget {
  const MovieSeatGenerate(
      {Key? key,
      required this.auditorium,
      required this.isOcuppiedSeats,
      required this.onSelectSeats})
      : super(key: key);

  final AuditoriumModel? auditorium;
  final List<String> isOcuppiedSeats;
  final Function(String value) onSelectSeats;

  @override
  State<MovieSeatGenerate> createState() => _MovieSeatGenerateState();
}

class _MovieSeatGenerateState extends State<MovieSeatGenerate> {
  List<List<bool>> seats = [];
  int numOfRows = 0;
  int numOfSeatsInRow = 0;

  @override
  void initState() {
    numOfRows = widget.auditorium!.row;
    numOfSeatsInRow = widget.auditorium!.column;
    super.initState();
    for (int i = 0; i < numOfRows; i++) {
      seats.add(List.generate(numOfSeatsInRow, (index) => false));
    }
  }

  void toggleSeat(int row, int seat) {
    setState(() {
      seats[row][seat] = !seats[row][seat];
    });
  }

  @override
  Widget build(BuildContext context) {
    return SingleChildScrollView(
      scrollDirection: Axis.horizontal,
      physics: AlwaysScrollableScrollPhysics(),
      child: Container(
        width: MediaQuery.of(context).size.width,
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Expanded(
              // or Flexible(fit: FlexFit.tight, child: ...
              child: Column(
                mainAxisSize: MainAxisSize.min,
                children: [
                  for (int i = 0; i < numOfRows; i++)
                    Expanded(
                      // or Flexible(fit: FlexFit.tight, child: ...
                      child: SingleChildScrollView(
                        scrollDirection: Axis.vertical,
                        child: SizedBox(
                          width: 100,
                          height: 100,
                          child: ListView.builder(
                            shrinkWrap: true,
                            physics: NeverScrollableScrollPhysics(),
                            itemCount: numOfSeatsInRow,
                            itemExtent: 40,
                            itemBuilder: (BuildContext context, int index) {
                              return InkWell(
                                onTap: () => toggleSeat(i, index),
                                child: Container(
                                  width: 40,
                                  margin: EdgeInsets.all(2),
                                  color: seats[i][index]
                                      ? Colors.red
                                      : Colors.green,
                                  child: Center(
                                      child: Text(
                                          i.toString() + index.toString())),
                                ),
                              );
                            },
                          ),
                        ),
                      ),
                    ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
