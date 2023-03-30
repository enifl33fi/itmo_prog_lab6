package exceptions;

/**
 * Thrown when field that shouldn't be null is null.
 * @author Kirill Markov
 * @version 1.0 */
public class NullFieldException extends RuntimeException {
    /**
     * message for exception
     */
    private static final String msg = " field cannot be null. The string cannot be empty.";
    /**
     * Constructs new NullFieldException with specified message plus name of the field.
     * @param field name of the field
     */
    public NullFieldException(String field) {
        super(field + msg);
    }
}
