package lt.jurgitavis.persongenerator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import lt.jurgitavis.persongenerator.controller.RandomPersonController;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class PersonGeneratorApplicationTests {
	
	@Autowired
	private RandomPersonController controller;	

	@Test
	void contextLoads() {
		assertNotNull(controller);
	}

}
