package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext // 스프링이 자동 주입해줌
//    @Autowired // 스프링 데이터 JPA @Autowired를 제공하기 때문에 @PersistenceContext 대신 사용 가능
    // 결론 : 따라서 final로 설정 후 @RequiredArgsConstructor 사용 가능
//    private EntityManager em;

    private final EntityManager em;

//    public MemberRepository(EntityManager em) { // 생성자 인젝션 가능
//        this.em = em;
//    }

    // Factory를 주입하고 싶은 경우 아래처럼 작성
//    @PersistenceUnit
//    private EntityManagerFactory emf;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id); // 단건 조회 find(타입, PK)
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class) // jpql (sql과 차이점 : 엔티티 객체(Member)에 대한 쿼리를 작성)
                .getResultList(); // 조회된 결과 반환
    }

    public List<Member> findByName(String name){ // 특정 이름에 대한 부분만 찾기
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name) // 파라미터 바인딩
                .getResultList();
    }
}
