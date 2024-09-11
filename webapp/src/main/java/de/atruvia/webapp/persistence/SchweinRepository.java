package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.entity.SchweinEntity;
import de.atruvia.webapp.persistence.entity.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;


import java.util.UUID;



public interface SchweinRepository extends CrudRepository<SchweinEntity, UUID> {
    @RestResource(exported = false)
    void delete(SchweinEntity entity);

    @RestResource(exported = false)
    <S extends SchweinEntity> S save(S entity);
}
