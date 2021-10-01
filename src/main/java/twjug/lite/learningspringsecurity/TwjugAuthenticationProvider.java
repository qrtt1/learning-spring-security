package twjug.lite.learningspringsecurity;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class TwjugAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("returning Authentication: " + authentication);
        // TODO: convert the token in the authentication to user details
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return ApiToken.class.equals(authentication);
    }
}
