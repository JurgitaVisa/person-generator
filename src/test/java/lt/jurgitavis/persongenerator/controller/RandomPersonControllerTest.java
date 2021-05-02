package lt.jurgitavis.persongenerator.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.jayway.restassured.RestAssured;

import lt.jurgitavis.persongenerator.PersonGeneratorApplication;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = { PersonGeneratorApplication.class }, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RandomPersonControllerTest {
	
	@Value("${local.server.port}")
	int port;
	
	@Autowired
	private MockMvc mvc;

	@BeforeAll
	public void setUp() throws Exception {
		RestAssured.port = port;
	}
	
	@Test
	public void testGetRandomPersonGetMapping() throws Exception {
	MvcResult result= mvc.perform(get("/person")).andExpect(status().isOk()).andReturn();
	
	assertEquals(200, result.getResponse().getStatus());

	}

}
