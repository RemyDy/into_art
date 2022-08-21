package nl.remco.novi.backend.eindopdracht.into_art.controller;

import nl.remco.novi.backend.eindopdracht.into_art.dto.CreateUserDto;
import nl.remco.novi.backend.eindopdracht.into_art.dto.UserDto;
import nl.remco.novi.backend.eindopdracht.into_art.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<Object> createUserRecord(@Valid @RequestBody CreateUserDto dto, BindingResult br) {

        if (br.hasErrors()) {
            return validateAndReturnErrorsIfAny(br);
        }

        final var user = userService.createUser(dto);

        final var location = URI.create("/users/%s".formatted(user.getId()));

        return ResponseEntity
                .created(location)
                .body(user);
    }

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAllUserRecords() {

        return ResponseEntity.ok()
                .body(userService.getAllUsers());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<UserDto> getUserRecordById(@PathVariable() Long id) {

        return ResponseEntity.ok()
                .body(userService.getUserById(id));
    }

    @GetMapping("name/{username}")
    public ResponseEntity<UserDto> getUserRecordByName(@PathVariable String username) {

        return ResponseEntity.ok()
                .body(userService.getUserByName(username));
    }

    @PatchMapping
    public ResponseEntity<UserDto> updateUserRecord() {

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<String> deleteUserRecordById(@PathVariable Long id) {
        userService.deleteUserById(id);

        return ResponseEntity.ok()
                .body("Record has been deleted");
    }

    //region private methods
    private ResponseEntity<Object> validateAndReturnErrorsIfAny(BindingResult br) {
        final var errors = br.getFieldErrors()
                .stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        return ResponseEntity
                .badRequest()
                .body(errors);
    }
    //endregion

}
