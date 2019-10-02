package Services;

import Services.Interfaces.VerificationServiceInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Verification service.
 */
public class VerificationService implements VerificationServiceInterface {

    private static final VerificationService instance = new VerificationService();

    @Override
    public boolean verifierId(int id) {
        boolean valide = false;

        if (id >= 1) {
            valide = true;
        }

        return valide;
    }

    @Override
    public boolean verifierNom(String nom) {
        boolean valide = false;

        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(nom);

        if (matcher.matches())
        {
            valide = true;
        }
        return valide;
    }

    @Override
    public boolean verifierPassword(String password) {
        boolean valide = true;
        boolean regle3 = true;
        int digit = 0;
        int upperCase = 0;
        int specialChar = 0;
        short lenght = 0;

         for (char ch: password.toCharArray()) {
             lenght++;
             if ((ch == ';') || (ch == ' ') || (ch == ',')) {
                 valide = false;
             }
         }

         if (lenght < 6)
         {
             valide = false;
         }

         //number
        for (int i = 0, len = password.length(); i < len; i++) {
            if (Character.isDigit(password.charAt(i))) {
                digit++;
                break;
            }
        }

        if (digit <= 0)
        {
            valide = false;
        }

        specialChar = password.replaceAll("\\p{Alnum}", "").length();
        upperCase = password.split("(?=\\p{Lu})").length - 1;

         if ((upperCase <= 0) || upperCase <= 0)
         {
             regle3 = false;
         }

        return valide;
    }

    @Override
    public boolean verifierDate(String date) {
        boolean valide = false;
        return valide;
    }

    @Override
    public boolean verifierAcces(int acces) {
        boolean valide = false;
        return valide;
}

    @Override
    public boolean verifierDescription(String description) {
        boolean valide = false;
        return valide;
    }

    public static VerificationService GetInstance()
    {
        return instance;
    }
}
