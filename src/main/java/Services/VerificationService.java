package Services;

import Services.Interfaces.VerificationServiceInterface;
import com.sun.xml.internal.ws.util.StringUtils;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.text.Normalizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Verification service.
 */
public class VerificationService implements VerificationServiceInterface {

    private static final VerificationService instance = new VerificationService();

    @Override
    public boolean verifier(int integer) {
        boolean valide = false;

        if (integer >= 1) {
            valide = true;
        }

        return valide;
    }

    @Override
    public boolean verifier(String string) {
        boolean valide = false;

        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(string);

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

         if ((upperCase <= 0) && specialChar <= 0)
         {
             regle3 = false;
         }

         if (regle3)
         {
             valide = false;
         }

        return valide;
    }

    @Override
    public boolean verifierAcces(int acces)
    {
        boolean valide = false;

        if ((acces == 0) || (acces == 1))
        {
            valide = true;
        }

        return valide;

    }

    @Override
    public boolean emplacementVerification(String emplacementBrut) {

        //a fair
        return true;
    }

    @Override
    public String normalisation(String string) {

        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        string = string.toLowerCase();
        string = string.replaceAll("[^a-zA-Z0-9_-]", "");

        return string;
    }

    @Override
    public int[] EmplacementDecortiquer(int emplacementBrut) {

        int [] emplacement = new int[]{ 1,2,3};
        int posX = Integer.parseInt(Integer.toString(emplacementBrut).substring(0,3));
        int posY = Integer.parseInt(Integer.toString(emplacementBrut).substring(3,3));
        int posZ = Integer.parseInt(Integer.toString(emplacementBrut).substring(6));

        emplacement[0] = posX;
        emplacement[1] = posY;
        emplacement[2] = posZ;

        return emplacement;
    }

    @Override
    public boolean verifier(int... args)
    {
        boolean valide = true;
        for (int arg : args) {
            valide = this.verifier(arg);
            if (!valide)
            {
                valide = false;
                break;
            }
        }
        return valide;
    }

    @Override
    public boolean verifier(String... args)
    {
        boolean valide = true;
        for (String arg : args) {
            valide = this.verifier(arg);
            if (!valide)
            {
                valide = false;
                break;
            }
        }
        return valide;
    }

    public static VerificationService GetInstance()
    {
        return instance;
    }
}
