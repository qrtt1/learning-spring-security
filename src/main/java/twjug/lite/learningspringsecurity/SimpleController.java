package twjug.lite.learningspringsecurity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleController {

    @RequestMapping("/")
    public String home() {
        return "home";
    }

    @RequestMapping("/users")
    public String users() {
        return "users";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping("/info")
    public String info() {
        return "info";
    }
}
