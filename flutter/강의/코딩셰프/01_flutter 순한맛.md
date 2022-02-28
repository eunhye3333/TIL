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
+ pubspec.yaml 파일 : 프로젝트의 메타 데이터를 정의하고 관리 (프로젝트 버전, 사용 환경 등)
+ android/ios 폴더 : 각 플랫폼에 맞게 앱을 배포하기 위한 정보를 가지고 있음
+ test 폴더 : dart 관련 코드를 테스트 가능
+ lib 폴더 : 앱 작업의 중심이 되는 폴더