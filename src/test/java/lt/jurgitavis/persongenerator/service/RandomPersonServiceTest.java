package lt.jurgitavis.persongenerator.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.jurgitavis.persongenerator.model.Gender;
import lt.jurgitavis.persongenerator.model.Person;

@SpringBootTest
class RandomPersonServiceTest {
    @Autowired
    RandomPersonService service;

    @Test
    void testAllFieldsHaveValues() {
        Person person = service.getRandomPerson();

        assertNotNull(person.getName());
        assertNotNull(person.getSurname());
        assertNotNull(person.getPersonalCode());
        assertNotNull(person.getPhoneNumber());
        assertNotNull(person.getBirthdate());
        assertNotNull(person.getGender());
        assertNotNull(person.getCitizenship());
        assertNotNull(person.getEmail());
    }

    @Test
    void testCorrectNumberOfEntriesIsReturned() {
        List<Person> randomPersons = service.getListOfRandomPersons(5);
        assertEquals(5, randomPersons.size());
    }

    @Test
    void testBirthdateIsLessThanHundredYearAgo() {
        assertTrue(service.getRandomPerson().getBirthdate().isAfter(LocalDate.now().minusYears(100)));
    }

    @Test
    void testPhoneNumberIsOfCorrectLength() {
        assertEquals(13, service.getRandomPerson().getPhoneNumber().length());
    }

    @Test
    void testPhoneNumberHasLTprefix() {
        assertTrue(service.getRandomPerson().getPhoneNumber().startsWith("+370 6"));
    }

    @Test
    void emailMatchesPattern() {
        String regexPattern = "[a-z.]+@domain.lt";
        String email = service.getRandomPerson().getEmail();

        assertTrue(Pattern.compile(regexPattern)
                .matcher(email)
                .matches());
    }

    @Test
    void testPersonHasLithuanianCitizenship() {
        assertEquals("Lithuanian", service.getRandomPerson().getCitizenship());
    }

    @Test
    void testServiceCreatesCorrectMarriedFemaleSurnames() {
        assertEquals("Viusakavičienė", service.createMariedFemaleSurname("Viusakavičius"));
        assertEquals("Ajustajienė", service.createMariedFemaleSurname("Ajustajus"));
        assertEquals("Tustauskienė", service.createMariedFemaleSurname("Tustauskus"));
        assertEquals("Miskinienė", service.createMariedFemaleSurname("Miskinis"));
        assertEquals("Gaidienė", service.createMariedFemaleSurname("Gaidys"));
        assertEquals("Krėgždienė", service.createMariedFemaleSurname("Krėgždė"));
        assertEquals("Strialienė", service.createMariedFemaleSurname("Strialia"));
        assertEquals("Čižasauskienė", service.createMariedFemaleSurname("Čižasauskas"));
        assertEquals("Lydakienė", service.createMariedFemaleSurname("Lydaka"));

    }

    @Test
    void testServiceCreatesCorrectUnmarriedFemaleSurnames() {
        assertEquals("Viusakavičiūtė", service.createNonMariedFemaleSurname("Viusakavičius"));
        assertEquals("Ajustajūtė", service.createNonMariedFemaleSurname("Ajustajus"));
        assertEquals("Tustauskutė", service.createNonMariedFemaleSurname("Tustauskus"));
        assertEquals("Miskinytė", service.createNonMariedFemaleSurname("Miskinis"));
        assertEquals("Gaidytė", service.createNonMariedFemaleSurname("Gaidys"));
        assertEquals("Krėgždytė", service.createNonMariedFemaleSurname("Krėgždė"));
        assertEquals("Strolytė", service.createNonMariedFemaleSurname("Strolia"));
        assertEquals("Čižasauskaitė", service.createNonMariedFemaleSurname("Čižasauskas"));
        assertEquals("Lydakaitė", service.createNonMariedFemaleSurname("Lydaka"));

    }

    @Test
    void testPersonalCodeIsOfCorrectLength() {
        assertEquals(11, service.getRandomPerson().getPersonalCode().length());
    }

    @Test
    void testServiceCreatesCorrectPersonalCode() {
        assertTrue(service.generateLtPersonalCode(Gender.MALE, LocalDate.of(1981, 11, 01)).startsWith("3811101"));
        assertTrue(service.generateLtPersonalCode(Gender.FEMALE, LocalDate.of(1960, 03, 15)).startsWith("4600315"));
        assertTrue(service.generateLtPersonalCode(Gender.MALE, LocalDate.of(2000, 02, 01)).startsWith("5000201"));
        assertTrue(service.generateLtPersonalCode(Gender.FEMALE, LocalDate.of(2012, 12, 06)).startsWith("6121206"));
    }

}
