package exceptions;

public class TimeLimitException extends RuntimeException {
    private final static String msg = "Server response time exceeded.";
    public TimeLimitException() {
        super(msg);
    }
}
