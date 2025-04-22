package my.encryption.programs.encryption_api;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostLoginController {

    @PostMapping("/api/perform_login")
    public Map<String, String> authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Simple authentication logic for now
        if ("admin".equals(loginRequest.getUsername()) && "admin123".equals(loginRequest.getPassword())) {
            return Collections.singletonMap("message", "Login successful");
        } else {
            return Collections.singletonMap("message", "Login failed");
        }
    }
}
