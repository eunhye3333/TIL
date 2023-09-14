package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // junit 실행할 때 스프링을 같이 엮어서 실행한다는 뜻
@SpringBootTest // springboot를 끼운 상태로 테스트 진행, 없는 경우 Autowired 실패
@Transactional // 롤백을 위해
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
//    @Autowired EntityManager em;

    @Test
//    @Rollback(false) // 실제로 데이터 insert 됨, 원래 테스트는 DB에 데이터가 남으면 안 되기 때문에 rollback 되어야 함
    public void 회원가입() throws Exception{
        // given : 주어졌을 때
        Member member = new Member();
        member.setName("kim");

        // when : 실행하면
        Long saveId = memberService.join(member);
        // Commit을 해야 insert 쿼리가 날아감 (스프링 @Transactional은 기본적으로 롤백이 되기 때문에 insert가 안 됨
        // 롤백이 되는 경우 영속성 컨텍스트 플러시를 안 함

        // then : 이렇게 나와야 됨
//        em.flush(); // 이렇게 하면 롤백이어도 insert 쿼리 날아감 (flush : DB에 강제로 쿼리를 날리는 것)
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        // given
        Member member1 = new Member();
        member1.setName("kim");

        Member member2 = new Member();
        member2.setName("kim");

        // when
        memberService.join(member1);
//        try { // 예외가 발생하면 테스트가 실패로 뜨기 때문에 try catch로 잡아줌
//            memberService.join(member2); // 같은 이름을 넣었기 때문에 예외가 발생해야 함
//        } catch (IllegalStateException e){
//            return;
//        }
        memberService.join(member2); // (expected = IllegalStateException.class)가 있으면 try catch 없어도 됨

        // then
        fail("예외가 발생해야 한다."); // 코드가 여기 오면 안 됨 -> 테스트 fail 뜨게 함
    }

}