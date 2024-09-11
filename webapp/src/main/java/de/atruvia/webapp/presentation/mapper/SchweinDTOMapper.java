package de.atruvia.webapp.presentation.mapper;


import de.atruvia.webapp.domain.model.Person;
import de.atruvia.webapp.domain.model.Schwein;
import de.atruvia.webapp.presentation.dto.PersonDTO;
import de.atruvia.webapp.presentation.dto.SchweinDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchweinDTOMapper {
    SchweinDTO convert(Schwein schwein);
    Schwein convert(SchweinDTO schweinDto);

    Iterable<SchweinDTO> convert(Iterable<Schwein> schweine);
}
