package lt.jurgitavis.persongenerator.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@Component
public class MaleSurnamesInit {
	@Autowired
	PersonNameRepository repository;
	
	@PostConstruct
	public void uploadFemaleNames() throws IOException {
		
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("male_surnames.txt");

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String surname;
			
			while ((surname = reader.readLine()) != null) {
				repository.saveMaleSurname(surname);
			}	
			
		}
	}

}
