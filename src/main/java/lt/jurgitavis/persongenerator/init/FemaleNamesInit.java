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
public class FemaleNamesInit {
	
	@Autowired
	PersonNameRepository repository;
	
	@PostConstruct
	public void uploadFemaleNames() throws IOException {
		
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("female_names.txt");

		try (BufferedReader reader = new BufferedReader(
				new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String name;
			
			while ((name = reader.readLine()) != null) {
				repository.saveFemaleName(name);
			}	
			
		}
	}

}
