# 플러터 순한맛 강좌
## What is the flutter?
+ Flutter는 프레임워크
+ Fuchsia의 사용자 인터페이스와 애플리케이션을 만들기 위해 사용
+ Flutter 앱 개발을 위한 프로그래밍 언어로는 Dart를 사용
+ 크로스 플랫폼(안드로이드, IOS) 애플리케이션 개발
+ 인터페이스나 사용자 경험을 하나로 통일
+ Hummingbird : Flutter 웹 프로젝트  
<br>  

## flutter 실행 환경 점검
명령 프롬프트에서 flutter docter를 입력하여 실행 환경이 제대로 구성되어 있는지 확인  
<br>

## flutter upgrade 수정 사항
static 위젯 앞에 const 키워드를 사용하지 않는 경우 노란색 밑줄 발생  
해당 강의는 이전 버전이기 때문에 const 키워드를 사용하지 않았지만, 밑줄이 거슬리는 경우 pubspec.yaml 파일 수정으로 처리 가능 → flutter_lints 주석 처리 후 Pub get 클릭  
<br> 

## Flutter 상에서의 위젯이란?
### 기본적인 Widget의 정의
1. 독립적으로 실행되는 작은 프로그램
2. 주로 바탕화면 증에서 날씨나 뉴스, 생활정보 등을 보여줌 
3. 그래픽이나 데이터 요소를 처리하는 함수를 가지고 있음  
<br> 

### Flutter에서의 Widget
1. UI를 만들고 구성하는 모든 기본 단위 요소  
   텍스트, 버튼, 이미지 등 웹 화면을 구성하는 모든 요소
2. UI 디자인과 관련해서 레이아웃을 돕는 눈에 보이지 않는 요소들도 위젯이라고 함  
   요소들을 정 중앙에 배치시키기 위한 center 등
3. 플러터에서는 모든 것이 위젯
<br>

## Types of Widgets 
1. Stateless widgets  
   Stateless : 이전 상호 작용의 어떠한 값도 저장하지 않음  
   상태가 없는 정적인 위젯 (움직임이나 변화가 전혀 없음)
    1. 스크린 상에 존재만 할 뿐 아무것도 하지 않음
    2. 어떠한 실시간 데이터도 저장하지 않음
    3. 어떤 변화(모양, 상태)를 유발시키는 value 값을 가지지 않음
2. Stateful widgets  
   Stateful : 입력되는 value 값에 의한 상호작용의 상태를 지속적으로 추적, 보존  
   계속 움직임이나 변화가 있는 동적인 위젯 
    1. 사용자의 interaction에 따라서 모양이 바뀜 (ex. 체크박스, 라디오 버튼)
    2. 데이터를 받게 된 경우에도 모양이 바뀜
3. Inherited Widget
<br>

## Widget tree
1. flutter에서는 Widget들이 계층 구조로 나열되는데, 이 widget들은 tree 구조로 정리될 수 있음
2. 한 widget 내에 얼마든지 다른 widget들이 포함될 수 있음
3. widget은 부모 위젯과 자식 위젯으로 구성
4. parent widget을 widget container라고 부르기도 함
<br>

### widget tree 구조
1. MyApp : 앱의 루트 위젯이자 시작점  
   꼭 이름이 MyApp일 필요는 없음  
   일종의 커스텀 위젯
2. MaterialApp : MyApp에서 빌드되는 위젯  
   전체 앱을 감싸고 있는 위젯  
   플러터 sdk에서 제공하는 위젯이라고 이름붙여진 모든 것을 사용할 수 있게 됨
3. MyHomePage : 커스텀 위젯이며, 이름이 반드시 MyHomePage일 필요는 없음  
   여기부터 앱의 디자인과 기능이 만들어짐
4. Scaffold : 아주 중요한 위젯  
   앱 화면과 기능을 구성하기 위한 빈 페이지를 준비해 줌  
   이 아래로 UI와 관련된 모든 앱의 구성 요소들이 사용됨  
