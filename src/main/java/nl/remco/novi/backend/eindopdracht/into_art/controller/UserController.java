package nl.remco.novi.backend.eindopdracht.into_art.controller;

import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDTO;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService
                = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(
            @RequestBody CreateUserDTO createUserDTO) {

        final UserDto createdUser
                = userService.createUser(createUserDTO);

        final URI location
                = URI.create("users/%s".formatted(createdUser.getId()));

        return ResponseEntity
                .created(location)
                .body(createdUser);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {

        final List<UserDto> allUsers
                = userService.getAllUsers();

        return ResponseEntity.ok(allUsers);
    }

}
