package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(

        excludeFilters = @ComponentScan.Filter(type =FilterType.ANNOTATION, classes = Configuration.class)) // 기존코드 살리기위해서
public class AutoAppConfig {

}
