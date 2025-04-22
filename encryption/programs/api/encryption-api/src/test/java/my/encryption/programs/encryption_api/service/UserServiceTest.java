package my.encryption.programs.encryption_api.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import my.encryption.programs.encryption_api.dto.UserDto;

public class UserServiceTest {

    private UserService userService; // Correctly reference UserService

    @BeforeEach
    public void setUp() {
        userService = new UserService(); // Initialize UserService, not UserServiceTest
    }

    @Test
    public void testCreateUser() {
        UserDto userDto = new UserDto();
        userDto.setName("John Doe");
        userDto.setEmail("john.doe@example.com");

        UserDto createdUser = userService.createUser(userDto);

        assertNotNull(createdUser.getId());
        assertEquals("John Doe", createdUser.getName());
        assertEquals("john.doe@example.com", createdUser.getEmail());
    }

    // Additional tests for other methods...
}
