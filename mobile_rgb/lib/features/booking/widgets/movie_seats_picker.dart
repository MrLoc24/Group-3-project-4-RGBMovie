import 'package:flutter/material.dart';
import 'package:movie_app_ui/core/constants/app_colors.dart';
import 'package:movie_app_ui/core/constants/app_text_styles.dart';
import 'package:movie_app_ui/features/biometrics/custom_biometrics_page.dart';
import 'package:movie_app_ui/features/booking/animations/animations.dart';
import 'package:movie_app_ui/features/booking/animations/custom_animated_opacity.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_screen_teather.dart';
import 'package:movie_app_ui/features/booking/widgets/movie_seat_type_legend.dart';

class SeatsPicker extends StatelessWidget {
  const SeatsPicker(
      {Key? key,
      required this.maxHeight,
      required this.maxWidth,
      required this.controller,
      required this.mainImg})
      : super(key: key);

  final double maxHeight;
  final double maxWidth;
  final BookingPageAnimationController controller;
  final String mainImg;
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Stack(
      alignment: Alignment.bottomCenter,
      children: [
        Positioned(
          width: maxWidth,
          height: maxHeight * .9,
          child: Padding(
            padding: const EdgeInsets.symmetric(horizontal: 30),
            child: Column(
              children: [
                // const Spacer(),
                // CustomAnimatedOpacity(
                //   animation: _controller.topOpacityAnimation,
                //   child: SizedBox(
                //     height: h * .075,
                //     child: MovieDates(dates: widget.movie.openingDate),
                //   ),
                // ),
                const Spacer(),
                CustomAnimatedOpacity(
                  animation: controller.topOpacityAnimation,
                  child: SizedBox(
                    height: maxHeight * .2,
                    width: maxWidth,
                    child: MovieTheaterScreen(
                      image: mainImg,
                      maxHeight: maxHeight,
                      maxWidth: maxWidth,
                    ),
                  ),
                ),
                SizedBox(height: maxHeight * 0.01),
                // CustomAnimatedOpacity(
                //   animation: _controller.bottomOpacityAnimation,
                //   child: MovieSeats(seats: widget.movie.seats),
                // ),
                const Spacer(),
                CustomAnimatedOpacity(
                  animation: controller.bottomOpacityAnimation,
                  child: const MovieSeatTypeLegend(),
                ),
                const Spacer(flex: 3),
              ],
            ),
          ),
        ),
        Positioned(
          bottom: 0,
          child: GestureDetector(
            onTap: () {
              const transitionDuration = Duration(milliseconds: 400);

              Navigator.of(context).push(
                PageRouteBuilder(
                  transitionDuration: transitionDuration,
                  reverseTransitionDuration: transitionDuration,
                  pageBuilder: (_, animation, ___) {
                    return FadeTransition(
                      opacity: animation,
                      // child: const BiometricsPage(), Uses Lottie
                      child: const CustomBiometricsPage(),
                    );
                  },
                ),
              );
            },
            child: AnimatedBuilder(
              animation: controller.buttonController,
              builder: (_, child) {
                final size = controller
                    .buttonSizeAnimation(
                      Size(maxWidth * .7, maxHeight * .06),
                      Size(maxWidth * 1.2, maxHeight * 1.1),
                    )
                    .value;
                final margin =
                    controller.buttonMarginAnimation(maxHeight * .03).value;
                return Container(
                  width: size.width,
                  height: size.height,
                  margin: EdgeInsets.only(bottom: margin),
                  decoration: const BoxDecoration(
                    color: AppColors.primaryColor,
                    borderRadius: BorderRadius.all(Radius.circular(20)),
                  ),
                );
              },
            ),
          ),
        ),
        Positioned(
          bottom: maxHeight * .05,
          child: const IgnorePointer(
            child: Text(
              'Buy Ticket',
              style: AppTextStyles.bookButtonTextStyle,
            ),
          ),
        ),
      ],
    );
  }
}
