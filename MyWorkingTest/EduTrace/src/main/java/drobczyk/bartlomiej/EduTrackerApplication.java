package drobczyk.bartlomiej;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
@EnableAspectJAutoProxy
public class EduTrackerApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(EduTrackerApplication.class, args);
    }

    @Bean
    public static RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
