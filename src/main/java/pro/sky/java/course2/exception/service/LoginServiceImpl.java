package pro.sky.java.course2.exception.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.exception.WrongLoginException;
import pro.sky.java.course2.exception.exception.WrongPasswordException;

import java.util.regex.Pattern;

@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String signIn (String login, String password, String confirmPassword) {
        try {
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,20}$", login)) {
                throw new WrongLoginException();
            }
            if (!Pattern.matches("^[a-zA-Z0-9_]{1,20}$", password)) {
                throw new WrongPasswordException();
            }
            if (login.length() > 20) throw new WrongLoginException();
            if (!password.equals(confirmPassword)) throw new WrongPasswordException();
        } catch (WrongLoginException e) {
            return "Логин не соответствует формату";
        } catch (WrongPasswordException e) {
            return "Пароли не совпадают";
        }
        return "Добро пожаловать";
    }
}
