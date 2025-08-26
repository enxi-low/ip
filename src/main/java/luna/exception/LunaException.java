package luna.exception;

public class LunaException extends RuntimeException {
    public LunaException(String errorMessage) {
        super(errorMessage);
    }
}