package nl.remco.novi.backend.eindopdracht.into_art.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class CustomBeans {

    @Bean
    public BCryptPasswordEncoder getBCrBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