5. AppBar : 앱 화면의 가장 상단에 위치
6. Text : AppBar의 구성 요소
7. Center : 요소를 중앙으로 위치시킴  
   눈에 보이지는 않음
8. Column : 요소들을 세로로 위치시키기 위한 위젯
9. Image, TextField, Button  
<br>

## Flutter 프로젝트 폴더의 구성
+ pubspec.yaml 파일 : 프로젝트의 메타 데이터를 정의하고 관리 (프로젝트 버전, 사용 환경 등), 들여쓰기에 민감함
+ android/ios 폴더 : 각 플랫폼에 맞게 앱을 배포하기 위한 정보를 가지고 있음
+ test 폴더 : dart 관련 코드를 테스트 가능
+ lib 폴더 : 앱 작업의 중심이 되는 폴더  
<br>

## Class and Widget
+ Class : 객체의 속성과 기능에 대한 정의가 들어가 있음 (설계도)  
  객체가 가져야 하는 속성과 기능을 정의한 내용을 담고 잇는 설계도 역할  
+ 인스턴스 : 설계도에 의해 만들어진 것, 같은 설계도에 의해 만들어졌기 때문에 동일하나, 시리얼 넘버 등으로 구별됨  
  클래스를 기반으로 클래스의 속성과 기능을 똑같이 가진 상태로 생성된 프로그래밍 상에서 사용되는 대상
+ 객체 : 메모리로 할당되어진 순간의 클래스  
  클래스가 정의된 후 메모리 상에서 할당되었을 때 이를 객체라고 함  
<br>

### DardPad를 이용한 Dart 코드 학습
class 생성
``` dart
class Person{
  String? name; // 초기화를 필수로 진행해야 하며, 하지 않는 경우 ? 붙여 줘야 함
  int? age;
  String? gender;
}
```
※ 변수 값을 할당하는 경우 dart가 알아서 변수 타입을 추론하는 기능을 가지고 있기 때문에 var 타입 사용 가능 (ex. var name = 'John')  
<br>

인스턴스 생성
``` dart
void main(){
  
  Person p1 = new Person();
  p1.age = 30; // 값 대입
  
  print(p1.age); // 출력
}
```
<br>

### 생성자
클래스를 만들 때 생성자를 따로 생성하지 않으면 기본 생성자가 만들어짐  
생성자는 함수와 동일한 형태로 생성  
생성자는 인스턴스를 생성함과 동시에 클래스에서 정의한 변수 값을 할당받도록 강제해서 원하는 값을 가진 인스턴스를 착오 없이 만들게 함  

함수 생성  
``` dart
addNumber(int num1, int num2){ // 타입 추론 가능
  return num1 + num2;
}

int addNumber(int num1, int num2){
  return num1 + num2;
}
```
타입 추론은 가능하나, 작성해 주는 것이 오류 식별에 좋음  

생성자 생성
``` dart
class Person{
  String? name;
  int? age;
  String? gender;
  
  Person(String name, int age, String gender){
    this.name = name;
    this.age = age;
    this.gender = gender;
  }
}
```
위 생성자는 argument가 몇 개이든 그 순서에 맞게 모든 값을 입력해야 하고, 필요한 argument만 따로 골라 입력받을 수 없음  
→ 이를 해결하기 위해 만들어진 것 : named argument  
<br>

``` dart
class Person{
  String? name; 
  int? age;
  String? gender;
  
  Person({String? name, int? age, String? gender}){
    this.name = name;
    this.age = age;
    this.gender = gender;
  }
}
```
argument를 중괄호로 묶어 주는 경우 선택하여 입력 가능  
단, 해당 경우에는 null이 들어갈 수 있는 경우에는 타입 뒤에 ?를 작성해 주어야 함  
위와 같이 named argument를 사용하는 경우에는 인스턴스를 생성할 때 아래와 같이 변수명:값 형태로 작성해 주어야 함 (ex. home: 등)  
```dart
Person p1 = new Person(name: 'Tom');
```
※ Dart 2.0 이후에는 인스턴스를 생성하는 경우 new 키워드를 작성하지 않아도 됨  
<br>

