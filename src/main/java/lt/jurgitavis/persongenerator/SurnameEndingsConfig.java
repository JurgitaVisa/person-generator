package lt.jurgitavis.persongenerator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurnameEndingsConfig {

	@Bean
	public Map<String, String> surnameEndingPairs() {
		
		Map<String, String> maleAndFemaleEndingPairs = new HashMap<>();

		maleAndFemaleEndingPairs.put("ius", "iūtė");
		maleAndFemaleEndingPairs.put("jus", "jūtė");
		maleAndFemaleEndingPairs.put("us", "utė");
		maleAndFemaleEndingPairs.put("is", "ytė");
		maleAndFemaleEndingPairs.put("ys", "ytė");
		maleAndFemaleEndingPairs.put("ė", "ytė");
		maleAndFemaleEndingPairs.put("ia", "ytė");
		maleAndFemaleEndingPairs.put("as", "aitė");
		maleAndFemaleEndingPairs.put("a", "aitė");

		return maleAndFemaleEndingPairs;
	}


}
