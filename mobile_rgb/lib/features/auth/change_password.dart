import 'package:flutter/material.dart';
import 'package:movie_app_ui/api/user_api.dart';
import 'package:movie_app_ui/core/constants/app_colors.dart';
import 'package:movie_app_ui/features/auth/helper/app_constants.dart';
import 'package:movie_app_ui/features/auth/helper/extensions.dart';
import 'package:movie_app_ui/features/auth/widgets/form_input.dart';

class ChangePassword extends StatefulWidget {
  const ChangePassword({super.key});

  @override
  State<ChangePassword> createState() => _ChangePasswordState();
}

class _ChangePasswordState extends State<ChangePassword> {
  final _formKey = GlobalKey<FormState>();

  TextEditingController passwordController = TextEditingController();
  TextEditingController newPasswordController = TextEditingController();
  TextEditingController confirmPasswordController = TextEditingController();

  // FocusNode confirmFocusNode = FocusNode();

  bool isObscure = true;
  bool isConfirmPasswordObscure = true;

  @override
  Widget build(BuildContext context) {
    final size = context.mediaQuerySize;
    return Scaffold(
      body: Form(
        key: _formKey,
        child: ListView(
          children: [
            Container(
              height: size.height * 0.24,
              width: double.infinity,
              padding: const EdgeInsets.all(20),
              decoration: const BoxDecoration(
                gradient: LinearGradient(
                  colors: [
                    AppColors.lightBlue,
                    AppColors.blue,
                    AppColors.darkBlue,
                  ],
                ),
              ),
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceBetween,
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Padding(
                    padding: const EdgeInsets.only(
                      top: 15,
                    ),
                    child: IconButton(
                      onPressed: () => Navigator.pop(context),
                      icon: const Icon(
                        Icons.arrow_back_ios,
                        color: Colors.white,
                      ),
                    ),
                  ),
                  Column(
                    children: [
                      Text(
                        'Register',
                        style: Theme.of(context).textTheme.titleLarge,
                      ),
                      const SizedBox(
                        height: 6,
                      ),
                      Text(
                        'Create your account',
                        style: Theme.of(context).textTheme.bodySmall,
                      ),
                    ],
                  ),
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(
                horizontal: 20,
                vertical: 30,
              ),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.end,
                children: [
                  AppTextFormField(
                    labelText: 'Password',
                    keyboardType: TextInputType.visiblePassword,
                    textInputAction: TextInputAction.next,
                    onChanged: (_) => _formKey.currentState?.validate(),
                    validator: (value) {
                      return value!.isEmpty
                          ? 'Please, Enter Password'
                          : value.length >= 6
                              ? null
                              : 'Invalid Password';
                    },
                    controller: passwordController,
                  ),
                  AppTextFormField(
                    labelText: 'New Password',
                    keyboardType: TextInputType.visiblePassword,
                    textInputAction: TextInputAction.done,
                    // focusNode: confirmFocusNode,
                    onChanged: (value) {
                      _formKey.currentState?.validate();
                    },
                    validator: (value) {
                      return value!.isEmpty
                          ? 'Please, Re-Enter Password'
                          : passwordController.text !=
                                  newPasswordController.text
                              ? null
                              : 'New password can not be same as the current one';
                    },
                    controller: newPasswordController,
                  ),
                  AppTextFormField(
                    labelText: 'Confirm Password',
                    keyboardType: TextInputType.visiblePassword,
                    textInputAction: TextInputAction.done,
                    // focusNode: confirmFocusNode,
                    onChanged: (value) {
                      _formKey.currentState?.validate();
                    },
                    validator: (value) {
                      return value!.isEmpty
                          ? 'Please, Re-Enter Password'
                          : newPasswordController.text ==
                                  confirmPasswordController.text
                              ? null
                              : 'Password not matched!';
                    },
                    controller: confirmPasswordController,
                  ),
                  FilledButton(
                    onPressed: _formKey.currentState?.validate() ?? true
                        ? () async {
                            final data = <String, String>{
                              "password": passwordController.text,
                              "newPassword": newPasswordController.text
                            };
                            String result =
                                await UserApi().changePassword(data);
                            if (result == "Password changed") {
                              showDialog(
                                context: context,
                                builder: (BuildContext context) {
                                  return AlertDialog(
                                    title: const Text('Login'),
                                    content: Text(result),
                                    actions: <Widget>[
                                      TextButton(
                                        onPressed: () {
                                          UserApi().logout();
                                          Navigator.of(context).pop();
                                          setState(() {});
                                        },
                                        child: const Text('OK'),
                                      ),
                                    ],
                                  );
                                },
                              );
                            } else {
                              showDialog(
                                context: context,
                                builder: (BuildContext context) {
                                  return AlertDialog(
                                    title: const Text("Error"),
                                    content: Text(result),
                                    actions: <Widget>[
                                      TextButton(
                                        onPressed: () =>
                                            Navigator.pop(context, 'OK'),
                                        child: const Text('OK'),
                                      ),
                                    ],
                                  );
                                },
                              );
                            }
                            passwordController.clear();
                            newPasswordController.clear();
                            confirmPasswordController.clear();
                          }
                        : null,
                    style: const ButtonStyle().copyWith(
                      backgroundColor: MaterialStateProperty.all(
                        _formKey.currentState?.validate() ?? true
                            ? null
                            : Colors.grey.shade300,
                      ),
                    ),
                    child: const Text('Register'),
                  ),
                ],
              ),
            ),
            Padding(
              padding: const EdgeInsets.symmetric(vertical: 10, horizontal: 25),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Text(
                    'I have an account?',
                    style: Theme.of(context)
                        .textTheme
                        .bodySmall
                        ?.copyWith(color: Colors.black),
                  ),
                  TextButton(
                    onPressed: () {
                      Navigator.pop(context);
                    },
                    style: Theme.of(context).textButtonTheme.style,
                    child: Text(
                      'Login',
                      style: Theme.of(context).textTheme.bodySmall?.copyWith(
                            color: AppColors.primaryColor,
                            fontWeight: FontWeight.bold,
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
