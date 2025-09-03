package exceptions.directoryNotEmpty;

public class DirectoryNotEmptyException extends RuntimeException {
    public DirectoryNotEmptyException(String message) {
        super(message);
    }
}
