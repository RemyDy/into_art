package nl.remco.novi.backend.eindopdracht.into_art.dto;

import org.hibernate.validator.constraints.Length;

public class CreateUserDto {

    @Length(min = 2, max = 50)
    private String username;

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
