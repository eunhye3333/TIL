# Bean Factory
## Handler Mapping
요청 주소에 따른 적절한 컨트롤로 요청하면 Handler Mapping이 찾아줌  
ex. 해당 주소에 GET 요청이 오면 적절한 컨트롤러의 메소드를 차아서 실행함

## 응답
html 파일을 응답할지 Data를 응답할지 결정해야 하는데 html 파일을 응답하게 되면 ViewResolver가 관여하게 됨  
→ prefix, surfix를 붙여 응답의 pattern을 만들어 줌 (ViewResolver가 관여하지 않게 자체적으로 위치를 지정해 줘도 됨)  

하지만 Data를 응답하게 되면 MessageConverter가 작동하게 되는데 메시지를 컨버팅할 때 기본 전략은 json  
객체를 리턴하는 경우 타입을 알 수 없으므로 json으로 변경해 주는 역할을 하는 것이 MessageConverter
