package exceptions;

/**
 * Thrown when some ids from CSV file match.
 * @author Kirill Markov
 * @version 1.0
 */
public class IdCollapseException extends RuntimeException {
    /**
     * message for exception
     */
    private static final String msg = "Some id collapsed";

    /**
     * Constructs new IdCollapseException with specified message.
     */
    public IdCollapseException() {
        super(msg);
    }
}
