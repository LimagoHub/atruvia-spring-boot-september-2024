package de.atruvia.webapp.persistence;

import de.atruvia.webapp.persistence.entity.PersonEntity;

public interface CustomPersonRepository {

    void persist(PersonEntity person);
}
