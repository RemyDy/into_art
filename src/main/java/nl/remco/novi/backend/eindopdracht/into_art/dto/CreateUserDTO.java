package nl.remco.novi.backend.eindopdracht.into_art.dto;

import org.hibernate.validator.constraints.Length;

public class CreateUserDTO {

    @Length(min = 5, max = 50)
    private String username;

    private String password;

    /**************************************************/

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
