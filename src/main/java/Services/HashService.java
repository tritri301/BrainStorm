package Services;

import java.security.MessageDigest;

public class HashService {
    private static final HashService instance = new HashService();
    public String HashString(String stringToEncrypt)
    {
        MessageDigest messageDigest = null;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-256");
        }
        catch(Exception e)
        {

        }
        messageDigest.update(stringToEncrypt.getBytes());
        String encryptedString = new String(messageDigest.digest());
        return encryptedString;
    }
    public static HashService getInstance(){return instance;}
}
