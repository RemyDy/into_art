package nl.remco.novi.backend.eindopdracht.into_art.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(defaultValue = "World!") String name) {

        return ResponseEntity.ok().body("Hello %s".formatted(name));
    }
}
