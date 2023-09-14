package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // 기본적으로 데이터를 변경하는 것은 트랜잭션이 있어야 함 (spring에서 제공하는 트랜잭션 사용을 권장)
// 여기에서 readOnly = true를 설정하면 아래 public 메소드에는 기본적으로 먹힘, 따로 설정한 것은 따로 설정한 것이 우선권을 가짐 (기본은 false)
//@AllArgsConstructor // 아래와 같은 1. 생성자 인젝션을 자동으로 만들어줌
@RequiredArgsConstructor // final인 필드만 가진 생성자를 생성해줌
public class MemberService {

//    @Autowired
//    private MemberRepository memberRepository; // 필드 인젝션, 테스트 코드 작성 시 주입이 불가능

    private final MemberRepository memberRepository;

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    } // setter 인젝션 : 테스트 코드를 작성하는 경우 주입 가능, 필드 인젝션의 경우에는 주입이 불가능
    // 단점 : 런타임 시 누군가 변경할 수 있음

//    @Autowired
//    public MemberService(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    } // 요즘 권장하는 방법 : 1. 생성자 인젝션
    // 최신 버전 스프링에서는 @Autowired를 붙이지 않아도 자동으로 객체를 주입해줌

    // 회원 가입
    @Transactional
    public Long join(Member member){
        
        validateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return  member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 중복 회원이면 EXCEPTION
        List<Member> findMembers = memberRepository.findByName(member.getName()); // 만약 동시에 가입하는 경우에는 에러 처리가 안 됨 따라서 실무에서는 최후의 방어로 unique 제약조건을 걸어 두는 것이 좋음

        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
//    @Transactional(readOnly = true) // readOnly = true 조회 성능 최적화 (읽기에만 넣기)
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    // 단건 조회
//    @Transactional(readOnly = true)
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
