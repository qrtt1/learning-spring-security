package twjug.lite.learningspringsecurity;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FriendlyFilter extends OncePerRequestFilter {

    AuthenticationManager authenticationManager;

    public FriendlyFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (hasAuthenticated()) {
            filterChain.doFilter(request, response);
            return;
        }

        Authentication requestToken = asAuthentication(request);
        if (requestToken == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Authentication authentication = authenticationManager.authenticate(requestToken);
        if (authentication == null || !authentication.isAuthenticated()) {
            filterChain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private Authentication asAuthentication(HttpServletRequest request) {
        String token = request.getHeader("x-twjug-authorization");
        if (token == null) {
            return null;
        }
        return new ApiToken(token);
    }

    private boolean hasAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication != null && authentication.isAuthenticated();
    }
}
