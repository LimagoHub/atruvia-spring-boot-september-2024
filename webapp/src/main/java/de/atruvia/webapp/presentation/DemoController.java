package de.atruvia.webapp.presentation;


import de.atruvia.webapp.presentation.dto.PersonDTO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import java.util.UUID;

@RestController
@RequestMapping("/demo")

public class DemoController {

    @GetMapping(value = "/gruss", produces = MediaType.TEXT_PLAIN_VALUE)
    public String gruss() {
        return "Hallo Rest";
    }
    @GetMapping(value = "/john", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public PersonDTO getPerson(){
        return PersonDTO.builder().id(UUID.randomUUID()).vorname("John").nachname("Doe").build();
    }
}