## App bar icon button
+ leading : 아이콘 버튼이나 간단한 위젯을 왼쪽에 배치할 때
+ actions : 복수의 아이콘 버튼 등을 오른쪽에 배치할 때
+ onPressed : 반환값이 없는(void) 함수 형태로 일반 버튼이나 아이콘 버튼을 터치했을 때 일어나는 이벤트를 정의  
<br>

## Drawer menu
+ ListView : 여러 줄의 정보를 보여 주는 목록
+ ListTile : 각 리스트 한 줄 한 줄을 의미, 아이콘 배치를 수월하게 해줌  
<br> 

### 위젯 트리
1. Drawer
2. ListView
3. UserAccountDrawerHeader 
4. ListTile : Icon, Text, onTap
   onPressed와 onTap의 차이  
   기능 상은 거의 동일  
   onPressed : 주로 버튼에 사용됨  
   onTap : gestureDetector나 inkWell 등에 주로 사용됨 (길게 누르기, 두 번 탭하기 등 어떤 동작에 반응하는 경우)  
<br>

## BuildContext
### BuildContext의 정의
+ widget tree에서 현재 widget의 위치를 알 수 있는 정보  
  build 함수는 Scaffold Widget을 리턴하는데 이때 위젯트리 상에서 어디에 위치하는가에 대한 정보를 가지고 있는 context를 넣어서 리턴한다는 의미
+ 모든 위젯은 본인만의 BuildContext를 가지고 있고, __이 BuildContext는 stateless 위젯이나 state 빌드 메서드에 의해 리턴된 위젯의 부모가 된다.__  
  Scaffold 위젯은 부모인 Mypage의 context를 그대로 물려받음 따라서 어느 프로젝트에서 Scaffold 위젯의 위치가 궁금하다고 Scaffold 위젯의 context를 참조하면 에러 발생 (Scaffold 위젯의 위치 정보를 가지고 있지 않음)  
  Scaffold 위젯 아래에서 build 메소드로 위젯을 리턴하면 그 위젯은 부모인 Scaffold 위젯의 진짜 context를 물려받을 수 있음  
<br>

### build 메소드
``` dart
class MyPage extends StatelessWidget {
  const MyPage({Key? key}) : super(key: key);
   Widget build(BuildContext context){} // Widget 타입 메소드
}
```
<br>

## Snack bar
### Scaffold.of(context) method 
현재 주어진 context에서 위로 올라가면서 가장 가까운 Scaffold를 찾아서 반환하라  
→ Something.of(context) : 위로 올라가면서 가장 가까운 Something을 찾아서 반환하라  
Scaffold.of(context).showSnackBar()는 deplicated됨 → ScaffoldMessenger.of(context).showSnackBar() 형태로 사용해야 함  
ScaffoldMessenger를 사용하면 Builder를 이용해 새로 만들지 않아도 됨  
<br>

## Container 위젯
child가 없을 경우 컨테이너 안에서 최대의 공간을 차지하려고 함 따라서 아무것도 설정하지 않는 경우 스크린 화면 전체를 차지  
child 위젯을 지정하는 경우 child 위젯 크기로 줄어들게 됨  
컨테이너는 오직 하나만의 child를 가질 수 있음  
<br>

## 레이아웃 관련 사이트
[:link: 레이아웃 관련 사이트](https://medium.com/flutter-community/flutter-layout-cheat-sheet-5363348d037e)  
<br>

## Router
스마트폰에서 보여지는 하나의 페이지를 의미  
반드시 Material 위젯 아래에 child로 생성되어야 함  
<br>

## Navigator
모든 앱페이지를 관리하며, stack이라는 자료구조 형식으로 라우터 객체들을 관리  
push, pop 메소드 제공   
<br>

### stack 자료구조
데이터가 들어오는대로 밑에서부터 하나씩 쌓이는 구조  
push : 데이터를 쌓아올림 (추가)  
pop : 제일 위의 데이터를 없앰 (제거)  
따라서 페이지를 push하면 이전 페이지가 사라지고, 그것을 대체하는 것이 아니라 그 위에 쌓이는 것
