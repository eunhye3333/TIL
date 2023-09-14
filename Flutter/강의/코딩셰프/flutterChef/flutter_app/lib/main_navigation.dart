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
      home: FirstPage(),
    );
  }
}

class FirstPage extends StatelessWidget { // 하나의 앱 페이지
  const FirstPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context2) {
    return Scaffold(
      appBar: AppBar(
        title: Text('First page'),
      ),
      body: Center(
        child: ElevatedButton(
          child: Text('Go to the Second page'),
          onPressed: (){
            Navigator.push(context2, MaterialPageRoute( // context: FirstPage의 위치를 알아야 그 위에 라우트를 쌓아 올릴 수 있기 때문에 context가 필요함
                // 라우터가 호출되는 위치에 따라 잘못된 context를 사용하여 에러를 발생시킬 수 있기 때문에 builder를 사용해서 에러 발생 가능성을 없앰
                // builder : 어떤 위젯이 MaterialPageRoute의 도움을 받아 생성되어야 할지를 정의

                // builder: (BuildContext context){
                //   return SecondPage();
                // }

                // 아래와 같이 작성 가능
                builder: (_) => SecondPage())); // 매개변수가 _ : 사용하지 않는 값, 꼭 _를 사용할 필요는 없으나 권장 사항
                // SecondPage 위젯은 자체 컨텍스트를 가지고 있고 builder에 해당 컨텍스트를 가지고 있기 때문에 매개변수가 없어도 됨
          },
        ),
      ),
    );
  }
}

class SecondPage extends StatelessWidget { // 두 번째 route
  const SecondPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext ctx) {
    return Scaffold( // Scaffold를 사용해서 AppBar를 생성하면 자동으로 뒤로 가기 버튼을 만들어 줌 따라서 pop 메소드가 없어도 됨
      appBar: AppBar(
        title: Text('Second page'),
      ),
      body: Center(
        child: ElevatedButton(
          child: Text('Go to the First page'),
          onPressed: (){
            Navigator.pop(ctx); // 자신이 사라져야 하기 때문에 자신의 정보를 가지고 있는 context 전달
          },
        ),
      ),
    );
  }
}

