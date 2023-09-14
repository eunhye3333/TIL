package com.study.querydsl.repository;

import static com.study.querydsl.entity.QMember.member;
import static com.study.querydsl.entity.QTeam.team;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.study.querydsl.dto.MemberSearchCondition;
import com.study.querydsl.entity.Member;
import com.study.querydsl.repository.support.Querydsl4RepositorySupport;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class MemberTestRepository extends Querydsl4RepositorySupport {

	public MemberTestRepository() {
		super(Member.class);
	}

	public List<Member> basicSelect() {
		return select(member)
				.from(member)
				.fetch();
	}

	public List<Member> basicSelectFrom() {
		return selectFrom(member)
				.fetch();
	}

	// 이전 버전의 최적화
	public Page<Member> searchPageByApplyPage(MemberSearchCondition condition, Pageable pageable) {
		JPAQuery<Member> query = selectFrom(member)
			.leftJoin(member.team, team)
			.where(usernameEq(condition.getUsername()),
				teamNameEq(condition.getTeamName()),
				ageGoe(condition.getAgeGoe()),
				ageLoe(condition.getAgeLoe())
			);

		List<Member> content = getQuerydsl().applyPagination(pageable, query)
			.fetch();

		return PageableExecutionUtils.getPage(content, pageable, query::fetchCount);
	}

	// 다음 버전의 최적화 (위 코드와 완전히 같은 코드)
	public Page<Member> applyPagination(MemberSearchCondition condition, Pageable pageable) {

		return applyPagination(pageable, query ->
			query.selectFrom(member)
				.leftJoin(member.team, team)
				.where(usernameEq(condition.getUsername()),
					teamNameEq(condition.getTeamName()),
					ageGoe(condition.getAgeGoe()),
					ageLoe(condition.getAgeLoe())
				)
		);
	}

	// count 쿼리 별도로 분리
	public Page<Member> applyPagination2(MemberSearchCondition condition, Pageable pageable) {

		return applyPagination(pageable, contentQuery -> contentQuery
				.selectFrom(member)
				.leftJoin(member.team, team)
				.where(usernameEq(condition.getUsername()),
					teamNameEq(condition.getTeamName()),
					ageGoe(condition.getAgeGoe()),
					ageLoe(condition.getAgeLoe())
				), countQuery -> countQuery
				.select(member.id)
				.from(member)
				.leftJoin(member.team, team)
				.where(usernameEq(condition.getUsername()),
					teamNameEq(condition.getTeamName()),
					ageGoe(condition.getAgeGoe()),
					ageLoe(condition.getAgeLoe())

				)
		);
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