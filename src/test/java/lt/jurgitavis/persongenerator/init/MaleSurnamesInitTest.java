package lt.jurgitavis.persongenerator.init;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@SpringBootTest
class MaleSurnamesInitTest {
	
	@Autowired
	private PersonNameRepository repository;

	@Test
	void testMaleSurnameListInitialises() {
		assertNotNull(repository.getRandomSurname());
	}

}
