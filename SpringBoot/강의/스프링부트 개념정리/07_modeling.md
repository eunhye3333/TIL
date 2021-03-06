# 스프링부트 개념정리 7강 - OOP 관점에서 모델링이란 무엇일까요?
## 모델링
엔진이라는 클래스를 자동차 클래스에서 사용하고 싶다면?  
→ 상속으로는 불가능하며,콤포지션(결합)을 사용하여야 함

```
예를 들면 아래와 같이 결합을 진행
Class Car {
  String name;
  String color;
  Engine engine;
}
```

JPA는 클래스를 토대로 테이블을 자동 생성하기 때문에 테이블을 아래와 같이 만들게 됨  
![table](https://user-images.githubusercontent.com/77559262/153848512-718aaef6-207d-47b9-a8ec-1b29cbf3550b.png)  
이때 엔진 클래스에 새로운 필드를 넣고 싶은 경우에는 필드를 새로 추가하지 않고, EntityDate(예시)라는 클래스를 새로 만들고 해당 클래스를 상속하면 됨  
상속을 하게 되면 Car 테이블에 열이 추가됨  

<br>

## 방언 처리 용이
JPA를 이용해서 DB에 접근하는데, 이때 JPA는 MySQL만이 아니라 다양한 방언을 제공함(오라클, 마리아DB, MSSQL 등)  
따라서 이것을 정해서 사용하는 것이 아님  
추상화 객체가 DB에 연결되어 있기 때문에 그때그때 사용할 언어로 변경해 주면 됨  
