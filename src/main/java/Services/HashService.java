package Services;

import java.security.MessageDigest;

/**
 * The type Hash service.
 */
public class HashService {
    private static final HashService instance = new HashService();

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static HashService getInstance() {
        return instance;
    }

    /**
     * Hash string string.
     *
     * @param stringToEncrypt the string to encrypt
     * @return the string
     */
    public String HashString(String stringToEncrypt) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (Exception e) {

        }
        messageDigest.update(stringToEncrypt.getBytes());
        byte[] encryptedByte = messageDigest.digest();
        String hash = bytesToHex(encryptedByte);
        return hash;
    }
}
