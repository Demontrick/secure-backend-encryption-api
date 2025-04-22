package my.encryption.programs.encryption_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String loginPage() {
        return "Login page is working";  // Response for GET requests
    }

    @PostMapping("/perform_login")
    public String authenticateUser(@RequestBody LoginRequest loginRequest) {
        // Simple authentication logic for now
        if ("admin".equals(loginRequest.getUsername()) && "admin123".equals(loginRequest.getPassword())) {
            return "Login successful";
        } else {
            return "Login failed";
        }
    }
}
