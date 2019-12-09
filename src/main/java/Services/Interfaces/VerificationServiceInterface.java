package Services.Interfaces;

/**
 * The interface Verification service interface.
 */
public interface VerificationServiceInterface {
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
     * @param email the email
     * @return the boolean
     */
    boolean verifierEmail(String email);

    /**
     * Emplacement exist boolean.
     *
     * @param emplacementBrut the emplacement brut
     * @return the boolean
     */
    boolean emplacementExist(String emplacementBrut);

    /**
     * Item info exist boolean.
     *
     * @param iditem the iditem
     * @return the boolean
     */
    boolean itemInfoExist(int iditem);

    /**
     * Item exist boolean.
     *
     * @param iditem the iditem
     * @return the boolean
     */
    boolean itemExist(int iditem);

    /**
     * Normalisation string.
     *
     * @param string the string
     * @return the string
     */
    String normalisation(String string);

    /**
     * Verifier description boolean.
     *
     * @param description the description
     * @return the boolean
     */
    boolean verifierDescription(String description);

    /**
     * Verifier quantite restante boolean.
     *
     * @param idItem   the id item
     * @param quantite the quantite
     * @return the boolean
     */
    boolean verifierQuantiteRestante(int idItem, int quantite);

    /**
     * Emplacement decortiquer int [ ].
     *
     * @param emplacementBrut the emplacement brut
     * @return the int [ ]
     */
    int[] EmplacementDecortiquer(int emplacementBrut);
}
