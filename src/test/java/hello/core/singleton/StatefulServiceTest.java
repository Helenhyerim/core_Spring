package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import static org.assertj.core.api.Assertions.assertThat;
// 스프링 빈은 항상 무상태로 설계할것 stateless
class StatefulServiceTest {

    @Test
    void statefulServiceSigleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThredA: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // ThredB: B 사용자 20000원 주문
        statefulService2.order("userB", 30000);

        // ThreadA: 사용자 A 주문금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        assertThat(statefulService1).isEqualTo(statefulService2);

    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}