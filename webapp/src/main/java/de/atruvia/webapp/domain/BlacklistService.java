package de.atruvia.webapp.domain;


import de.atruvia.webapp.domain.model.Person;

public interface BlacklistService {

    boolean isBlacklisted(final Person possibleBlacklistedPerson);
}
