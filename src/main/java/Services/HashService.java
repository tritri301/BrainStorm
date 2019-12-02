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
        byte[] encryptedByte = messageDigest.digest();
        String hash = bytesToHex(encryptedByte);
        return hash;
    }
    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
    public static HashService getInstance(){return instance;}
}
