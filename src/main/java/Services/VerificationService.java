package Services;

import Models.Container;
import Models.Item;
import Models.ItemInfo;
import Repositories.ContainerRepository;
import Repositories.ItemInfoRepository;
import Repositories.ItemRepository;
import Services.Interfaces.VerificationServiceInterface;
import Exception.*;
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
    private ContainerRepository containerRepository = ContainerRepository.GetInstance();
    private ItemInfoRepository itemInfoRepository = ItemInfoRepository.GetInstance();
    private ItemRepository itemRepository = ItemRepository.GetInstance();
    private ItemService itemService = ItemService.GetInstance();

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
    public boolean verifierEmail(String email) {
        boolean valide = false;

        String regex = "^[a-zA-Z0-9]+@+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        if (matcher.matches())
        {
            valide = true;
        }
        return valide;
    }
    public boolean verifierPermission(String permission)
    {
        boolean valide = false;

        String regex = "^[0-1]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(permission);

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
    public boolean emplacementExist(String emplacement) {
        boolean valide = true;
        Container container = null;

        try {
            container = containerRepository.FindById(emplacement);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }

        if (container == null)
        {
            valide = false;
        }

        return valide;
    }

    @Override
    public boolean itemInfoExist(int idItem) {
        boolean valide = true;
        ItemInfo itemInfo = null;

        try {
            itemInfo = itemInfoRepository.FindById(idItem);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }

        if (itemInfo == null)
        {
            valide = false;
        }

        return valide;
    }

    @Override
    public boolean itemExist(int id) {

        boolean valide = true;
        Item item = null;

        try {
            item = itemRepository.FindById(id);
        }
        catch(Exception e)
        {
            System.out.print(e.toString());
        }

        if (item == null)
        {
            valide = false;
        }

        return valide;
    }

    @Override
    public String normalisation(String string) {

        string = Normalizer.normalize(string, Normalizer.Form.NFD);
        string = string.replaceAll("[^\\p{ASCII}]", "");
        string = string.toLowerCase();
        string = string.replaceAll("[^a-zA-Z0-9-]", "");

        return string;
    }

    @Override
    public boolean verifierDescription(String description) {
        short nbEqual = 0;
        short nbComma = 0;
        boolean valide = true;

        for(int i = 0; i < description.length(); i++)
        {
            char c = description.charAt(i);

            if(c == '=')
            {
                nbEqual++;
            }

            if(c == ',')
            {
                nbComma++;
            }
        }

        if (nbComma > 0 && nbEqual > 0)
        {
            if (nbComma + 1 > nbEqual)
            {
                valide = false;
            }

            if (nbEqual -1 > nbComma)
            {
                valide = false;
            }
        }

        return valide;
    }

    @Override
    public boolean verifierQuantiteRestante(int idItem, int quantite) {
        boolean valide = false;

        Item item = null;
        try {
            item = itemRepository.FindById(idItem);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int qtn = item.getQuantite();

        if (qtn - quantite >= 0)
            {
                valide = true;
            }

        return valide;
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
