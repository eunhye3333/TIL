import 'package:flutter/material.dart'; // flutter 앱을 만들기 위해서는 꼭 import 해야 하는 라이브러리

// => : 코딩을 더 간결하게 하기 위한 기호로 main 함수가 다른 함수를 호출한다는 뜻
// runApp(app) : flutter의 최상위 함수로 한 번만 호출해 주면 됨
// 이때 runApp() 함수는 위젯 argument를 가져야 함
void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return MaterialApp( // title이라는 문자열을 argument로 가짐
      title: 'First app',
      theme: ThemeData(
        primarySwatch: Colors.blue
        // 앱에서 사용할 기본적인 색상 견본 (해당 색상의 음영 사용한다는 뜻)
      ), // closeing label ->
      home: const MyHomePage(), // 앱을 실행시키면 가장 먼저 볼 페이지
    );
  }
}

// 커스텀 위젯을 만들 때는 항상 stateless 위젯으로 만들지 stateful 위젯으로 만들지 고민 필요
// 모양이 변하는 요소가 하나라도 있다면 stateful 위젯으로 생성해야 함

class MyHomePage extends StatelessWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold( // 다양한 요소드를을 배치하고 그릴 수 있도록 도와주는 위젯
      appBar: AppBar(
        title: const Text('BBANTO'),
        centerTitle: true, // title 중간으로 옮기기
        backgroundColor: Colors.redAccent,
        elevation: 0.0, // AppBar가 떠있는 효과 없애기
        // MaterialApp에서는 Text 위젯을 사용하지 않은 이유 : MaterialApp의 title은 앱을 총칭하는 이름
        //                                               but AppBar 위젯 내의 title은 AppBar에 출력되는 title
      ),
      // body : 앱 화면을 만드는 시작점
      body: Center(
        // Padding(
        // padding: EdgeInsets.fromLTRB(30.0, 40.0, 0.0, 0.0),
        child: Column(
          // mainAxisAlignment: MainAxisAlignment.center, // 위젯을 세로로 상, 중, 하로 정렬하는 경우 사용
          children: [
            Text('Hello'),
            Text('Hello'),
            Text('Hello'),
          ],
        ),
      ),
    );
  }
}

