package com.study.querydsl.controller;

import com.study.querydsl.entity.Member;
import com.study.querydsl.entity.Team;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Profile("local")
@Component
@RequiredArgsConstructor
public class InitMember {

	private final InitMemberService initMemberService;

	@PostConstruct // 스프링 라이브사이클이 있어서 @PostConstruct와 @Transactional은 분리해줘야 됨 (같이 못 씀)
	public void init() {
		initMemberService.init();
	}

	@Component
	static class InitMemberService {
		@PersistenceContext
		private EntityManager em;

		@Transactional
		public void init() {
			Team teamA = new Team("teamA");
			Team teamB = new Team("teamB");

			em.persist(teamA);
			em.persist(teamB);

			for(int i = 0; i < 100; i++) {
				Team selectedTeam = i % 2 == 0 ? teamA : teamB;

				em.persist(new Member("member" + i, i + 10, selectedTeam));
			}
		}

	}
}
