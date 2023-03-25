package pro.sky.java.course2.exception.exception;

public class WrongLoginException extends RuntimeException {
    public WrongLoginException(String message) {
        super(message);
    }

    public WrongLoginException() {
        super();
    }
}
