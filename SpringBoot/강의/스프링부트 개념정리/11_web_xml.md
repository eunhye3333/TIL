# 스프링부트 개념정리 11강 - 웹 배포서술자(web.xml)에 대해서 알려줘요!
## web.xml의 역할
+ ServletContext의 초기 파라미터 설정  
 초기 파라미터 : 한 번 설정하면 어디에서든 동작 가능
+ Session의 유효시간 설정   
  Session : 인증을 통해 들어오는 것, 존재할 수 있는 기간이 정해져 있음 (해당 기간을 늘리기 위해서는 초기화하여야 함)
+ Servlet/JSP에 대한 정의 및 매핑  
  요청한 것이 어디로 가야 하는지 주소를 알려줌 (매핑)  
+ Mime Type 매핑  
  Mime Type : 들고 올 데이터의 타입  
  Mime Type을 알아야 해당 데이터를 매핑, 가공할 수 있음  
  아무것도 안 가지고 오는 경우 : get 방식 (select)  
+ Welcome File list
+ Error Pages 처리
+ 리스너/필터 설정  
  리스너 : 특정 조건만 확인해서 조건이 맞으면 처리함    
  필터 : 걸러 주는 것  
+ 보안

web.xml은 초반에 실행됨

