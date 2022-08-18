package nl.remco.novi.backend.eindopdracht.into_art.dto;

import org.hibernate.validator.constraints.Length;

public class CreateUserDto {

    @Length(min = 2, max = 64,
            message = "Username needs to be greater than 2 and less than 64 characters")
    private String username;

    @Length(min = 8, max = 24,
            message = "Password needs to be greater than 2 and less than 64 characters")
    private String password;

    //region Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    //endregion

    //region Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //endregion
}
