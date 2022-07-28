package nl.remco.novi.backend.eindopdracht.into_art.exception;

public class RecordNotFoundException extends RuntimeException {

    public RecordNotFoundException(){

        super("Record(s) not found");
    }
}
