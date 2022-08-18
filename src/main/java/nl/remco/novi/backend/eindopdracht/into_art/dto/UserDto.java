package nl.remco.novi.backend.eindopdracht.into_art.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class UserDto {

    private Long id;

    @NotBlank
    @Length(min = 2, max = 64)
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
