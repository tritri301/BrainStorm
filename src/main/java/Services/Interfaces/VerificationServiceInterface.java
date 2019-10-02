package Services.Interfaces;

import java.util.List;

/**
 * The interface Verification service interface.
 */
public interface VerificationServiceInterface {
   /**
    * Verifier id boolean.
    *
    * @param id the id
    * @return the boolean
    */
   boolean verifierId(int id);

   /**
    * Verifier nom boolean.
    *
    * @param nom the nom
    * @return the boolean
    */
   public boolean verifierNom(String nom);

   /**
    * Verifier password boolean.
    *
    * @param password the password
    * @return the boolean
    */
   public boolean verifierPassword(String  password);

   /**
    * Verifier acces boolean.
    *
    * @param acces the acces
    * @return the boolean
    */
   boolean verifierAcces(int acces);

   /**
    * Verifier description boolean.
    *
    * @param description the description
    * @return the boolean
    */
   boolean verifierDescription(String description);
}
