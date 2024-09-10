package de.atruvia.webapp;


import de.atruvia.webapp.persistence.PersonRepository;
import de.atruvia.webapp.persistence.entity.PersonEntity;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
//@Component
@Transactional
public class Demo {

    private final PersonRepository personRepository;

    @PostConstruct
    public void init() {

        personRepository.findAllTinyPersons().forEach(System.out::println);
    }
}
