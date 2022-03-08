package jpabook.jpashop;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTestTemp {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional // EntityManager는 트랜잭션 아래에서 동작하기 때문에 없으면 에러 발생
    // Transactional 어노테이션이 테스트케이스에 있으면 테스트가 끝나면 롤백을 함
    @Rollback(false) // 이렇게 하면 롤백 안 됨
    public void testMember() throws Exception{
        // given
        MemberTest member = new MemberTest();
        member.setUsername("memberA");
        // when
        Long saveId = memberRepository.save(member);
        MemberTest findMember = memberRepository.find(saveId);

        // then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
        Assertions.assertThat(findMember).isEqualTo(member); // 같은 트랜잭션이면 영속성 컨텍스트가 같기 때문에 같다고 나옴 (같은 영속성 컨텍스트 안에서는 아이디 값기 같으면 같은 엔티티로 인식)
        System.out.println("findMember == member: " + (findMember == member));
    }

}