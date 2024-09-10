package de.atruvia.webapp.presentation.v1;

import de.atruvia.webapp.domain.PersonService;
import de.atruvia.webapp.domain.PersonenServiceException;
import de.atruvia.webapp.presentation.dto.PersonDTO;
import de.atruvia.webapp.presentation.mapper.PersonDTOMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.UUID;

@RestController
@RequestMapping("/v1/personen")
@RequiredArgsConstructor
public class PersonenCommandController {
    private final PersonService personService;
    private final PersonDTOMapper personDTOMapper;
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws PersonenServiceException {

        if(personService.loeschen(id))
            return ResponseEntity.ok().build();

        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> insert(@Valid @RequestBody PersonDTO person, UriComponentsBuilder builder) throws PersonenServiceException{

        personService.speichern(personDTOMapper.convert(person));
        UriComponents uriComponents = builder.path("/v1/personen/{id}").buildAndExpand(person.getId());


        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> update(@Valid  @RequestBody PersonDTO person) throws PersonenServiceException{

        if(personService.aendern(personDTOMapper.convert(person)))
            return ResponseEntity.ok().build();

        else
            return ResponseEntity.notFound().build();
    }
}
