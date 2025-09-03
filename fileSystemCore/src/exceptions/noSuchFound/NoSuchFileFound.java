package exceptions.noSuchFound;

public class NoSuchFileFound extends RuntimeException {
    public NoSuchFileFound(String message) {
        super(message);
    }
}
