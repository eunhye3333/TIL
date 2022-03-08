# 개발
## 테스트
### 메모리 DB
테스트를 하는 경우에 독립된 DB를 사용하고 싶은 경우 test 폴더 아래에 resources 디렉토리 생성 후 application.yml 파일 복사하면 해당 파일이 우선권을 가지게 됨  
datasource url에 메모리 모드로 띄우도록 설정하면 됨  
```jdbc:h2:mem:test```  
이렇게 사용하는 경우 h2 db를 내려도 테스트가 동작함 (아무 내용이 없어도 됨)  
**but 스프링부트에서는 아래처럼 설정을 다 없애도 기본적으로 메모리 모드로 돌림**
```yml
spring:
#  datasource:
#    url: jdbc:h2:mem:test
#    username: sa
#    password:
#    driver-class-name: org.h2.Driver
#
#  jpa:
#    hibernate:
#      ddl-auto: create
#    properties:
#      hibernate:
#        show_sql: true
#        format_sql: true

logging:
  level:
    org.hibernate.SQL: debug 
    org.hibernate.type: trace 
```
테스트는 운영과 yml 설정을 다르게 가지고 가야 함  
<br>

## 도메인 모델 패턴
엔티티에 주요 비즈니스 로직을 가지고 객체지향의 특성을 적극적으로 활용하는 것, 서비스 계층은 단순히 엔티티에 필요한 요청을 위임하는 역할  

## 트랜젝션 스크립트 패턴
엔티티에는 비즈니스 로직이 거의 없고 서비스 계층에서 대부분의 비즈니스 로직을 처리하는 것