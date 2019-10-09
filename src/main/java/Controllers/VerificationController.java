package Controllers;

import Controllers.Interface.VerificationControllerInterface;
import Exception.*;
import Services.VerificationService;

public class VerificationController implements VerificationControllerInterface {

    private static final VerificationController instance = new VerificationController();
    private VerificationService verificationService = VerificationService.GetInstance();

    @Override
    public boolean verifier(int integer) {

        boolean valider = true;
        try {
            valider = verificationService.verifier(integer);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return valider;
    }

    @Override
    public boolean verifier(String string) {

        boolean valider = true;
        try {
            valider = verificationService.verifier(string);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return valider;

    }

    @Override
    public boolean verifier(int... args) {

        boolean valider = true;
        try {
            valider = verificationService.verifier(args);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return valider;
    }

    @Override
    public boolean verifier(String... args) {

        boolean valider = true;
        try {
            valider = verificationService.verifier(args);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return valider;
    }

    @Override
    public boolean verifierPassword(String password) {

        boolean validerPassword = true;
        try {
            validerPassword = verificationService.verifier(password);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return validerPassword;
    }

    @Override
    public boolean verifierAcces(int acces) {

        boolean validerAcces = true;
        try {
            validerAcces = verificationService.verifier(acces);
        } catch (ExceptionCustom e) {

        }
        catch(Exception e) {

        }

        return validerAcces;

    }

    public static VerificationController GetInstance()
    {
        return instance;
    }
}
