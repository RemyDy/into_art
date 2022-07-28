package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.domain.User;
import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.exception.RecordNotFoundException;
import nl.remco.novi.backend.eindopdracht.into_art.exception.UsernameExistsException;
import nl.remco.novi.backend.eindopdracht.into_art.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //region Create

    public UserDto createUser(CreateUserDto createDto) {

        userRepository.findUserByUsernameIs(createDto.getUsername())
                .ifPresent(action -> {
                    throw new UsernameExistsException();
                });

        return relayToDto(userRepository.save(relayToUser(createDto)));
    }

    //endregion

    //region Read

    public List<UserDto> getAllUsers() {
        final var userRecords = userRepository.findAll();

        if (userRecords.isEmpty()) {
            throw new RecordNotFoundException();
        }

        return userRecords.stream()
                .map(this::relayToDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        final var userRecord = userRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);

        return relayToDto(userRecord);
    }

    public UserDto getUserByName(String username) {

        final var userRecord = userRepository.findUserByUsernameIs(username)
                .orElseThrow(RecordNotFoundException::new);

        return relayToDto(userRecord);
    }

    //endregion

    //region Update


    //endregion

    //region Delete

    public void deleteUserById(@RequestBody Long id) {
        userRepository.findById(id)
                .orElseThrow(RecordNotFoundException::new);

        userRepository.deleteById(id);
    }

    //endregion

    //region private methods only

    private UserDto relayToDto(User user) {
        var dto = new UserDto();

        dto.setId(user.getId());
        dto.setUsername(user.getUsername());

        return dto;
    }

    private User relayToUser(CreateUserDto dto) {
        var user = new User();
        var hashedPassword = passwordEncoder.encode(dto.getPassword());

        user.setUsername(dto.getUsername());
        user.setPassword(hashedPassword);

        return user;
    }

    //endregion

}
