package my.encryption.programs.encryption_api;

import my.encryption.programs.EncryptionUtil;
import my.encryption.programs.FileHandler;
import org.springframework.stereotype.Service;

@Service
public class EncryptionService {

    public String encryptText(String input, int choice) {
        return EncryptionUtil.encryptData(input, choice);
    }

    public boolean isFilePath(String input) {
        return FileHandler.isFilePath(input);
    }

    public void encryptFiles(String filePath, int choice) {
        FileHandler.encryptFiles(filePath, choice);
    }
}
