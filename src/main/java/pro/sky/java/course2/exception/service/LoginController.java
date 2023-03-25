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
        try {
            if (login.length() > 20) throw new WrongLoginException();
            if (!password.equals(confirmPassword)) throw new WrongPasswordException();
        } catch (WrongLoginException e) {
            return "Логин не дложен превышать 20 символов";
        } catch (WrongPasswordException e) {
            return "Пароли не совпадают";
        }
        return "Добро пожаловать";
    }
}
//
