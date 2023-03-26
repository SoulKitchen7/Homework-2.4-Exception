package pro.sky.java.course2.exception.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.exception.exception.WrongLoginException;
import pro.sky.java.course2.exception.exception.WrongPasswordException;

@RestController
@RequestMapping("/signIn")
public class LoginController {
    private final LoginServiceImpl loginService;
    public LoginController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }
    @GetMapping
    public String signIn(
            @RequestParam("login") String login,
            @RequestParam("password") String password,
            @RequestParam ("confirmPassword") String confirmPassword){
        return loginService.signIn(login, password, confirmPassword);
    }
}

