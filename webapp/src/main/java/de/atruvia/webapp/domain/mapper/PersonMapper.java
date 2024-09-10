package de.atruvia.webapp.domain.mapper;

import de.atruvia.webapp.domain.model.Person;
import de.atruvia.webapp.persistence.entity.PersonEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    Person convert(PersonEntity entity);
    PersonEntity convert(Person person);
    Iterable<Person> convert(Iterable<PersonEntity> entities);
}
