package de.atruvia.webapp.persistence;


import de.atruvia.webapp.persistence.entity.PersonEntity;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomPersonRepositoryImpl implements CustomPersonRepository {

    @Autowired
    private EntityManager em;

    @Override
    public void persist(final PersonEntity person) {
        em.persist(person);
    }
}
