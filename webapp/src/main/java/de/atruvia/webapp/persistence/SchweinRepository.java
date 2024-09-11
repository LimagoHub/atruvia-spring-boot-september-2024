package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.entity.SchweinEntity;
import de.atruvia.webapp.persistence.entity.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface SchweinRepository extends CrudRepository<SchweinEntity, UUID> {


}
