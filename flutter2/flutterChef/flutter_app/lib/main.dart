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
        title: Text('Buttons'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextButton(
              onPressed: () {
                print('test button');
              },
              onLongPress: () {
                print('text button2');
              },
              child: Text(
                'Text button',
                style: TextStyle(fontSize: 20.0),
              ),
              style: TextButton.styleFrom(
                primary: Colors.red, // 글자 색
                // backgroundColor: Colors.blue
              ),
            ),
            ElevatedButton(
              onPressed: () {
                print('Elevated button');
              },
              child: Text('Elevated button'),
              style: ElevatedButton.styleFrom(
                  primary: Colors.orangeAccent, // 배경 색
                  shape: RoundedRectangleBorder(
                      borderRadius: BorderRadius.circular(10.0)),
                  elevation: 0.0),
            ),
            OutlinedButton(
              onPressed: () {
                print('Outlined Button');
              },
              child: Text('Outlined button'),
              style: OutlinedButton.styleFrom(
                primary: Colors.green,
                side: BorderSide(color: Colors.black87, width: 2.0),
              ),
            ),
            TextButton.icon(
              onPressed: () {
                print('Icon button');
              },
              icon: Icon(
                Icons.home,
                size: 30.0,
                color: Colors.black87,
              ),
              label: Text('Go to home'),
              style: TextButton.styleFrom(
                primary: Colors.purple, // 아이콘에서 색상을 지정하지 않는다면 해당 색상이 아이콘에도 지정됨
                minimumSize: Size(200, 50),
              ),
            ),
            ElevatedButton.icon(
              onPressed: null, // 비활성화된 버튼 만들기
              icon: Icon(
                Icons.home,
                size: 20,
              ),
              label: Text('Go to home'),
              style: ElevatedButton.styleFrom(
                primary: Colors.purple,
                onSurface: Colors.pink // 비활성화된 버튼 색상 변경
              ),
            ),
            ButtonBar( // 버튼을 우측으로 정렬시켜주고, 가로의 공간이 부족하면 자동으로 세로로 배치
              alignment: MainAxisAlignment.center,
              buttonPadding: EdgeInsets.all(20),
              children: [
                TextButton(
                    onPressed:  (){},
                    child: Text("Text Button"),
                ),
                ElevatedButton(
                    onPressed: (){},
                    child: Text("Elevated Button"),
                ),
              ],
            )
          ],
        ),
      ),
    );
  }
}
