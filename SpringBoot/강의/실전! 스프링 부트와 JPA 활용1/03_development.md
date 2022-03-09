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
<br>

## 변경 감지와 병합(merge)
### 준영속 엔티티
준영속 엔티티 : 영속성 컨텍스트가 더는 관리하지 않는 엔티티를 말한다. (데이터베이스에 한 번 갔다온 객체로 데이터베이스가 식별할 수 있는 아이디를 가지고 있음)  
new로 생성하더라도(임의로 만들어낸 엔티티라도) 이미 아이디(기존 식별자)를 가지고 있으면 준영속 엔티티로 봄  

준영족 엔티티의 문제 : JPA가 관리하지 않기 때문에 변경 감지가 일어나지 않음 (DB에 업데이트가 일어나지 않음)  

준영속 엔티티를 수정하는 방법 
+ 변경 감지 기능 사용  
  영속성 컨텍스트에서 엔티티를 다시 조회한 후 데이터를 수정
  ```java
    @Transactional
    void update(Item itemParam) { //itemParam: 준영속 상태의 엔티티     
      Item findItem = em.find(Item.class, itemParam.getId()); //같은 엔티티를 조회
      findItem.setPrice(itemParam.getPrice()); //데이터를 수정
    }
  ```
+ 병합(merge) 사용  
  병합 : 준영속 상태의 엔티티를 영속 상태로 변경할 때 사용하는 기능 (필드를 바꿔치기)  
  반환된 객체가 영속성 컨텍스트인 것이고, 기존에 파라미터로 넘어온 객체가 영속성 컨텍스트로 변하는 것은 아님
  ```java
  @Transactional
  void update(Item itemParam) {     
    Item mergeItem = em.merge(item);
  }
  ```
  주의 : 변경 감지 기능을 사용하면 원하는 속성만 선택해서 변경할 수 있지만 병합을 사용하면 모든 속성이 변경됨 따라서 병합 시 값이 없으면 null로 업데이트될 위험성이 있음 (merge보다 변경 감지를 사용하는 것이 좋음)