# 스프링부트 개념정리 13강 - 애플리케이션 컨텍스트란 무엇인가요?
## 컴포넌트 스캔
request → web.xml → DispatchServlet가 컴포넌트 스캔을 함  
DispatchServlet의 목적 : 주소 분배, 컴포넌트 스캔 

클래스들이 메모리에 떠 있어야 보낼 수 있기 때문에 주소를 분배하기 전에 컴포넌트 스캔을 통해 new를 해서 객체를 생성해 줌   
(이때 해당 객체는 static이면 안 됨, 여러 사람이 사용하기 때문에 static인 경우에는 문제 발생 가능)  

스프링부트에서는 특정 패키지 이하의 모든 작업 파일(소스 파일)을 컴포넌트 스캔을 통해 스캔  
컴포넌트 스캔 후 필요한 파일을 모두 new를 통해 생성  

필요한 파일인지 아닌지는 스프링이 지정해 놓은 annotation을 통해 구분 (@Controller, @Service 등)  
이때 annotation은 커스텀해서 만들 수도 있음  

## ContextLoaderListener
ContextLoaderListener : web.xml에서 DispatchServlet으로 가기 전에 접근하는 부분  
모든 스레드가 공통적으로 관리해야 되는 부분을 읽는 역할 (DB 등)  
root_ApplicationContext 파일을 읽어서 설정함 (xml파일 또는 java 파일로 만들어서 커스텀 가능)  
※ ContextLoaderListener가 먼저 실행되기 때문에 ContextLoaderListener에서는 DispatchServlet이 만든 부분에 접근할 수 없음 (메모리에 아직 없기 때문에)   
   → 하지만 반대는 가능

![image](https://user-images.githubusercontent.com/77559262/154695445-23c6751d-a659-41fd-a2db-67f970da959a.png)

## ApplicationContext
많은 객체들이 ApplicationContext에 등록되기 때문에 필요한 곳에서 ApplicationContext에 접근하여 필요한 객체를 가져올 수 있음  
ApplicationContext는 싱글톤으로 관리되기 때문에 어디에서 접근하든 동일한 객체라는 것을 보장  

ApplicationContext의 종류 : root-applicationContext, servlet-applicationContext  
+ servlet-applicationContext : ViewResolver, Interceptor, MultipartResolver 객체를 생성하고 웹과 관련된 어노테이션 Controller, RestController를 스캔
  해당 파일은 DispatchServlet에 의해 실행됨  
  웹과 관련된 어노레이션만 스캔  
  스캔 : 메모리에 로딩되는 것
+ root-applicationContext : servlet-applicationContext에서 생성되는 어노테이션을 제외한 어노테이션 Service, Repository 등을 스캔하고 DB 관련 객체를 생성  
  해당 파일은 ContextLoaderListener에 의해 실행됨  
  ContextLoaderListener를 실행해 주는 것은 web.xml이기 때문에 servlet-applicationContext보다 먼저 로드됨  
  
## Bean Factory
필요한 객체를 Bean Factory에 등록할 수도 있음 (@Bean)   
이곳에 등록하면 초기에 메모리에 로드되지 않고 필요할 때 getBean()이라는 메소드를 통해 호출하여 메모리에 로드 가능  
미리 로드되지 않고 필요할 때 호출해 메모리에 로드됨 (lazy-loading)  
