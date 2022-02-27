# 프로젝트 환경 설정
## gradle
gradle은 기본적으로 의존 관계에 있는 모든 라이브러리를 가지고 옴 따라서 다운로드된 라이브러리가 많을 수 있음  
<br>

## Lombok 설정
+ 플러그인 설치   
  setting → plugins 검색  
   ![image](https://user-images.githubusercontent.com/77559262/155716946-f3db9ac0-9efc-4954-81eb-fafc568ee0cb.png)
+ Enable annotation procession 체크  
  setting → annotation 검색  
  ![image](https://user-images.githubusercontent.com/77559262/155717194-a98fc738-b944-42ec-9d35-ed05cf874eca.png)
@Getter, @Setter 어노테이션 이용 후 데이터를 담아 출력해보면 제대로 출력되는 것 확인 가능  
<br>  

## 라이브러리
스프링부트는 라이브러리를 다운로드하면 그에 의존하는 라이브러리를 다 다운로드함
+ spring-boot-starter-web : 안에 tomcat이 있는 것 확인 가능, webmvc에 의존하고 있음
+ spring-boot-starter-thymeleaf : thymeleaf와 관련된 라이브러리 세팅되어 있음
+ spring-boot-starter-data-jpa : 데이터베이스 커넥션 등을 가져다 쓸 수 있게 해 주는 라이브러리들 존재  
  HikariCP : 스프링부트 기본 커넥션 풀  
  로깅 라이브러리도 존재  

### 핵심 라이브러리
+ 스프링 MVC
+ 스프링 ORM
+ JPA, 하이버네이트
+ 스프링데이터 JPA

### 기타 라이브러리
+ H2 데이터에비스 클라이언트
+ 커넥션 풀 : HikariCP
+ WEB(thymeleaf)
+ 로깅 SLF4J & LogBack
+ 테스트