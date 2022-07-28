package nl.remco.novi.backend.eindopdracht.into_art.exception;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException() {
        super("Username already exists");
    }
}
