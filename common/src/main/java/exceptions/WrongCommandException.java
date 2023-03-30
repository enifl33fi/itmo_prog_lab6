package exceptions;

/**
 * Thrown when user try to execute wrong command.
 * @author Kirill Markov
 * @version 1.0
 */
public class WrongCommandException extends RuntimeException {
    /**
     * message for exception
     */
    private static final String msg = "Unknown command";
    /**
     * Constructs new WrongCommandException with specified message.
     */
    public WrongCommandException() {
        super(msg);
    }
}