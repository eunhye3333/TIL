# Querydsl

## 검색 조건 쿼리

### JPQL이 제공하는 검색 조건

```java
member.username.eq("member1"); // username == 'member1'
member.username.ne("member1"); // username != 'member1'
member.username.eq("member1").not(); // username != 'member1'

member.username.isNotNull(); // username이 null이 아님

member.age.in(10, 20); // age in (10, 20)
member.age.notIn(10, 20); // age not in (10, 20)
member.age.between(10, 30); // age between 10, 30

member.age.goe(30); // age >= 30
member.age.gt(30); // age > 30
member.age.loe(30); // age <= 30
member.age.lt(30); // age < 30

member.username.like("member%"); // like 검색
member.username.contains("member"); // like '%member%' 검색
member.username.startsWith("member"); // like 'member%' 검색
```

<br>



## 결과 조회

- fetch() : 리스트 조회, 데이터가 없으면 빈 리스트 반환
- fetchOne() : 단건 조회
  - 결과가 없으면 null
  - 결과가 둘 이상이면 com.querydsl.core.NotUniqueResultException 발생
- fetchFirst() : limit(1).fetchOne()
- fetchResults() : 페이징 정보 포함, total count 쿼리 추가 실행 (페이징 쿼리 같이 날림)
- fetchCount() : count 쿼리로 변경해서 count 수 조회

<br>



## 사용자 정의 리포지토리

Spring Data JPA에서 내가 원하는 구현 쿼리를 넣으려면 사용자 정의 리포지토리를 사용해야 함



사용자 정의 리포지토리 사용법

1. 사용자 정의 인터페이스 작성
2. 사용자 정의 인터페리스 구현
3. 스프링 데이터 리포지토리에 사용자 정의 인터페이스 상속



** 특화된 로직의 경우 꼭 Custom을 만들지 않아도 됨 (별도 조회용 리포지토리 만드는 것 가능)

