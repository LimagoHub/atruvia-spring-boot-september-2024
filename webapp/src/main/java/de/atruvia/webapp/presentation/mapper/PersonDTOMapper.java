package de.atruvia.webapp.presentation.mapper;


import de.atruvia.webapp.domain.model.Person;
import de.atruvia.webapp.presentation.dto.PersonDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonDTOMapper {
    PersonDTO convert(Person person);
    Person convert(PersonDTO personDto);

    Iterable<PersonDTO> convert(Iterable<Person> personen);
}
