package nl.remco.novi.backend.eindopdracht.into_art.controller;

import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // region Create
    @PostMapping()
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateUserDto dto, BindingResult br) {

        if (br.hasErrors()) {
            final var errors = br.getFieldErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .toList();

            return ResponseEntity
                    .badRequest()
                    .body(errors);
        } else {
            final var user = userService.createUser(dto);
            final var location = URI.create("/users/%s".formatted(user.getId()));

            return ResponseEntity
                    .created(location)
                    .body(user);
        }
    }
    // endregion post requests

    // region Read
    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUsers() {

        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable() Long id) {

        return ResponseEntity.ok()
                .body(userService.getUserById(id));
    }

    @GetMapping("name/{username}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable String username) {

        return ResponseEntity.ok()
                .body(userService.getUserByName(username));
    }
    // endregion


    //region Update
    @PatchMapping
    public ResponseEntity<UserDto> updateUser() {

        return ResponseEntity.ok().build();
    }
    //endregion


    //region Delete
    @DeleteMapping("id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.ok()
                .body("Record has been deleted");
    }
    //endregion

}
