package Services.Interfaces;

import java.util.List;

/**
 * The interface Verification service interface.
 */
public interface VerificationServiceInterface {
   /**
    * Verifier id boolean.
    * @return the boolean
    */
   boolean verifier(int integer);

   /**
    * Verifier nom boolean.
    *
    * @return the boolean
    */
   boolean verifier(String string);

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
