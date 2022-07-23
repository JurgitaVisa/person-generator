package lt.jurgitavis.persongenerator.model;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Person {
	
	private String name;
	
	private String surname;
	
	private String personalCode;
	
	private String phoneNumber;
	
	private int age;
	
	private LocalDate birthdate;
	
	private Gender gender;
	
	private String citizenship;

}
