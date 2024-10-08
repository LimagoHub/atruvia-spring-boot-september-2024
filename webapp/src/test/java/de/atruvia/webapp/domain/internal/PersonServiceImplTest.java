package de.atruvia.webapp.domain.internal;

import de.atruvia.webapp.domain.PersonenServiceException;
import de.atruvia.webapp.domain.mapper.PersonMapper;
import de.atruvia.webapp.domain.model.Person;
import de.atruvia.webapp.persistence.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {
    @InjectMocks
    private PersonServiceImpl objectUnderTest;

    @Mock
    private PersonRepository repoMock;

    @Mock
    private PersonMapper mapperMock;

   /* @Mock
    private BlacklistService blacklistMock;
    */

    @Mock
    private List<String> blacklistMock;

    /*

    @BeforeEach
    void init() {
        repoMock = Mockito.mock(PersonRepository.class);
        mapperMock = Mockito.mock(PersonMapper.class);
        blacklistMock = Mockito.mock(List.class);
        objectUnderTest = new PersonServiceImpl(repoMock,blacklistMock,mapperMock);
    }



     */
    @Test
    @DisplayName("speichern mit leerem Parameter erwartet eine PersonenServiceException")
    void speichernParameterNull() throws Exception {
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(null));
        assertEquals("Parameter darf nicht null sein", ex.getMessage());
    }

    @Test
    void speichern__vorname_is_null__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname(null).nachname("Doe").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Vorname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__vorname_is_to_short__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("J").nachname("Doe").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Vorname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__nachname_is_null__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("John").nachname(null).build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Nachname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__nachname_is_to_short__throws_PersonenServiceException() throws Exception {
        final Person doe = Person.builder().id(null).vorname("John").nachname("D").build();
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(doe));
        assertEquals("Nachname zu kurz", ex.getMessage());
    }

    @Test
    void speichern__unerwuenschte_person__throws_PersonenServiceException() throws Exception {
        final Person attila = Person.builder().id(null).vorname("John").nachname("Doe").build();
        Mockito.when(blacklistMock.contains(Mockito.any())).thenReturn(true);
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(attila));
        assertEquals("Antipath", ex.getMessage());
    }

    @Test
    void speichern__unexpected_Exception_in_underlying_service__throws_PersonenServiceException() throws Exception {
        final Person validPerson = Person.builder().id(null).vorname("John").nachname("Doe").build();
        Mockito.doThrow(ArrayIndexOutOfBoundsException.class).when(repoMock).save(Mockito.any());
        final PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(validPerson));
        assertEquals("Es ist ein Fehler aufgetreten", ex.getMessage());
        assertEquals(ArrayIndexOutOfBoundsException.class, ex.getCause().getClass());
    }
    @Test
    void speichern__Happy__personPassedToRepo() throws Exception {
        final Person validPerson = Person.builder().id(null).vorname("John").nachname("Doe").build();

        objectUnderTest.speichern(validPerson);
        Mockito.verify(mapperMock).convert(validPerson);
    }

}