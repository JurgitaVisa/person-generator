package lt.jurgitavis.persongenerator.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Repository;

import lt.jurgitavis.persongenerator.model.Gender;

/**
 * 
 * In memory repository of Lithuanian names and surnames
 *
 */
@Repository
public class InMemoryPersonNameRepository implements PersonNameRepository {

	private final List<String> femaleNames = new ArrayList<>();	

	private final List<String> maleNames = new ArrayList<>();

	private final List<String> maleSurnames = new ArrayList<>();

	@Override
	public String getRandomName(Gender gender) {

		if (gender.equals(Gender.MALE)) {
			return maleNames.get(new Random().nextInt(maleNames.size()));
		} else {
			return femaleNames.get(new Random().nextInt(femaleNames.size()));
		}
	}

	@Override
	public String getRandomSurname() {

		return maleSurnames.get(new Random().nextInt(maleSurnames.size()));

	}

	@Override
	public void saveFemaleName(String femaleName) {
		this.femaleNames.add(femaleName);
	}

	@Override
	public void saveMaleName(String maleName) {
		this.maleNames.add(maleName);
	}

	@Override
	public void saveMaleSurname(String maleSurname) {
		this.maleSurnames.add(maleSurname);
	}

}
