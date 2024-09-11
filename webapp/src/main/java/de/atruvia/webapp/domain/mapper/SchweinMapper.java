package de.atruvia.webapp.domain.mapper;

import de.atruvia.webapp.domain.model.Person;
import de.atruvia.webapp.domain.model.Schwein;
import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.entity.SchweinEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinMapper {

    Schwein convert(SchweinEntity entity);
    SchweinEntity convert(Schwein schwein);
    Iterable<Schwein> convert(Iterable<SchweinEntity> entities);
}
