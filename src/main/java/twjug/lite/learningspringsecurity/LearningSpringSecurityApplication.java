package twjug.lite.learningspringsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;


@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@SpringBootApplication
public class LearningSpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringSecurityApplication.class, args);
    }

}
