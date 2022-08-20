package lt.jurgitavis.persongenerator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt.jurgitavis.persongenerator.model.Person;
import lt.jurgitavis.persongenerator.service.RandomPersonService;

import java.util.List;

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

	@GetMapping(value="/person/{count}")
	@ApiOperation(value = "Get list of random persons")
	public List<Person> getRandomPersonList(@PathVariable int count) {
		return randomPersonService.getListOfRandomPersons(count);
	}
}
