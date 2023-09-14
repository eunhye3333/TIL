package com.study.querydsl;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.QueryResults;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.dto.MemberDto;
import com.study.querydsl.dto.QMemberDto;
import com.study.querydsl.dto.UserDto;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.QMember;
import com.study.querydsl.entity.QTeam;
import com.study.querydsl.entity.Team;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.study.querydsl.entity.QMember.member;
import static com.study.querydsl.entity.QTeam.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
public class QuerydslBasicTest {

    @Autowired
    EntityManager em;

    JPAQueryFactory queryFactory; // 필드로 빼도 여러 멀티 스레드에서 들어와도 동시성 문제가 없도록 동작하도록 되어 있음 (필드로 빼서 사용 권장)

    @BeforeEach // 테스트 실행 전에 데이터 미리 세팅
    public void before() {
        queryFactory = new JPAQueryFactory(em);

        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);

        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);

        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);
    }

    @Test
    public void startJPQL() {
        // JPQL로 먼저 작성

        // member1을 찾아라
        String qlString =
            "select m from Member m " +
                "where m.username = :username";
        Member findMember = em.createQuery(qlString, Member.class)
            .setParameter("username", "member1")
            .getSingleResult();

        assertThat(findMember.getUsername()).isEqualTo("member1");
        // 오류 발생 시점 : 사용자가 실행해서 해당 메소드를 호출했을 떄 (런타임 오류)
    }

    @Test
    public void startQuerydsl() {
//        JPAQueryFactory queryFactory = new JPAQueryFactory(em); // 필드로 뺄 수 있음
        // 작성 전 Q 파일을 미리 만들어야 함 (other -> compileQuerydsl)

        // Q 클래스 인스턴스 사용 방법
        // 1. 별칭 직접 지정
//        QMember m = new QMember("m"); // 어떤 QMember인지 구분하는 이름을 줌
        //                        "m" : 별칭

        // 2. 기본 인스턴스 사용
//        QMember m = QMember.member;
//
//        Member findMember = queryFactory
//                .select(m)
//                .from(m)
//                .where(m.username.eq("member1")) // 자동 파라미터 바인딩 방식 사용
//                .fetchOne();

        // static import 사용하여 코드 줄이기
        Member findMember = queryFactory
            .select(member)
            .from(member)
            .where(member.username.eq("member1")) // 자동 파라미터 바인딩 방식 사용
            .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");
        // 오류 발생 시점 : 컴파일 시점 (오류를 더 쉽게 찾을 수 있음)
        // querydsl은 jpql 빌더 역할을 함 따라서 querydsl로 작성한 코드는 jpql 쿼리가 돼서 나감

        // QMember를 만들 때 "member1"로 만들어서 alias가 member1로 나가는데 바꾸고 싶은 경우 QMember m = new QMember("m");처럼 별칭을 지정하면 됨
        // -> 같은 테이블 조인 시 사용
    }

    // 검색 조건 쿼리
    @Test
    public void search() {
        Member findMember = queryFactory
            .selectFrom(member) // select와 from을 합칠 수도 있음
            .where(member.username.eq("member1")
                .and(member.age.eq(10))) // username이 member1이고 age가 10인 사람 조회 (or도 가능)
            .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");

    }

    @Test
    public void searchAndParam() {
        Member findMember = queryFactory
            .selectFrom(member)
            .where(
//                member.username.eq("member1").and(member.age.eq(10))
                member.username.eq("member1"), (member.age.eq(10))
                // and인 경우 쉼표로 이어도 괜찮음 (파라미터를 여러 개 넘기는 경우 다 and로 조립)
                // 이 방법을 사용하는 경우 null이 들어가면 null 값을 무시함
            )
            .fetchOne();

        assertThat(findMember.getUsername()).isEqualTo("member1");

    }

    @Test
    public void resultFetch() {
        // member 목록을 리스트로 조회
        List<Member> fetch = queryFactory
            .selectFrom(member)
            .fetch();

        // 단건 조회
        Member fetchOne = queryFactory
            .selectFrom(QMember.member)
            .fetchOne();

        Member fetchFirst = queryFactory
            .selectFrom(QMember.member)
            .fetchFirst();

        // 페이징용 쿼리 편하게 사용 가능
        QueryResults<Member> results = queryFactory
            .selectFrom(member)
            .fetchResults();

        results.getTotal(); // total과 페이징 정보 제공
        List<Member> content = results.getResults(); // 이렇게 꺼내야 데이터가 나옴

        // select 쿼리를 count 쿼리로 변경
        long total = queryFactory
            .selectFrom(member)
            .fetchCount();
    }

    /**
     * 회원 정렬 순서 1. 회원 나이 내림차순 (desc) 2. 회원 이름 오름차순 (asc) 단 2에서 회원 이름이 없으면 마지막에 출력 (nulls last)
     */
    @Test
    public void sort() {
        em.persist(new Member(null, 100));
        em.persist(new Member("member5", 100));
        em.persist(new Member("member6", 100));

        List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.eq(100))
            .orderBy(member.age.desc(), member.username.asc().nullsLast()) // nullsFirst도 있음
            .fetch();

        Member member5 = result.get(0);
        Member member6 = result.get(1);
        Member memberNull = result.get(2);

        assertThat(member5.getUsername()).isEqualTo("member5");
        assertThat(member6.getUsername()).isEqualTo("member6");
        assertThat(memberNull.getUsername()).isNull();
    }

    @Test
    public void paging1() {
        List<Member> result = queryFactory
            .selectFrom(member)
            .orderBy(member.username.desc())
            .offset(1) // 앞에 몇 개를 스킵할 것인지
            .limit(2) // 몇개를 가져올 것인지
            .fetch();

        assertThat(result.size()).isEqualTo(2);
    }

    // 전체 조회수가 필요한 경우
    @Test
    public void paging2() {
        QueryResults<Member> queryResults = queryFactory
            .selectFrom(member)
            .orderBy(member.username.desc())
            .offset(1)
            .limit(2)
            .fetchResults();

        assertThat(queryResults.getTotal()).isEqualTo(4);
        assertThat(queryResults.getLimit()).isEqualTo(2);
        assertThat(queryResults.getOffset()).isEqualTo(1);
        assertThat(queryResults.getResults().size()).isEqualTo(2);
    }

    @Test
    public void aggregation() {
        List<Tuple> result = queryFactory
            .select(
                member.count(),
                member.age.sum(),
                member.age.avg(),
                member.age.max(),
                member.age.min()
            )
            .from(member)
            .fetch();

        // Tuple : querydsl이 제공하는 튜플 (여러 개 타입이 있을 때 꺼내올 수 있는 것)
        // 데이터 타입이 여러 개인 경우 튜플 사용 가능

        Tuple tuple = result.get(0);
        assertThat(tuple.get(member.count())).isEqualTo(4);
        assertThat(tuple.get(member.age.sum())).isEqualTo(100);
        assertThat(tuple.get(member.age.avg())).isEqualTo(25);
        assertThat(tuple.get(member.age.max())).isEqualTo(40);
        assertThat(tuple.get(member.age.min())).isEqualTo(10);
    }

    /**
     * 팀의 이름과 각 팀의 평균 연령을 구해라
     */
    @Test
    public void group() throws Exception {
        List<Tuple> result = queryFactory
            .select(team.name, member.age.avg())
            .from(member)
            .join(member.team, team)
            .groupBy(team.name)
            // .having()도 가능
            .fetch();

        Tuple teamA = result.get(0);
        Tuple teamB = result.get(1);

        assertThat(teamA.get(team.name)).isEqualTo("teamA");
        assertThat(teamA.get(member.age.avg())).isEqualTo(15); // (10+20)/2
        assertThat(teamB.get(team.name)).isEqualTo("teamB");
        assertThat(teamB.get(member.age.avg())).isEqualTo(35); // (30+40)/2
    }

    // 조인
    // 기본 조인 : 조인의 기본 문법은 첫 번째 파라미터에 조인 대상을 지정하고 두 번째 파라미터에 별칭으로 사용할 Q타입을 지정하면 됨

    /**
     * 팀 A에 소속된 모든 회원
     */
    @Test
    public void join() {
        List<Member> result = queryFactory
            .selectFrom(member)
            .join(member.team, team) // team -> Qteam.team 의미
            // leftJoin, rightJoin 가능
            .where(team.name.eq("teamA"))
            .fetch();

        assertThat(result)
            .extracting("username")
            .containsExactly("member1", "member2");
    }

    /**
     * 세타 조인 (sql에서는 cross join) 회원의 이름이 팀 이름과 같은 회원을 조회 (연관관계가 없는 join)
     */
    @Test
    public void theta_join() {
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));

        List<Member> result = queryFactory
            .select(member)
            .from(member, team) // from에 두 개를 그냥 나열
            .where(member.username.eq(team.name))
            .fetch();

        // 모든 회원과 모든 팀을 가져온 후 join -> where에서 필터링
        assertThat(result)
            .extracting("username")
            .containsExactly("teamA", "teamB");

        // 단, 세타 조인을 사용하는 경우(inner join) 외부 조인 불가능 (outer join) -> on을 사용하면 외부 조인 가능
    }

    // 조인 - on절
    // on절을 활용한 조인은 JPA 21.부터 지원
    // on절을 활용할 수 있는 방법
    // 하이버네이트 5.1부터 on을 사용해 서로 관계가 없는 필드로 외부 조인하는 기능이 추가됨

    // 1. 조인 대상 필터링

    /**
     * 예) 회원과 팀을 조인하면서 팀 이름이 teamA인 팀만 조인, 회원은 모두 조회 JPQL : select m, t from Member m left join
     * m.team t on t.name = 'teamA'
     */
    @Test
    public void join_on_filtering() {
        List<Tuple> result = queryFactory
            .select(member, team)
            .from(member)
            .leftJoin(member.team, team).on(team.name.eq("teamA")) // teamB인 경우 null로 가져옴
            // 일반 join으로 바꾸면 teamA의 멤버만 출력됨
            .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }

        // on절을 횔용해 조인 대상을 필터링할 때 외부 조인이 아니라 내부 조인을 사용하면 where절에서 필터링하는 것과 기능이 동일함
        // join(member.team, team)
        //  .on(team.name.eq("teamA")) == .where(team.name.eq("teamA"))
        // 따라서 on절을 활용한 조인 대상 필터링을 사용할 때 내부 조인인 경우 where절을 사용하고 외부 조인이 필요한 경우에만 해당 기능 사용할 것것    }
    }

    // 2. 연관관계 없는 엔티티 외부 조인

    /**
     * 회원의 이름이 팀 이름과 같은 대상 외부 조인
     */
    @Test
    public void join_on_no_relation() {
        em.persist(new Member("teamA"));
        em.persist(new Member("teamB"));
        em.persist(new Member("teamC"));

        List<Tuple> result = queryFactory
            .select(member, team)
            .from(member)
            .leftJoin(team).on(member.username.eq(team.name))
            // (member.team, team) 이런 방식으로 적으면 id와 매칭돼서 join이 되는데 안 적는 경우 on에서 필터링 됨
            .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);

