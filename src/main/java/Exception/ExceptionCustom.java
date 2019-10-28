package Exception;

import Exception.Interfaces.ExceptionInterface;

public class ExceptionCustom extends Exception implements ExceptionInterface {
    public ExceptionCustom(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
