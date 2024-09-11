package de.atruvia.webapp.domain.internal.configuration;


import de.atruvia.webapp.domain.PersonService;
import de.atruvia.webapp.domain.internal.PersonServiceImpl;
import de.atruvia.webapp.domain.mapper.PersonMapper;
import de.atruvia.webapp.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PersonConfig {

    @Bean
    @Qualifier("blacklist")
    public List<String> blacklist() {
        return List.of("Attila", "Peter", "Paul","Mary");
    }

    @Bean
    @Qualifier("fruits")
    public List<String> createFruits() {
        return List.of("Banana", "Cherry", "Apple","Raspberry");
    }

    @Bean
    public PersonService personService(
            PersonRepository repository,
            @Qualifier("blacklist") List<String> liste,
            PersonMapper mapper) {
        return new PersonServiceImpl(repository, liste, mapper);
    }
}
