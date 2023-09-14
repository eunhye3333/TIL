import 'package:flutter/material.dart';
import 'package:fluttertoast/fluttertoast.dart'; // 토스트 사용을 위한 라이브러리

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
        title: Text('Toast message'),
        centerTitle: true,
      ),
      body: Center(
        child: TextButton(
            onPressed: (){
              flutterToast();
            },
            child: Text('Toast'),
            style: TextButton.styleFrom(backgroundColor: Colors.blue, primary: Colors.black),
        ),
      ),
    );
  }
}

void flutterToast(){
  Fluttertoast.showToast(msg: 'Flutter',
    gravity: ToastGravity.BOTTOM,
    backgroundColor: Colors.redAccent,
    fontSize: 20.0,
    textColor: Colors.white,
    toastLength: Toast.LENGTH_SHORT
  );
}