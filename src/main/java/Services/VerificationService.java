package Services;

import Services.Interfaces.VerificationServiceInterface;

/**
 * The type Verification service.
 */
public class VerificationService implements VerificationServiceInterface {
    @Override
    public boolean verifierId(int id) {
        return false;
    }

    @Override
    public boolean verifierNom(String nom) {
        return false;
    }

    @Override
    public boolean verifierPassword(String password) {
        return false;
    }

    @Override
    public boolean verifierDate(String date) {
        return false;
    }

    @Override
    public boolean verifierAcces(int acces) {
        return false;
    }

    @Override
    public boolean verifierDescription(String description) {
        return false;
    }
}
