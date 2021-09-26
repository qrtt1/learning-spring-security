package twjug.lite.learningspringsecurity;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.stereotype.Component;

@Component
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(new FriendlyFilter(), LogoutFilter.class);

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/users**").authenticated()
                .anyRequest().permitAll();
    }
}
