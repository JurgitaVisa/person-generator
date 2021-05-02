package lt.jurgitavis.persongenerator;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurnameEndingsConfig {

	@Bean
	public Map<String, String> surnameEndingPairsUnmarried() {
		
		Map<String, String> maleAndFemaleEndingPairs = new LinkedHashMap<>();

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
	
	@Bean
	public Map<String, String> surnameEndingPairsMarried() {
		
		Map<String, String> maleAndFemaleEndingPairsMarried = new LinkedHashMap<>();

		maleAndFemaleEndingPairsMarried.put("ius", "ienė");
		maleAndFemaleEndingPairsMarried.put("jus", "jienė");
		maleAndFemaleEndingPairsMarried.put("us", "ienė");
		maleAndFemaleEndingPairsMarried.put("is", "ienė");
		maleAndFemaleEndingPairsMarried.put("ys", "ienė");
		maleAndFemaleEndingPairsMarried.put("ė", "ienė");
		maleAndFemaleEndingPairsMarried.put("ia", "ienė");
		maleAndFemaleEndingPairsMarried.put("as", "ienė");
		maleAndFemaleEndingPairsMarried.put("a", "ienė");

		return maleAndFemaleEndingPairsMarried;
	}


}
