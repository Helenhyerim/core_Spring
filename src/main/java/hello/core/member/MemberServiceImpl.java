package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    // 추상에만 의존하게 수정
    private final MemberRepository memberRepository;

    // MemoryMemberRepository에 관한 코드가 전혀 없게 되고, MemberRepository 인터페이스만 존재
    // 즉 추상화에만 의존, DIP 를 지킬 수 있게 됨
    @Autowired // 생성자에 Autowired -> 의존관계 주입, Component랑 짝궁
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public void join(Member member) {

        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    // 테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
