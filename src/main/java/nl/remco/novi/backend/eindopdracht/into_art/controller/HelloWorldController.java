package nl.remco.novi.backend.eindopdracht.into_art.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello(@RequestParam(defaultValue = "World!") String name) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth.getPrincipal() instanceof UserDetails ud) {
            return ResponseEntity.ok().body("Hallo" + ud.getUsername() + "met rollen" + ud.getAuthorities().toString());
        }

        return ResponseEntity.ok().body("Hello %s".formatted(name));
    }
}
