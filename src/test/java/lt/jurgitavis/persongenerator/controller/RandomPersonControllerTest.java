package lt.jurgitavis.persongenerator.controller;

import lt.jurgitavis.persongenerator.PersonGeneratorApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = { PersonGeneratorApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RandomPersonControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testGetRandomPersonGetMapping() throws Exception {
	MvcResult result= mvc.perform(get("/person")).andExpect(status().isOk()).andReturn();
	
	assertEquals(200, result.getResponse().getStatus());

	}

}
