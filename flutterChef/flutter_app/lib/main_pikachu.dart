import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false, // 상단 띠 없애기
      title: 'BBAMTO',
      home: Grade(),
    );
  }
}

class Grade extends StatelessWidget {
  const Grade({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.amber[800],
      appBar: AppBar(
        title: Text('PIKACHU'),
        backgroundColor: Colors.amber[700],
        centerTitle: true,
        elevation: 0.0,
      ),
      body: Padding(
        padding: EdgeInsets.fromLTRB(30.0, 40.0, 0.0, 0.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start, // 왼쪽 시작점 정렬
          children: [
            Center(
              child: CircleAvatar(
                backgroundImage: AssetImage('assets/eat.gif'),
                radius: 60.0,
              ),
            ),
            Divider(
              height: 60.0, // Divider의 위, 아래 사이의 간격 (위, 아래에서 30씩 떨어졌다는 의미
              color: Colors.grey[850],
              thickness: 0.5,
              endIndent: 30.0, // Divider 선이 끝에서부터 어느 정도 떨어져야 하는지 결정
            ),
            Text('NAME',
              style: TextStyle(
                color: Colors.white,
                letterSpacing: 2.0, // 철자 간의 간격
              ),
            ),
            SizedBox( // 보이지 않는 박스를 이용해 글자 세로 간격 주기
              height: 10.0,
            ),
            Text('PIKACHU',
              style: TextStyle(
                color: Colors.white,
                letterSpacing: 2.0,
                fontSize: 28.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(
              height: 30,
            ),
            Text('PIKACHU POWER LEVEL',
              style: TextStyle(
                color: Colors.white,
                letterSpacing: 2.0, // 철자 간의 간격
              ),
            ),
            SizedBox( // 보이지 않는 박스를 이용해 글자 세로 간격 주기
              height: 10.0,
            ),
            Text('14',
              style: TextStyle(
                color: Colors.white,
                letterSpacing: 2.0,
                fontSize: 28.0,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(
              height: 30.0,
            ),
            Row(
              children: [
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10.0,
                ),
                Text('using light saber',
                style: TextStyle(
                  fontSize: 16.0,
                  letterSpacing: 1.0,
                ),
                ),
              ],
            ),
            Row(
              children: [
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10.0,
                ),
                Text('face hero tattoo',
                  style: TextStyle(
                    fontSize: 16.0,
                    letterSpacing: 1.0,
                  ),
                ),
              ],
            ),
            Row(
              children: [
                Icon(Icons.check_circle_outline),
                SizedBox(
                  width: 10.0,
                ),
                Text('fire flames',
                  style: TextStyle(
                    fontSize: 16.0,
                    letterSpacing: 1.0,
                  ),
                ),
              ],
            ),
            Center(
              child: CircleAvatar(
                backgroundImage: AssetImage('assets/pika.png'),
                radius: 50.0,
                backgroundColor: Colors.amber[800],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
