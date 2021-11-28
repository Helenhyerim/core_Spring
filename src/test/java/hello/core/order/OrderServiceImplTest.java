package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {

    // OrderServiceImpl 가 수정자 의존관계 시 테스트, 아래를 가정한다
//    public class OrderServiceImpl implements OrderService {
//        private MemberRepository memberRepository;
//        private DiscountPolicy discountPolicy;
//        @Autowired
//        public void setMemberRepository(MemberRepository memberRepository) {
//            this.memberRepository = memberRepository;
//        }
//        @Autowired
//        public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//            this.discountPolicy = discountPolicy;
//        }
   @Test
    void createOrder() {
       MemberRepository memberRepository = new MemoryMemberRepository();
       memberRepository.save(new Member(1L, "haily", Grade.VIP));
       OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());
       Order order = orderService.createOrder(1L, "door", 3000);
       Assertions.assertThat(order.getDiscountPrice()).isEqualTo(300);


    }

}