# 스프링부트 개념정리 12강 - 디스패처 서블릿이 무엇인가요?
## FrontController 패턴
JSP/Servlet 매칭 등이 너무 많은 경우 web.xml에 다 정의하기가 힘들기 때문에 최초 앞단에서 request 요청을 받아 필요한 클래스에 넘겨주는 것  
request 요청(요청이 URI 혹은 자바 파일) → 톰켓 (request와 response 객체를 가지고 있음)
request : 나에게 요청이 들어온 모든 데이터를 가진 객체  
response : 응답해야 하는 객체  
특정 주소(.do)가 들어오면 FrontController가 낚아채도록 설정  
.do가 들어오면 request를 한 번 더 해서 자원에 접근 (내부에서는 request가 자원에 접근 가능) → 이때 최초에 요청한 request/response와 달라짐 (요청 시마다 새로 만들어지기 때문)  
기존에 있는 request/response를 유지하여야 함 (정보가 사라지는 것을 방지)

이때 새로운 요청이 생기기 때문에 request와 response가 새롭게 new 될 수 있다  
따라서 RequestDispatcher가 필요함 (정보가 사라지는 것을 방지)

## RequestDispatcher
필요한 클래스의 요청이 도달했을 때 FrontController에 도착한 request와 response를 그대로 유지시켜줌  

## DispatchServlet
스프링에는 DispatchServlet이 있기 때문에 FrontController 패턴을 직접 짜거나 RequestDispatcher를 집접 구현할 필요가 없음  
DispatchServlet = FrontController 패턴 + RequestDispatcher  
DispatchServlet이 자동 생성되어질 때 수많은 객체가 생성됨 (IoC) 이는 보통 필터들이며, 해당 필터들 또는 객체들은 직접 등록할 수도 있고, 자동 등록될 수 있음
