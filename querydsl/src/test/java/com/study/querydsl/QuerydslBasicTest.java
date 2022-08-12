package com.study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.QMember;
import com.study.querydsl.entity.Team;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static com.study.querydsl.entity.QMember.member;
import static org.assertj.core.api.Assertions.*;

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
}

