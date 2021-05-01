package lt.jurgitavis.persongenerator.model;

import java.time.LocalDate;

/**
 * Model for Perosn data
 *
 */
public class Person {
	
	private String name;
	
	private String surname;
	
	private String personalCode;
	
	private String phoneNumber;
	
	private int age;
	
	private LocalDate birthdate;
	
	private Gender gender;
	
	private String citizenship;	

	public Person() {
		
	}	

	public Person(String name, String surname, String personalCode, String phoneNumber, int age,
			LocalDate birthdate, Gender gender, String citizenship) {
		super();
		this.name = name;
		this.surname = surname;
		this.personalCode = personalCode;
		this.phoneNumber = phoneNumber;
		this.age = age;
		this.birthdate = birthdate;
		this.gender = gender;
		this.citizenship = citizenship;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPersonalCode() {
		return personalCode;
	}

	public void setPersonalCode(String personalCode) {
		this.personalCode = personalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getCitizenship() {
		return citizenship;
	}

	public void setCitizenship(String citizenship) {
		this.citizenship = citizenship;
	}
	
	

}
