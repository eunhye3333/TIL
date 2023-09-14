import 'package:flutter/material.dart';
import 'package:flutter_app/ScreenA.dart';
import 'package:flutter_app/ScreenB.dart';
import 'package:flutter_app/ScreenC.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Toast message',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      initialRoute: '/', // 처음 출력될 라우트의 이름은 '/'로 flutter가 지정해 둠
      routes: {
        '/' : (context) => ScreenA(), // 키 값인 /가 불려지면 value인 ScreenA가 불려져야 함
        '/b' : (context) => ScreenB(),
        '/c' : (context) => ScreenC(),
      },
    );
  }
}



