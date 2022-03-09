# 플러터 조금 매운맛 강좌
## Stateless Widget / Stateful Widget
### State
State : UI가 변경되도록 영향을 미치는 데이터  
→ App 수준의 데이터와 Widget 수준의 데이터가 있다 (앱의 상태를 바꾸는 모든 행위)  
<br>

### Stateless Widget
State가 변하지 않는 위젯 (객체화된 데이터들이 변하지 않음)  
따라서 rebuild를 해야만 새로운 State 적용 가능   
 
Hot reload : 바뀐 부분을 플러터에서 바로 적용시켜 보여주는 것, 이때 모든 부분을 다 바꾸는 것이 아니라 Element tree를 이용해 변경된 부분만을 다시 그리는 방법을 사용하기 때문에 빠르고 효율적임

Element tree, Render tree : 플러터가 내부적으로 Control, Widget에 근거하여 생성됨  
Widget tree는 설계도의 역할로 개발자가 직접 코드를 작성하여 생성함  
+ Element tree : Widget tree와 Render tree 연결, Widget tree의 모든 위젯 하나하나가 맞대응되어 있음, Render tree가 실제로 랜더링하기 위한 객체와도 맞대응하고 있음  
+ Render tree : 직접적으로 스크린에 그림을 그려줌, 스크린 상의 모든 부분은 Render tree의 랜더링 결과임  

### Reload vs Rebuild
Reload : 어떤 프레임은 그대로 둔 채 부수적인 요소들만 바꾸는 것  
Rebuild : 모든 것을 바꾸는 것 (새로 만드는 것)  
<br>

### Stateful Widget
내부에 State라는 생성자를 가지고 있음 이 생성자가 build 메소드를 가짐  
→ Stateful Widget의 rebuild를 초래하는 것은 State 클래스  
Stateful Widget이 rebuild되는 경우  
+ Child 위젯의 생성자를 통해서 데이터가 전달될 때
+ Internal state가 바뀔 때

## const 변수 / final 변수
### const
const : 컴파일 시에 상수화, 컴파일 시에 상수화가 되면 런타임 시에도 값이 변하지 않음

### final
초기화 방법
1. 변수 선언 시 초기화
2. 객체 생성 시에 외부 데이터를 받아 생성자를 통해 초기화  
final : run-time constant (런타임 시에 상수화), final 변수는 rebuild 될 수 있음
<br>

## Focus
+ FocusNode : 포커스를 받는 특정 위젯을 식별
+ FocusScope : 어떤 위젯들까지 포커스를 받는지 범위를 나타냄