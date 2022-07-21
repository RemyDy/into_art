package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.domain.user.User;
import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDTO;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.exception.UsernameExistsException;
import nl.remco.novi.backend.eindopdracht.into_art.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto createUser(CreateUserDTO createUserDTO) {

        final User savedUser
                = getSavedUser(createUserDTO);

        final Optional<User> userOptional
                = userRepository.findUserByUsernameIs(createUserDTO.getUsername());

        if (userOptional.isPresent()) {
            throw new UsernameExistsException(createUserDTO.getUsername());
        }

        return getUserDto(savedUser);
    }

    private UserDto getUserDto(User savedUser) {
        UserDto userDto = new UserDto();
        userDto.setId(savedUser.getId());
        userDto.setUsername(savedUser.getUsername());
        return userDto;
    }

    private User getSavedUser(CreateUserDTO createUserDTO) {
        User user = new User();
        user.setUsername(createUserDTO.getUsername());
        user.setPassword(createUserDTO.getPassword());
        return userRepository.save(user);
    }

    public List<UserDto> getAllUsers() {
        return null; // pas aan
    }
}
