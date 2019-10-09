package Controllers.Interface;

public interface VerificationControllerInterface {

    /**
     * Verifier id boolean.
     *
     * @param integer the integer
     * @return the boolean
     */
    boolean verifier(int integer);

    /**
     * Verifier nom boolean.
     *
     * @param string the string
     * @return the boolean
     */
    boolean verifier(String string);

    /**
     * Verifier boolean.
     *
     * @param args the args
     * @return the boolean
     */
    boolean verifier(int... args);

    /**
     * Verifier boolean.
     *
     * @param args the args
     * @return the boolean
     */
    boolean verifier(String... args);

    /**
     * Verifier password boolean.
     *
     * @param password the password
     * @return the boolean
     */
    boolean verifierPassword(String password);

    /**
     * Verifier acces boolean.
     *
     * @param acces the acces
     * @return the boolean
     */
    boolean verifierAcces(int acces);



}
