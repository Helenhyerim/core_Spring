package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 추상과 구현체 동시에 의존하고 있다 DIP 위반
    private final MemberRepository memberRepository;

    // MemoryMemberRepository에 관한 코드가 전혀 없게 되고, MemberRepository 인터페이스만 존재
    // 즉 추상화에만 의존, DIP 를 지킬 수 있게 됨
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
}
