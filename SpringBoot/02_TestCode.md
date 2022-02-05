# Springboot에서의 테스트 코드 작성
## TDD와 단위테스트 
+ TDD(Test Driven Development)  
테스트 주도 개발이라는 뜻으로, 테스트케이스를 작성한 후 실제 코드를 개발하고 리팩토링하는 절차를 말함  
애자일 방법론 중 하나인 XP의 Test-First 개념에 기반을 둔 단순한 설계를 중요시 함  
재설계 시간이 줄어들고 코드가 간결해지는 장점이 있음
<br>  

![image](https://user-images.githubusercontent.com/77559262/152457128-0611315d-9ba0-42ff-9e22-8f028a705a63.png)

+ 단위 테스트  
순수하게 테스트 코드만을 작성하는 것  
개발 초기에 문제를 발견 가능하기 때문에 빠른 피드백을 가능하게 함  
단위 테스트 자체를 문서로 사용 가능

## TestCode 작성
1. src/test/java 디렉토리에 테스트할 클래스의 패키지와 동일한 패키지 생성
2. 테스트 클래스 생성 (클래스 이름에 Test를 붙여 생성)
3. 테스트 코드 작성  
    __@RunWith(SpringRunner.class)__ : 테스트를 진행할 때 JUnit에 내장된 실행자 외에 () 내부의 실행자를 실행시키는 역할 (스프링 부트 테스트와 JUnit 사이의 연결자 역할)  
    __@WebMvcTest__ : 스프링 테스트 어노테이션 중 Web에 집중할 수 있는 어노테이션, 선언할 경우 @Controller, @ControllerAdvice 등을 사용 가능 (단, @Service, @Component, @Repository 등은 사용 불가능)  
    __private MockMvc mvc__ : 웹 API를 테스트할 때 사용하는 변수로 스프링 MVC 테스으틔 시작점, MockMvc 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트 가능  
    __mvc.perform(get("/hello"))__ : MockMvc를 통해 /hello라는 주소로 HTTP GET 요청을 하는 것으로 체이닝이 지원됨  
    __.andExpect(status().isOK())__ : mvc.perform의 결과를 검증, HTTP Header의 Status(200, 404, 500 등의 상태)를 검증하는 것인데, 여기서는 OK이므로 200인지 아닌지 검증  
    __.andExpect(content().string(hello))__ : 응답 본문의 내용을 검증하는 것으로 hello가 맞게 리턴되고 있는지 검증

