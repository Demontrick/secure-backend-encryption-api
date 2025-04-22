package my.encryption.programs;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class EncryptionUtil {
    private static SecretKey aesKey;
    private static SecretKey desKey;

    public static String encryptData(String data, int choice) {
        try {
            if (choice == 2) { // AES-256 encryption
                if (aesKey == null) {
                    KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                    keyGen.init(256);
                    aesKey = keyGen.generateKey();
                }
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, aesKey);
                byte[] encryptedBytes = cipher.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            } else if (choice == 1) { // 3DES encryption
                if (desKey == null) {
                    KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
                    keyGen.init(168);
                    desKey = keyGen.generateKey();
                }
                Cipher cipher = Cipher.getInstance("DESede");
                cipher.init(Cipher.ENCRYPT_MODE, desKey);
                byte[] encryptedBytes = cipher.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "encrypted_" + data; // Fallback in case of an error
    }
}
