package nl.remco.novi.backend.eindopdracht.into_art.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserDto {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 64, message = "Username needs to be greater than 2 or lesser than 64 characters")
    private String username;

    public UserDto() {
    }

    //region Getters

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    //endregion

    //region Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //endregion
}
