import 'package:flutter/material.dart';
import 'package:flutter_secure_storage/flutter_secure_storage.dart';
import 'package:movie_app_ui/api/user_api.dart';
import 'package:movie_app_ui/features/auth/edit_page.dart';
import 'package:movie_app_ui/features/auth/login_page.dart';

import './widgets/widgets.dart';

class MoviesPage extends StatefulWidget {
  const MoviesPage({Key? key}) : super(key: key);

  @override
  State<MoviesPage> createState() => _MoviesPageState();
}

class _MoviesPageState extends State<MoviesPage>
    with SingleTickerProviderStateMixin {
  final storage = const FlutterSecureStorage();
  String? username;

  @override
  void initState() {
    super.initState();
    getUsername();
  }

  void getUsername() async {
    String? storedUsername = await storage.read(key: 'username');
    setState(() {
      username = storedUsername;
    });
  }

  // late final TabController _tabController;

  // @override
  // void initState() {
  //   _tabController = TabController(length: 3, vsync: this);
  //   super.initState();
  // }

  // @override
  // void dispose() {
  //   _tabController.dispose();
  //   super.dispose();
  // }

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 1,
      initialIndex: 0,
      animationDuration: const Duration(milliseconds: 250),
      child: Scaffold(
        appBar: AppBar(
          actions: <Widget>[
            if (username != null)
              Builder(
                builder: (context) => IconButton(
                  icon: Icon(Icons.menu),
                  onPressed: () {
                    Scaffold.of(context).openEndDrawer();
                  },
                ),
              )
            else
              IconButton(
                icon: Icon(Icons.account_circle_rounded),
                onPressed: () {
                  Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => const LoginPage()),
                  );
                },
              ),
          ],
          bottom: const TabBar(
            // controller: _tabController,
            isScrollable: true,
            indicator: DotIndicator(),
            tabs: [
              Tab(text: 'Movie'),
            ],
          ),
        ),
        endDrawer: Drawer(
          child: ListView(
            padding: EdgeInsets.zero,
            children: <Widget>[
              DrawerHeader(
                decoration: const BoxDecoration(
                  color: Colors.blue,
                ),
                child: Text('Hello, $username'),
              ),
              ListTile(
                title: const Text('Profile'),
                onTap: () {
                  Navigator.push(
                      context,
                      MaterialPageRoute(
                          builder: (context) => EditPage(username: username!)));
                },
              ),
              ListTile(
                title: const Text('Change Password'),
                onTap: () {
                  // Navigate to change password
                },
              ),
              ListTile(
                title: const Text('Order History'),
                onTap: () {
                  // Navigate to order history
                },
              ),
              ListTile(
                title: const Text('Logout'),
                onTap: () {
                  UserApi().logout();
                  Navigator.of(context).pop();
                  setState(() {
                    username = null;
                  });
                },
              ),
            ],
          ),
        ),
        body: const TabBarView(
          // controller: _tabController,
          physics: NeverScrollableScrollPhysics(),
          children: [
            MoviesView(),
          ],
        ),
      ),
    );
  }
}
