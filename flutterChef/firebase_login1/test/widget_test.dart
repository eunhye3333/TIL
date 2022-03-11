import 'dart:io'; // socket이나 http 서버와 통신할 때 필요한 라이브러리

void main(){
  showData();
}

// void showData(){
  // 위에서 아래로 코드 수행
  // startTask();
  // accessData();
  // fetchData();
  
  // Duration 추가 후 accessData가 3초 후에 실행됨 (시간이 걸리든 안 걸리든 순차적으로 실행)
  // startTask();
  // accessData();
  // fetchData();

  // accessData 리턴값 전달
//   startTask();
//   String account = accessData();
//   fetchData(account); // 리턴값을 전달받아야 하는데 지연되는 상황이기 때문에 정상적으로 전달받지 못함
// }

void showData() async{
  startTask();
  String account = await accessData();
  fetchData(account);
}

void startTask(){
  String info1 = '요청 수행 시작';
  print(info1);
}

// void accessData(){
//   String info2 = '데이터에 접속 중';
//   print(info2);
// }

// void accessData(){
//   Duration time = Duration(seconds: 3);
//   sleep(time);
//   String info2 = '데이터에 접속 중';
//   print(info2);
// }

// void accessData(){
//   Duration time = Duration(seconds: 3);
//
//   if(time.inSeconds > 2){ // delay 시간이 2초보다 크면
//     // sleep(time);
//
//     Future.delayed(time, (){ // 3초 동안 실행이 중단되고 아래로 실행이 내려감
//       String info2 = '데이터에 처리 완료';
//       print(info2);
//     });
//
//   } else{
//     String info2 = '데이터를 가져왔습니다';
//     print(info2);
//   }
// }

// accessData 함수에서 전달받은 통장 잔액을 fetchData에서 출력 : 지연 때문에 정상적으로 출력되지 않음
// String accessData(){
//
//   String account = '';
//
//   Duration time = Duration(seconds: 3);
//
//   if(time.inSeconds > 2){ // delay 시간이 2초보다 크면
//     // sleep(time);
//
//     Future.delayed(time, (){ // 3초 동안 실행이 중단되고 아래로 실행이 내려감
//       account = '8,500만원';
//       print(account);
//     });
//
//   } else{
//     String info2 = '데이터를 가져왔습니다';
//     print(info2);
//   }
//
//   return account;
// }

// 순서를 정해주기 위해 수정
Future<String> accessData() async{ // async 제어자가 추가되면 await 사용 가능

  String account = '';

  Duration time = Duration(seconds: 3);

  if(time.inSeconds > 2){ // delay 시간이 2초보다 크면
    // sleep(time);

    await Future.delayed(time, (){ // Future.delayed의 실행이 끝날 때까지 기다려라
      account = '8,500만원';
      print(account);
    });

  } else{
    String info2 = '데이터를 가져왔습니다';
    print(info2);
  }

  return account;
}

// void fetchData(){
//   String info3 = '잔액은 8,500만원입니다';
//   print(info3);
// }

void fetchData(String account){
  String info3 = '잔액은 $account입니다';
  print(info3);
}