package exceptions;

/**
 * Thrown when required system variable is null.
 * @author Kirill Markov
 * @version 1.0
 */
public class WrongFieldException extends RuntimeException {
    /**
     * Constructs new NotEnoughFieldsException with given message.
     * @param message given message.
     */
    public WrongFieldException(String message) {
        super(message);
    }
}
