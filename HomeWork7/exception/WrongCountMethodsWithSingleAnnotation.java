package exception;

public class WrongCountMethodsWithSingleAnnotation extends RuntimeException{

    public WrongCountMethodsWithSingleAnnotation() {
    }

    public WrongCountMethodsWithSingleAnnotation(String message) {
        super(message);
    }
}
