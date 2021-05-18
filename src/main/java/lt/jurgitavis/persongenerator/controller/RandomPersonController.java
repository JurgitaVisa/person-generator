package lt.jurgitavis.persongenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.jurgitavis.persongenerator.model.Person;
import lt.jurgitavis.persongenerator.service.RandomPersonService;

@RestController
@Api(value = "Person")
public class RandomPersonController {
	
	@Autowired
	RandomPersonService randomPersonService;	
	
	
	@GetMapping(value="/person")
	@ApiOperation(value = "Get random person data")
	public Person getRandomPerson() {

		return randomPersonService.getRandomPerson();
	}


}
