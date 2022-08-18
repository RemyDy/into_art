package nl.remco.novi.backend.eindopdracht.into_art.exception;

public class RecordExistsException extends RuntimeException {

    public RecordExistsException() {

        super();
    }

    public RecordExistsException(String message) {

        super(message);
    }
}
