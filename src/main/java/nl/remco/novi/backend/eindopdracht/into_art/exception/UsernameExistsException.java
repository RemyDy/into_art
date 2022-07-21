package nl.remco.novi.backend.eindopdracht.into_art.exception;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String username) {
        super("Username %s already exists".formatted(username));
    }
}
