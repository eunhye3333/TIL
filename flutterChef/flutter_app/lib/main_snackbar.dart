import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Appbar',
      theme: ThemeData(
        primarySwatch: Colors.red,
      ),
      home: MyPage(),
    );
  }
}

class MyPage extends StatelessWidget {
  const MyPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: Text('Snack Bar'),
          centerTitle: true,
        ),
        body: Builder(builder: (BuildContext ctx) {
          return Center(
          // child: TextButton(
          //   child: Text(
          //     'Show me',
          //     style: TextStyle(
          //       color: Colors.white,
          //     ),
          //   ),
          //   style: ButtonStyle(
          //     textStyle: MaterialStateProperty.all(TextStyle(fontSize: 14)),
          //     foregroundColor: MaterialStateProperty.all(Colors.red),
          //   ),
          //   onPressed: () {
          //     ScaffoldMessenger.of(context).showSnackBar(SnackBar(
          //       content: Text('Hello'),
          //     ));
          //   },
          // ),
            child: TextButton(
              onPressed: () {
                Scaffold.of(ctx).showSnackBar(SnackBar(
                  content: Text('Hello'),
                ));
              },
              style: ButtonStyle(
                textStyle: MaterialStateProperty.all(TextStyle(fontSize: 14)),
                foregroundColor: MaterialStateProperty.all(Colors.white),
                backgroundColor: MaterialStateProperty.all(Colors.red),
              ),
              child: Text("Show me"),
            ),
          );
        },)
    );
  }
}

