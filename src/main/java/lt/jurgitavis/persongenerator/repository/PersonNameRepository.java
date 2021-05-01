package lt.jurgitavis.persongenerator.repository;

import lt.jurgitavis.persongenerator.model.Gender;

public interface PersonNameRepository {	
	
	String getRandomName(Gender gender);

	String getRandomSurname();
	
	void saveFemaleName(String femaleName);	
	
	void saveMaleName(String maleName);
		
	void saveMaleSurname(String maleSurname);	

}
