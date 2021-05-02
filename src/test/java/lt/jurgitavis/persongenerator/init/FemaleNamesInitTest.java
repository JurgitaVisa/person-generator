package lt.jurgitavis.persongenerator.init;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.jurgitavis.persongenerator.model.Gender;
import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@SpringBootTest
class FemaleNamesInitTest {
	
	@Autowired
	private PersonNameRepository repository;

	@Test
	void testFemaleNameListInitialises() {
		assertNotNull(repository.getRandomName(Gender.FEMALE));
	}

}
