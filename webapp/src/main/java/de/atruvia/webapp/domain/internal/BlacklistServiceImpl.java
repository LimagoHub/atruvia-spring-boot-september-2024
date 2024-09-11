package de.atruvia.webapp.domain.internal;

import de.atruvia.webapp.aspects.Dozent;
import de.atruvia.webapp.domain.BlacklistService;
import de.atruvia.webapp.domain.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlacklistServiceImpl implements BlacklistService {

    private final List<Person> blacklist = List.of(Person.builder().vorname("Attila").build(), Person.builder().vorname("Peter").build());

   @Dozent
    @Override
    public boolean isBlacklisted(final Person possibleBlacklistedPerson) {
        return blacklist.stream().anyMatch(p->p.getVorname().equals(possibleBlacklistedPerson.getVorname()));
    }
}
