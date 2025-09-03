package exceptions.commandTextError;

public class NoSuchCommandFoundException extends RuntimeException {
    public NoSuchCommandFoundException(String message) {
        super(message);
    }
}
