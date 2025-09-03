package exceptions;

public class NoSuchDirectoryFound extends Exception{
    @Override
    public String getMessage() {
        return "cd: no such directory exists";
    }
}
