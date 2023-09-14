package com.study.querydsl.repository;

import static com.study.querydsl.entity.QMember.member;
import static com.study.querydsl.entity.QTeam.team;

import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.study.querydsl.dto.MemberSearchCondition;
import com.study.querydsl.dto.MemberTeamDto;
import com.study.querydsl.dto.QMemberTeamDto;
import com.study.querydsl.entity.Member;
import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

public class MemberRepositoryImpl extends QuerydslRepositorySupport implements MemberRepositoryCustom{ // 이름을 맞추고 + Impl

	/**
	 * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
	 *
	 */
	public MemberRepositoryImpl(EntityManager em) {
		super(Member.class); // 부모가 여러 가지 기능 제공
		// EntityManager, Querydsl 사용 가능
		this.queryFactory = new JPAQueryFactory(em);
	}

	private final JPAQueryFactory queryFactory;

//	public MemberRepositoryImpl(EntityManager em) {
//		this.queryFactory = new JPAQueryFactory(em);
//	}

	@Override
	public List<MemberTeamDto> search(MemberSearchCondition condition) {

		// QuerydslRepositorySupport에서 제공하는 기능
		EntityManager entityManager = getEntityManager(); // entityManager 자동 주입시켜줌

		// from부터 시작
		List<MemberTeamDto> result = from(member)
			.leftJoin(member.team, team)
			.where(
				usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			)
			.select(new QMemberTeamDto(
				member.id.as("memberId"),
				member.username,
				member.age,
				team.id.as("teamId"),
				team.name.as("teamName")
			))
			.fetch();

		return queryFactory
			.select(new QMemberTeamDto(
						member.id.as("memberId"),
						member.username,
						member.age,
						team.id.as("teamId"),
						team.name.as("teamName")
					))
			.from(member)
			.leftJoin(member.team, team)
			.where(
				usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			)
			.fetch();
	}

	@Override
	public Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable) {
		QueryResults<MemberTeamDto> results = queryFactory
												.select(new QMemberTeamDto(
													member.id.as("memberId"),
													member.username,
													member.age,
													team.id.as("teamId"),
													team.name.as("teamName")
												))
												.from(member)
												.leftJoin(member.team, team)
												.where(
													usernameEq(condition.getUsername()),
													teamNameEq(condition.getTeamName()),
													ageGoe(condition.getAgeGoe()),
													ageLoe(condition.getAgeLoe())
												)
												// Order by의 경우 total count 쿼리에는 사용하지 않음
												.offset(pageable.getOffset()) // 몇 번째부터 시작할지
												.limit(pageable.getPageSize()) // 몇 개를 가져올지
												.fetchResults(); // 복잡한 쿼리의 경우 잘 작동하지 않아 별도의 count 쿼리를 만들어서 실행하는 게 좋음 -> 해당 이유로 deprecated됨

		List<MemberTeamDto> content = results.getResults();
		long total = results.getTotal();

		return new PageImpl<>(content, pageable, total); // PageImpl : Page의 구현체
	}

	// QuerydslRepositorySupport에서 제공하는 기능 : 페이징
	public Page<MemberTeamDto> searchPageSimple2(MemberSearchCondition condition, Pageable pageable) {

		JPQLQuery<MemberTeamDto> jpaQuery = from(member)
			.leftJoin(member.team, team)
			.where(
				usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			)
			.select(new QMemberTeamDto(
				member.id.as("memberId"),
				member.username,
				member.age,
				team.id.as("teamId"),
				team.name.as("teamName")
			));

		JPQLQuery<MemberTeamDto> query = getQuerydsl().applyPagination(pageable, jpaQuery);// offset, limit를 자동으로 넣어줌

		QueryResults<MemberTeamDto> results = query.fetchResults();// pagable 적용한 상태로로 fetch됨

		List<MemberTeamDto> content = results.getResults();
		long total = results.getTotal();

		return new PageImpl<>(content, pageable, total);
	}

	// 데이터 내용과 전체 카운트를 별도로 조회하는 방법
	@Override
	public Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable) {
		List<MemberTeamDto> content = queryFactory
										.select(new QMemberTeamDto(
											member.id.as("memberId"),
											member.username,
											member.age,
											team.id.as("teamId"),
											team.name.as("teamName")
										))
										.from(member)
										.leftJoin(member.team, team)
										.where(
											usernameEq(condition.getUsername()),
											teamNameEq(condition.getTeamName()),
											ageGoe(condition.getAgeGoe()),
											ageLoe(condition.getAgeLoe())
										)
										.offset(pageable.getOffset())
										.limit(pageable.getPageSize())
										.fetch(); // ctrl + alt + m을 이용해 메소드로 분리 가능

		// total count용 쿼리 별도로 생성
		// 어떤 상황에는 count를 구할 때 join이 할 필요 없는 경우가 있음 (count 쿼리가 content 쿼리보다 짜기 쉬운 경우 최적화를 위해 분리)
		// count 쿼리를 실행했는데 데이터가 없는 경우 content 쿼리를 실행하지 않도록 최적화 가능능
//		long total = queryFactory
//						.select(member)
//						.from(member)
//						.leftJoin(member.team, team)
//						.where(
//							usernameEq(condition.getUsername()),
//							teamNameEq(condition.getTeamName()),
//							ageGoe(condition.getAgeGoe()),
//							ageLoe(condition.getAgeLoe())
//						)
//						.fetchCount();

		JPAQuery<Member> countQuery = queryFactory
			.select(member)
			.from(member)
			.leftJoin(member.team, team)
			.where(
				usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			);

//		return new PageImpl<>(content, pageable, total);

		// count 쿼리 최적화
//		return PageableExecutionUtils.getPage(content, pageable, () -> countQuery.fetchCount());
		return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchCount); // 같은 표현
		// countQuery.fetchCount()를 하지 않으면 쿼리가 날아가지 않음
		// 따라서 content와 pageable 사이즈를 비교한 후 count 쿼리를 날려야 하는 경우에만 마지막 파라미터로 들어온 함수를 호출함 (count 쿼리를 날림)
	}

	private BooleanExpression usernameEq(String username) {
		return StringUtils.hasText(username) ? member.username.eq(username) : null;
	}

	private BooleanExpression teamNameEq(String teamName) {
		return StringUtils.hasText(teamName) ? team.name.eq(teamName) : null;
	}

	private BooleanExpression ageGoe(Integer ageGoe) {
		return ageGoe != null ? member.age.goe(ageGoe) : null;
	}

	private BooleanExpression ageLoe(Integer ageLoe) {
		return ageLoe != null ? member.age.loe(ageLoe) : null;
	}
}
