package my.encryption.programs.encryption_api.service;

import my.encryption.programs.encryption_api.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SecurePassService {

    @Autowired
    private JavaMailSender mailSender;

    public String generatePassphrase() {
        return PassphraseGenerator.generatePassphrase();
    }

    public void sendPassphraseEmail(String email, String passphrase) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Your SecurePass Passphrase");
        message.setText("Your passphrase for accessing your secure data is: " + passphrase);
        mailSender.send(message);
    }
}

