package my.encryption.programs.encryption_api;

import java.security.SecureRandom;
import java.util.Base64;

public class PassphraseGenerator {
    private static final SecureRandom secureRandom = new SecureRandom();

    public static String generatePassphrase() {
        byte[] randomBytes = new byte[24]; // 24 bytes = 192 bits
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().encodeToString(randomBytes);
    }
}

