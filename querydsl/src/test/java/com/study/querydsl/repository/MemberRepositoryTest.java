package com.study.querydsl.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.study.querydsl.dto.MemberSearchCondition;
import com.study.querydsl.dto.MemberTeamDto;
import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.QMember;
import com.study.querydsl.entity.Team;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MemberRepositoryTest {
	@Autowired
	EntityManager em;

	@Autowired MemberRepository memberRepository;

	@Test
	public void basicTest() {
		Member member = new Member("member1", 10);
		memberRepository.save(member);

		Member findMember = memberRepository.findById(member.getId()).get();

		assertThat(findMember).isEqualTo(member);

		List<Member> result1 = memberRepository.findAll();
		assertThat(result1).containsExactly(member);

		List<Member> result2 = memberRepository.findByUsername("member1");
		assertThat(result2).containsExactly(member);
	}

	@Test
	public void searchTest(){
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

		MemberSearchCondition condition = new MemberSearchCondition();
		condition.setAgeGoe(35);
		condition.setAgeLoe(40);
		condition.setTeamName("teamB");

		List<MemberTeamDto> result = memberRepository.search(condition);

		assertThat(result).extracting("username").containsExactly("member4");
	}

	@Test
	public void searchPageSimpleTest(){
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

		MemberSearchCondition condition = new MemberSearchCondition();
		PageRequest pageRequest = PageRequest.of(0, 3);

		Page<MemberTeamDto> result = memberRepository.searchPageSimple(condition, pageRequest);

		assertThat(result.getSize()).isEqualTo(3);
		assertThat(result.getContent()).extracting("username").containsExactly("member1", "member2", "member3");
	}

	@Test
	public void querydslPredicateExecutorTest(){
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

		Iterable<Member> result = memberRepository.findAll(
			QMember.member.age.between(10, 40)
				.and(QMember.member.username.eq("member1"))
		); // queryPredicateExecutor를 사용하여 where 조건을 바로 적을 수 있음

		for (Member findMember : result) {
			System.out.println("member = " + findMember);
		}

		// 한계점
		// 1. 조인 불가능 (묵시적 조인은 가능하지만 left join 불가능)
		// 2. 클라이언트가 Querydsl에 의존해야 함 서비스 클래스가 Querydsl이라는 구현 기술에 의존해야 함
		// 		리파지토리를 만드는 이유는 리파지토리를 만들고 그 하부에 Querydsl 같은 기술을 숨기는 것 하지만 이 경우 서비스나 컨트롤러가 Querydsl에 관여하게 됨(Querydsl 객체를 만들어서 넘겨야 하기 때문에)
		// 3. 복잡한 실무 환경에서 사용하기에는 한계가 명확

		// 참고 : QuerydslPredicateExecutor는 Pagable, Sort를 모두 지원하고 정상 동작함
	}

}