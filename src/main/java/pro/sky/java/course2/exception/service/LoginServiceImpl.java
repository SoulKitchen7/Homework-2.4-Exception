package pro.sky.java.course2.exception.service;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.exception.exception.WrongLoginException;
import pro.sky.java.course2.exception.exception.WrongPasswordException;
@Service
public class LoginServiceImpl implements LoginService {
    @Override
    public String signIn (String login, String password, String confirmPassword) {
        return signIn(login, password, login);
    }
}
