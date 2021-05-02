package lt.jurgitavis.persongenerator.init;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.jurgitavis.persongenerator.model.Gender;
import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@SpringBootTest
class MaleNamesInitTest {

	@Autowired
	private PersonNameRepository repository;
	
	@Test
	void testMaleNameListInitialises() {
		assertNotNull(repository.getRandomName(Gender.MALE));
	}

}
