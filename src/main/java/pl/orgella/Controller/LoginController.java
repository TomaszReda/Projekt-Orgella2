package pl.orgella.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/failLogin")
    public String failuser()
    {
        return "failLoginForm";
    }

    @GetMapping("/loginForm")
    public String login()
    {
        return "loginForms";
    }
}
