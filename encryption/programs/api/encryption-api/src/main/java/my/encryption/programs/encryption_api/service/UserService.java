package my.encryption.programs.encryption_api.service;

import org.springframework.stereotype.Service;
import my.encryption.programs.encryption_api.dto.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<UserDto> users = new ArrayList<>();

    public UserDto createUser(UserDto userDto) {
        userDto.setId((long) (users.size() + 1));
        users.add(userDto);
        return userDto;
    }

    public List<UserDto> getAllUsers() {
        return users;
    }

    public UserDto getUserById(Long id) {
        Optional<UserDto> user = users.stream().filter(u -> u.getId().equals(id)).findFirst();
        return user.orElse(null);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        UserDto existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setName(userDto.getName());
            existingUser.setEmail(userDto.getEmail());
        }
        return existingUser;
    }

    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
