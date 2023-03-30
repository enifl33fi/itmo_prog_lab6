package exceptions;

/**
 * Thrown when CSV line doesn't have enough fields.
 * @author Kirill Markov
 * @version 1.0
 */
public class NotEnoughFieldsException extends RuntimeException {
    /**
     * Constructs new NotEnoughFieldsException with given message.
     * @param message - given message.
     */
    public NotEnoughFieldsException(String message) {
        super(message);
    }
}