package exception;

public class CannotCreateClassObjectException extends RuntimeException {

    public CannotCreateClassObjectException() { }

    public CannotCreateClassObjectException(String message) {
        super(message);
    }

}
