package twjug.lite.learningspringsecurity;

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


}
