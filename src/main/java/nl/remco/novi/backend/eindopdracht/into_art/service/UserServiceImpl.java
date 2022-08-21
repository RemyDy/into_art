package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.domain.entities.User;
import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordNotFoundException;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordExistsException;
import nl.remco.novi.backend.eindopdracht.into_art.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto createUser(CreateUserDto dto) {

        if (userRepository.findUserByUsernameIs(dto.getUsername()).isPresent()) {
            throw new RecordExistsException();
        }

        final var userRecord = userRepository.save(relayToUser(dto));

        return relayToDto(userRecord);
    }

    public List<UserDto> getAllUsers() {

        final var userRecords = userRepository.findAll();

        if (userRecords.isEmpty()) {
            throw new RecordNotFoundException();
        }

        return userRecords.stream()
                .map(this::relayToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {

        final var userRecord = userRepository.findById(id)
                .orElseThrow(RecordExistsException::new);

        return relayToDto(userRecord);
    }

    public UserDto getUserByName(String username) {

        final var userRecord = userRepository.findUserByUsernameIs(username)
                .orElseThrow(RecordNotFoundException::new);

        return relayToDto(userRecord);
    }

    public void deleteUserById(@RequestBody Long id) {

        userRepository.findById(id).orElseThrow(RecordNotFoundException::new);
        userRepository.deleteById(id);
    }

    //region private methods
    private UserDto relayToDto(User user) {

        var dto = new UserDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }

    private User relayToUser(CreateUserDto dto) {

        var hashedDtoPassword = passwordEncoder.encode(dto.getPassword());

        var user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(hashedDtoPassword);

        return user;
    }
    //endregion

}
