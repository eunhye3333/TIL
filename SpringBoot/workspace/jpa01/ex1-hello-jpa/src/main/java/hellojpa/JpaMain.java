package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");// 매개변수로 persistenct unit name을 넘김
        // -> 이걸 만드는 순간 데이터베이스와 연결이 됨 (시작 시에 딱 하나만 만들어야 됨, DB당 하나)

        EntityManager em = emf.createEntityManager(); // 하나의 트랜잭션을 진행할 때마다 EntityManager를 생성해야 함, 고객의 요청이 올 때마다 생성, close

        // jpa에서 모든 데이터를 변경하는 작업은 트랜잭션 내에서 처리해 주어야 함
        EntityTransaction tx = em.getTransaction();
        tx.begin(); // 트랜잭션 생성

        try{
            // 데이터 삽입
            // 비영속
            Member member = new Member();

            member.setId(1L);
            member.setName("helloA");
            
            // 영속
            System.out.println("=== BEFORE ===");
            em.persist(member);
            System.out.println("=== AFTER ==="); // 쿼리가 날아가지 않는 것을 확인 가능

            tx.commit();

            // 데이터 수정
            Member findMember = em.find(Member.class, 1L); // 멤버 찾아오기
            System.out.println("findMember.id" + findMember.getId());
            System.out.println("findMember.name" + findMember.getName());

            findMember.setName("HelloJPA"); // em.persist를 하지 않아도 데이터베이스에서 수정됨
            // jpa를 통해 엔티티를 가져오면 해당 엔티티는 jpa가 관리를 함 -> 변경이 됐는지 안 됐는지 트랜잭션 커밋 시점에 다 확인하고 변경되었으면 update 쿼리를 날림

            // 데이터 삭제
            em.remove(member);

            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10) // 페이징 처리가 쉬움 (1부터 10개를 가져오기)
                    .getResultList(); // 테이블을 대상으로 짠 코드가 아니라 객체를 대상으로 짠 코드 (해당 객체인 값을 모두 가져오는 것) -> 객체지향 쿼리
            // 방언에 맞춰 DB에 맞게 변형해줌
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
