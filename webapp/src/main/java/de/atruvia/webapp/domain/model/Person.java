package de.atruvia.webapp.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Person {


    @Setter(AccessLevel.PRIVATE)
    private UUID id;


    private String vorname;


    private String nachname;

}
