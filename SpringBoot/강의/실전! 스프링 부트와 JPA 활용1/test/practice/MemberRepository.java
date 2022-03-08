package jpabook.jpashop.practice;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em; // 스프링부트에서는 EntityManager 자동으로 등록됨

    public Long save(MemberTest member){
        em.persist(member);
        return member.getId(); // 커맨드랑 쿼리를 분리하기 위해 id만 리턴
    }

    public MemberTest find(Long id){
        return em.find(MemberTest.class, id);
    }


}
