package exceptions.commandTextError;

public class InvalidContentFormatException extends RuntimeException {
    public InvalidContentFormatException(String message) {
        super(message);
    }
}