//            tuple = [Member(id=3, username=member1, age=10), null]
//            tuple = [Member(id=4, username=member2, age=20), null]
//            tuple = [Member(id=5, username=member3, age=30), null]
//            tuple = [Member(id=6, username=member4, age=40), null]
//            tuple = [Member(id=7, username=teamA, age=0), Team(id=1, name=teamA)]
//            tuple = [Member(id=8, username=teamB, age=0), Team(id=2, name=teamB)]
//            tuple = [Member(id=9, username=teamC, age=0), null]
            // member 이름과 팀이름이 같은 경우에만 팀을 가져오고 나머지는 null
        }
    }

    // 조인 - 페치 조인
    // 페치 조인은 SQL에서 제공하는 기능은 아님 SQL 조인을 활용해 연관된 엔티티를 SQL 한 번에 조회하는 기능으로 주로 성능 최적화 시 사용

    @PersistenceUnit
    EntityManagerFactory emf;

    @Test
    public void fetchJoinNo() {
        em.flush();
        em.clear();
        // 날린 다음에 실행해야 정확하게 볼 수 있음

        Member findMember = queryFactory
            .selectFrom(member)
            .where(member.username.eq("member1"))
            .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil()
            .isLoaded(findMember.getTeam());// 로딩된 엔티티인지 초기화가 안 된 엔티티인지 알려주는 것
        assertThat(loaded).as("패치 조인 미적용").isFalse();
    }

    @Test
    public void fetchJoinUse() {
        em.flush();
        em.clear();

        Member findMember = queryFactory
            .selectFrom(member)
            .join(member.team, team).fetchJoin()
            .where(member.username.eq("member1"))
            .fetchOne();

        boolean loaded = emf.getPersistenceUnitUtil().isLoaded(findMember.getTeam());
        assertThat(loaded).as("패치 조인 적용").isTrue();
    }

    // 서브 쿼리 : com.querydsl.jpa.JPAExpressions 사용

    /**
     * 나이가 가장 많은 회원 조회
     */
    @Test
    public void subQuery() {
        QMember memberSub = new QMember("memberSub");// alias가 겹치면 안되기 때문에 새로 만들어줌

        List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.eq(
                JPAExpressions
                    .select(memberSub.age.max())
                    .from(memberSub)
            ))
            .fetch();

        assertThat(result).extracting("age")
            .containsExactly(40);
    }

    /**
     * 나이가 평균 이상인 회원 조회
     */
    @Test
    public void subQueryGoe() {
        QMember memberSub = new QMember("memberSub");

        List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.goe(
                JPAExpressions
                    .select(memberSub.age.avg())
                    .from(memberSub)
            ))
            .fetch();

        assertThat(result).extracting("age")
            .containsExactly(30, 40);
    }

    @Test
    public void subQueryIn() {
        QMember memberSub = new QMember("memberSub");

        List<Member> result = queryFactory
            .selectFrom(member)
            .where(member.age.in(
                JPAExpressions
                    .select(memberSub.age)
                    .from(memberSub)
                    .where(memberSub.age.gt(10))
            ))
            .fetch();

        assertThat(result).extracting("age")
            .containsExactly(20, 30, 40);
    }

    @Test
    public void selectSubquery() {
        QMember memberSub = new QMember("memberSub");

        List<Tuple> result = queryFactory
            .select(member.username,
                JPAExpressions // static import 가능
                    .select(memberSub.age.avg())
                    .from(memberSub)
            )
            .from(member)
            .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    // from 절의 서브쿼리 한계 -> JPA JPQL의 서브쿼리는 from 절의 서브쿼리를 지원하지 않음 따라서 Querydsl도 지원하지 않음
    //  ** 원래 JPA 표준 스펙에서는 select 절의 서브쿼리도 지원하지 않으나 하이버네이트 구현체를 사용하면 select 절의 서브쿼리는 지원함
    // from 절의 서브쿼리 해결 방안
    // 1. 서브쿼리를 join으로 변경 (불가능할 수도 있음)
    // 2. 애플리케이션에서 쿼리를 2번 분리해서 실행
    // 3. nativeSQL 사용

    // Case문
    // 간단한 조건
    @Test
    public void basicCase() {
        List<String> result = queryFactory
            .select(member.age
                .when(10).then("열살")
                .when(20).then("스무살")
                .otherwise("기타"))
            .from(member)
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    // 복잡한 조건
    @Test
    public void complexCase() {
        List<String> result = queryFactory
            .select(new CaseBuilder()
                .when(member.age.between(0, 20)).then("0~20살")
                .when(member.age.between(21, 30)).then("21~30살")
                .otherwise("기타")
            )
            .from(member)
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    // 상수, 문자 더라기
    @Test
    public void constant() {
        List<Tuple> result = queryFactory
            .select(member.username, Expressions.constant("A"))
            .from(member)
            .fetch();

        for (Tuple tuple : result) {
            System.out.println("tuple = " + tuple);
        }
    }

    @Test
    public void concat() {
        // {username}_{age}
        List<String> result = queryFactory
            .select(member.username.concat("_")
                .concat(member.age.stringValue())) // age는 문자가 아니기 때문에 문자로 바꿔줘야 함
            .from(member)
            .where(member.username.eq("member1"))
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
        // stringValue는 enum을 처리하는 경우에도 자주 사용
    }

    // 프로젝션과 결과 반환 - 기본
    // 프로젝션 : select 절에 뭘 가져올지 대상을 지정하는 것
    // 프로젝션 대상이 하나 : 타입을 명확하게 지정하면 됨
    // 프로젝션 대상이 둘 이상 : 튜플이나 DTO로 조회

    @Test
    public void simpleProjection() {
        // 프로젝션 대상이 하나
        List<String> result = queryFactory
            .select(member.username)
            .from(member)
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void tupleProjection() {
        List<Tuple> result = queryFactory
            .select(member.username, member.age)
            .from(member)
            .fetch();

        for (Tuple tuple : result) {
            String username = tuple.get(member.username);
            Integer age = tuple.get(member.age);

            System.out.println("username = " + username);
            System.out.println("age = " + age);
        }

        // com.querydsl.core.Tuple이기 때문에 리파지토리 계층 안에서만 사용하는 것 권장 (Service 등 밖으로 던질 때는 DTO로 변경하는 것 권장)
    }

    @Test
    public void findDtoByJPQL() {
        List<MemberDto> result = em.createQuery(
                "select new com.study.querydsl.dto.MemberDto(m.username, m.age) from Member m",
                MemberDto.class) // new 오퍼레이션을 사용한 방법
            .getResultList();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }

        // 순수 JPA에서 DTO를 조회할 때는 new 명령어를 사용해야 함
        // DTO의 package 이름을 다 적어 줘야 하기 때문에 지저분함
        // 생성자 방식만 지원함 (setter, 필드 주입 등 불가능)
    }

    @Test
    public void findDtoBySetter() {
        List<MemberDto> result = queryFactory
            .select(Projections.bean(MemberDto.class,
                member.username,
                member.age))
            .from(member)
            .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoByField() {
        List<MemberDto> result = queryFactory
            .select(Projections.fields(MemberDto.class, // getter, setter 없어도 됨 필드에 바로 값을 넣는 것
                member.username,
                member.age))
            .from(member)
            .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findDtoByConstructor() {
        List<MemberDto> result = queryFactory
            .select(Projections.constructor(MemberDto.class, // 생성자 타입과 맞춰서 작성해야 함
                member.username,
                member.age))
            .from(member)
            .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }
    }

    @Test
    public void findUserDto() {
        QMember memberSub = new QMember("memberSub");

        List<UserDto> result = queryFactory
            .select(Projections.fields(UserDto.class,
//                    member.username, // 필드명이 달라서 매칭이 안 됨 -> null로 들어감
                member.username.as("name"), // 필드명과 동일하게 설정

                // ExpressionUtils로 감싸면 두 번째 파라미터로 alias 줄 수 있음
                ExpressionUtils.as(JPAExpressions
                    .select(memberSub.age.max())
                    .from(memberSub), "age")
//                    member.age
            ))
            .from(member)
            .fetch();

        for (UserDto userDto : result) {
            System.out.println("userDto = " + userDto);
        }

        // 프로퍼티나 필드 접근 생성 방식에서 이름이 다를 때 해결 방안
        // 1. ExpressionUtils.as(source, alias) : 필드나 서브쿼리에 별칭 적용
        // 2. username.as("memberName") : 필드에 별칭 적용
    }

    @Test
    public void findDtoByQueryProjection() {
        List<MemberDto> result = queryFactory
            .select(new QMemberDto(member.username,
                member.age)) // 생성자를 가져가기 때문에 타입을 다 맞춰줌 -> 컴파일 시점에 타입이 안 맞으면 오류 발생
            .from(member)
            .fetch();

        for (MemberDto memberDto : result) {
            System.out.println("memberDto = " + memberDto);
        }

        // 생성자 방식의 경우 매개변수가 잘못됐을 때 컴파일 시점이 아니라 런타입 시점에 오류 발생
        // QueryProjection 방식의 경우 컴파일 시점에 오류 발생
        // 단점 : DTO들이 querydsl에 의존적이게 됨 (DTO는 여러 레이어에 걸쳐서 설계가 되는데 DTO가 순수하지 않음)
        //       -> 아키텍처적으로 애매함

        // distinct는 JPQL의 distinct와 같다다
    }

    // 동적 쿼리 해결 방법
    // 1. BooleanBuilder
    @Test
    public void dynamicQuery_BooleanBuilder(){
        String usernameParam = "member1";
        Integer ageParam = null;

        List<Member> result = searchMember1(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember1(String usernameCond, Integer ageCond) {
        BooleanBuilder builder = new BooleanBuilder();
//        BooleanBuilder builder = new BooleanBuilder(member.username.eq(usernameCond)); // 초기값 세팅 가능

        if(usernameCond != null) {
            builder.and(member.username.eq(usernameCond));
        }

        if(ageCond != null) {
            builder.and(member.age.eq(ageCond));
        }

        return queryFactory
                .selectFrom(member)
                .where(builder)
                .fetch();
    }

    // 2. Where 다중 파라미터 사용
    @Test
    public void dynamicQuery_WhereParam(){
        String usernameParam = "member1";
        Integer ageParam = null;

        List<Member> result = searchMember2(usernameParam, ageParam);
        assertThat(result.size()).isEqualTo(1);
    }

    private List<Member> searchMember2(String usernameCond, Integer ageCond) {
        return queryFactory
                .selectFrom(member)
                .where(usernameEq(usernameCond), ageEq(ageCond)) // where에 null이 들어가면 무시가 됨
//                .where(allEq(usernameCond, ageCond))
                .fetch();
    }

    private BooleanExpression usernameEq(String usernameCond) {
        return usernameCond != null ?  member.username.eq(usernameCond) : null;
    }

    private BooleanExpression ageEq(Integer ageCond) {
        return ageCond != null ? member.age.eq(ageCond) : null;
    }

    // 광고 상태 isValid, 광고 날짜가 IN (조건이 여러개) -> 조립을 하면 isServiceable 생성해서 사용 가능 (재활용 가능, 직관적)

    private Predicate allEq(String usernameCond, Integer ageCond) {
        return usernameEq(usernameCond).and(ageEq(ageCond)); // 조립해서 사용 가능
    }

    @Test
    @Commit
    public void bulkUpdate(){

        // member1 = 10 -> DB member1
        // member2 = 20 -> DB member2
        // member3 = 30 -> DB member3
        // member4 = 40 -> DB member4

        // count : 영향을 받은 row의 수
        long count = queryFactory
            .update(member)
            .set(member.username, "비회원")
            .where(member.age.lt(28))
            .execute();

        // member1 = 10 -> DB 비회원
        // member2 = 20 -> DB 비회원
        // member3 = 30 -> DB member3
        // member4 = 40 -> DB member4

        // bulk 연산에서 주의해야 하는 점 -> member1~4가 영속성 컨텍스트에 들어있음
        // 벌크 연산은 영속성 컨텍스트를 무시하고 DB에 쿼리가 바로 나가게 됨 -> DB의 상태가 영속성 컨텍스트의 상태가 달라짐
        // 따라서 아래와 같이 select로 가져오면 DB에서 가져옴 -> 영속성 컨텍스트에 있음 -> DB에 가져온 것을 버리고 영속성 컨텍스트에 있는 것을 선택 (유지)
        //  => DB와 다른 값 출력

        List<Member> result = queryFactory
                .selectFrom(member)
                .fetch();

        for (Member member1 : result) {
            System.out.println("member1 = " + member1);
        }

        // 영속성 컨텍스트와 맞추기 위한 초기화
        em.flush();
        em.clear();

        List<Member> result2 = queryFactory
            .selectFrom(member)
            .fetch();

        for (Member member1 : result2) {
            System.out.println("member1 = " + member1);
        }
    }

    @Test
    public void bulkAdd(){
        long count = queryFactory
            .update(member)
            .set(member.age, member.age.add(1))
            // -가 없어서 빼고 싶으면 .set(member.age, member.age.add(-1))
            // multiply() 곱하기
            .execute();
    }

    @Test
    public void bulkDelete(){
        long count = queryFactory
            .delete(member)
            .where(member.age.gt(18))
            .execute();
    }

    // SQL function 호출하기
    // SQL function은 JPA와 같이 Dialect에 등록된 함수만 호출 가능
    // 등록되어 있지 않고 DB에 있는 커스텀 함수를 사용하고 싶은 경우에는 Dialect를 상속받아서 클래스를 만든 후 application.yml에 별도의 설정 필요
    @Test
    public void sqlFunction() {
        List<String> result = queryFactory
            .select(
                Expressions.stringTemplate("function('replace', {0}, {1}, {2})", member.username,
                    "member", "M")
            )
            .from(member)
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void sqlFunction2() {
        List<String> result = queryFactory
            .select(member.username)
            .from(member)
            .where(member.username.eq(
//                Expressions.stringTemplate("function('lower', {0})", member.username)
            // 모든 DB에 내장된 간단한 함수들은 querydsl에도 내장되어 있음 따라서 아래와 같이 바꿀 수 있음
                member.username.lower()
                ))
            .fetch();

        for (String s : result) {
            System.out.println("s = " + s);
        }
    }

}
