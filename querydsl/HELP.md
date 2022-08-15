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

