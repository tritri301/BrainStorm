package Exception;

import Exception.Interfaces.ExceptionInterface;

/**
 * The type Exception custom.
 */
public class ExceptionCustom extends Exception implements ExceptionInterface {
    /**
     * Instantiates a new Exception custom.
     *
     * @param message the message
     */
    public ExceptionCustom(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
