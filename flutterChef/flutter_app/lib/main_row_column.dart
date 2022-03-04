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

// class MyPage extends StatelessWidget {
//   const MyPage({Key? key}) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       backgroundColor: Colors.teal,
//       body: SafeArea(
//         child: Center( // Column 위젯이 세로축 방향으로 최대한의 공간을 차지하기 때문에 세로 중앙 정렬에 관여 불가능
//           child: Column( // 세로축 방향으로 최대한의 공간을 차지, 가로축 방향으로는 children의 크기만큼 차지
//             // mainAxisAlignment: MainAxisAlignment.center, // 사용하여야 세로 중앙 정렬 가능
//             mainAxisSize: MainAxisSize.min, // 최소한의 세로축 공간 차지
//             children: [
//               Container(
//                 width: 100,
//                 height: 100,
//                 color: Colors.white,
//                 child: Text('Container 1'),
//               ),
//               Container(
//                 width: 100,
//                 height: 100,
//                 color: Colors.blue,
//                 child: Text('Container 2'),
//               ),
//               Container(
//                 width: 100,
//                 height: 100,
//                 color: Colors.red,
//                 child: Text('Container 3'),
//               )
//             ],
//           ),
//         ),
//       ),
//     );
//   }
// }

// class MyPage extends StatelessWidget {
//   const MyPage({Key? key}) : super(key: key);
//
//   @override
//   Widget build(BuildContext context) {
//     return Scaffold(
//       backgroundColor: Colors.teal,
//       body: SafeArea(
//         child: Column(
//           // verticalDirection: VerticalDirection.up, // 아래부터 1, 2, 3 정렬
//           // verticalDirection: VerticalDirection.down, // 위부터 1, 2, 3 정렬
//           // mainAxisAlignment: MainAxisAlignment.spaceEvenly, // 같은 간격을 두고 정렬
//           // mainAxisAlignment: MainAxisAlignment.spaceBetween, // 정확히 상 중 하에 배치
//           // crossAxisAlignment: CrossAxisAlignment.end, // 똑같은 크기를 가진 컨테이너를 가로로 정렬했기 때문에 변함이 없음
//           // 크기를 변경하면 가로축 끝점 정렬이 된 것이 확인됨
//           crossAxisAlignment: CrossAxisAlignment.stretch, // 가로로 꽉 채우기, 사용할 경우 컨테이너의 가로 크기 속성을 다 지워줘야 함
//           children: [
//             Container(
//               width: 100,
//               height: 100,
//               color: Colors.white,
//               child: Text('Container 1'),
//             ),
//             SizedBox(
//               height: 30.0,
//             ),
//             Container(
//               width: 100,
//               height: 100,
//               color: Colors.blue,
//               child: Text('Container 2'),
//             ),
//             Container(
//               width: 100,
//               height: 100,
//               color: Colors.red,
//               child: Text('Container 3'),
//             ),
//             // Container(
//             //   width: double.infinity, // 가로로 갈 수 있는 끝까지 가라
//             //   height: 20,
//             // ),
//           ],
//         ),
//       ),
//     );
//   }
// }

class MyPage extends StatelessWidget {
  const MyPage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.teal,
      body: SafeArea(
        child: Row( // 가로축 정렬
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            Container(
              width: 100,
              height: 100,
              color: Colors.white,
              child: Text('Container 1'),
            ),
            SizedBox(
              width: 30.0, // 간격 두기
            ),
            Container(
              width: 100,
              height: 100,
              color: Colors.blue,
              child: Text('Container 2'),
            ),
            Container(
              width: 100,
              height: 100,
              color: Colors.red,
              child: Text('Container 3'),
            ),
          ],
        ),
      ),
    );
  }
}

