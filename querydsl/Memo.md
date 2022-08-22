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

<br>

## CountQuery 최적화  

- count 쿼리가 생략 가능한 경우 생략해서 처리
  - 페이지 시작이면서 컨텐츠 사이즈가 페이지 사이즈보다 작을 때
  - 마지막 페이지일 때 (offset + 컨텐츠 사이트를 더해서 전테 사이즈 구함)

<br>

## 스프링 데이터 정렬 (Sort)

스프링 데이터 JPA는 자신의 정렬을 Querydsl의 정렬(OrderSpecifier)로 편리하게 변경하는 기능을 제공한다.
-> 단순한 쿼리의 경우에만 가능

```java
JPAQuery<Member> query = queryFactory.selectFrom(member);

for(Sort.Order o : pageable.getSort()) {
    PathBuilder pathBuilder = new PathBuilder(member.getType(), member.getMetadata());
	query.orderBy(new OrderSpecifier(o.isAscending() ? Order.ASC : Order.DESC, pathBuilder.get(o.getProperty())));
}

List<Member> result = query.fetch();
```

** 정렬은 조건이 조금만 복잡해져도 Pageable의 sort 기능을 사용하지 어려움 루트 엔티티 범위를 넘어가는 동적 정렬 기능이 필요한 경우 스프링 데이터 페이징이 제공하는 Sort를 사용하기 보다는 파라피터를 받아서 직접 처리하는 것을 권장