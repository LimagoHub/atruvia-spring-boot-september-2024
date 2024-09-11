package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.PersonEntity;
import de.atruvia.webapp.persistence.entity.TinyPerson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PersonRepository extends CrudRepository<PersonEntity, UUID>, CustomPersonRepository {

    Iterable<PersonEntity> findByVorname(String vorname);

    @Query("select p.vorname, p.nachname from PersonEntity p")
    Iterable<Object[]> xyz();

    @Query("select new de.atruvia.webapp.persistence.entity.TinyPerson(p.id, p.nachname) from PersonEntity p")
    Iterable<TinyPerson> findAllTinyPersons();

    @Query("update PersonEntity p set p.vorname=:vorname where p.id=:id")
    void updateVorname(UUID id, String vorname);
}
