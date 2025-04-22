package my.encryption.programs.encryption_api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://127.0.0.1:8000", "http://localhost:8000"})
public class EncryptionController {

    private static final Logger logger = LoggerFactory.getLogger(EncryptionController.class);

    @Autowired
    private EncryptionService encryptionService;

    @PostMapping(value = "/encrypt", consumes = "multipart/form-data", produces = "application/json")
    public ResponseEntity<Map<String, String>> encryptData(
            @RequestPart(value = "text", required = false) String text,
            @RequestPart(value = "choice", required = true) String choice,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        try {
            String encryptedData;

            if (text != null && !text.isEmpty()) {
                encryptedData = encryptionService.encryptText(text, Integer.parseInt(choice));
                logger.info("Text encrypted: {}", encryptedData);
            } else if (file != null) {
                encryptionService.encryptFiles(file.getOriginalFilename(), Integer.parseInt(choice));
                encryptedData = "File encryption completed";
                logger.info("File encrypted: {}", encryptedData);
            } else {
                throw new IllegalArgumentException("No data provided for encryption");
            }
            return ResponseEntity.ok(Collections.singletonMap("encryptedData", encryptedData));
        } catch (Exception e) {
            logger.error("Encryption error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(Collections.singletonMap("error", e.getMessage()));
        }
    }
}
