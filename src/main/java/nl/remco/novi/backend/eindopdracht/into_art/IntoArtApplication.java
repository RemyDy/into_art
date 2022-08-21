package nl.remco.novi.backend.eindopdracht.into_art;

import nl.remco.novi.backend.eindopdracht.into_art.consoleApp.IntoArtConsoleApp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntoArtApplication {

    public static void main(String[] args) {

        SpringApplication.run(IntoArtApplication.class, args);

        new IntoArtConsoleApp()
                .runIntoArtConsoleApp();

    }


}
