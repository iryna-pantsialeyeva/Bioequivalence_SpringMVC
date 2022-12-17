package by.freeit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {
    @GetMapping("/getLoginForm")
    public String getLoginPage() {
        return "login_form";
    }
}
