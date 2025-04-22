package my.encryption.programs.encryption_api.Controller;

import my.encryption.programs.encryption_api.service.SecurePassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/securepass")
public class SecurePassController {

    @Autowired
    private SecurePassService securePassService;

    @PostMapping("/save")
    public String handleNewData(@RequestParam String dataType,
                                @RequestParam String dataContent,
                                @RequestParam String email) {
        String passphrase = securePassService.generatePassphrase();
        securePassService.sendPassphraseEmail(email, passphrase);
        return "Passphrase sent to your email.";
    }
}
