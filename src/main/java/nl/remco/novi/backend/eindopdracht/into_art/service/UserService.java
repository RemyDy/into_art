package nl.remco.novi.backend.eindopdracht.into_art.service;

import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
     UserDto createUser(CreateUserDto dto);

     List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto getUserByName(String username);

    void deleteUserById(@RequestBody Long id);

}
