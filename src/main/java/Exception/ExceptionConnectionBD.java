package Exception;

import Exception.Interfaces.ExceptionInterface;

public class ExceptionConnectionBD extends Exception implements ExceptionInterface {
    @Override
    public String envoyerErreur(String msg) {
        return msg;
    }
}
