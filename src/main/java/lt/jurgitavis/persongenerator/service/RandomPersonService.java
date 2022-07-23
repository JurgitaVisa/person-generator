package lt.jurgitavis.persongenerator.service;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.jurgitavis.persongenerator.model.Gender;
import lt.jurgitavis.persongenerator.model.Person;
import lt.jurgitavis.persongenerator.repository.PersonNameRepository;

@Service
public class RandomPersonService {

    private final String DEFAULT_CITIZENSHIP = "Lithuanian";
    private final String LT_PHONE_PREFIX = "+370 6";
    private final LocalDate MAX_BIRTHDATE = LocalDate.now();
    private final LocalDate MIN_BIRTHDATE = LocalDate.now().minusYears(100);

    @Autowired
    private PersonNameRepository nameRepository;

    @Autowired
    private Map<String, String> surnameEndingPairsUnmarried;

    @Autowired
    private Map<String, String> surnameEndingPairsMarried;


    public Person getRandomPerson() {
        Person randomPerson = new Person();

        LocalDate birthdate = generateRandomBirthdate();
        Gender gender = getRandomGender();
        int age = calculateAge(birthdate);

        randomPerson.setName(nameRepository.getRandomName(gender));
        randomPerson.setSurname(getSurname(gender, age));
        randomPerson.setPersonalCode(generateLtPersonalCode(gender, birthdate));
        randomPerson.setPhoneNumber(generatePhoneNumber());
        randomPerson.setAge(age);
        randomPerson.setBirthdate(birthdate);
        randomPerson.setGender(gender);
        randomPerson.setCitizenship(DEFAULT_CITIZENSHIP);

        return randomPerson;
    }

    /**
     * Gets random person surname from repository. Modifies according to gender and
     * age
     */
    private String getSurname(Gender gender, int age) {
        String maleSurname = nameRepository.getRandomSurname();

        if (gender.equals(Gender.MALE)) {
            return maleSurname;

        } else if (age < 18) {
            return createNonMariedFemaleSurname(maleSurname);

        } else {

            if (new Random().nextBoolean()) {
                return createNonMariedFemaleSurname(maleSurname);

            } else {
                return createMariedFemaleSurname(maleSurname);
            }
        }

    }

    /**
     * Creates female surname of a married Lithuanian woman using default
     * male-to-female ending replacement. If given male surname does not exist in
     * default male surname endings list, returns male surname instead.
     */
    protected String createMariedFemaleSurname(String maleSurname) {

        for (String key : surnameEndingPairsMarried.keySet()) {

            if (maleSurname.endsWith(key)) {

                return replaceSurnameEnding(maleSurname, key, surnameEndingPairsMarried.get(key));
            }
        }

        return maleSurname;
    }

    /**
     * Creates female surname of a non-married Lithuanian woman from default
     * male-to-female ending replacement map pairs. If given pair does not egsist,
     * returns male surname instead.
     */
    protected String createNonMariedFemaleSurname(String maleSurname) {

        for (String key : surnameEndingPairsUnmarried.keySet()) {

            if (maleSurname.endsWith(key)) {

                return replaceSurnameEnding(maleSurname, key, surnameEndingPairsUnmarried.get(key));
            }
        }

        return maleSurname;
    }

    /**
     * Replaces current surname ending with given replacement
     */
    private String replaceSurnameEnding(String maleSurname, String ending, String replacement) {
        StringBuilder femaleSurname = new StringBuilder(maleSurname);

        int indexOfEnding = maleSurname.lastIndexOf(ending);

        femaleSurname.replace(indexOfEnding, (indexOfEnding + ending.length()), replacement);

        return femaleSurname.toString();
    }

    /**
     * Calculates persons age by birthdate
     */
    private int calculateAge(LocalDate birthdate) {

        return (int) ChronoUnit.YEARS.between(birthdate, LocalDate.now());
    }

    private String generatePhoneNumber() {

        return LT_PHONE_PREFIX +
                convertToFormatedString("0000000", new Random().nextInt(10000000));
    }

    /**
     * Generates LT personal code in accordance with established legal rules
     */
    protected String generateLtPersonalCode(Gender gender, LocalDate birthdate) {

        return getFirstDigitOfPersonalCode(gender, birthdate.getYear()) +
                convertToFormatedString("00", birthdate.getYear() % 100) +
                convertToFormatedString("00", birthdate.getMonthValue()) +
                convertToFormatedString("00", birthdate.getDayOfMonth()) +
                (1000 + new Random().nextInt(10000 - 1000));
    }

    private String convertToFormatedString(String format, int randomNumber) {

        DecimalFormat numberFormat = new DecimalFormat(format);

        return numberFormat.format(randomNumber);
    }

    /**
     * Returns first number of Personal code in accordance with established legal
     * rules
     */
    private int getFirstDigitOfPersonalCode(Gender gender, int yearOfBirth) {

        if (gender.equals(Gender.MALE)) {
            if (yearOfBirth >= 2000) {
                return 5;
            } else {
                return 3;
            }
        } else {
            if (yearOfBirth >= 2000) {
                return 6;
            } else {
                return 4;
            }
        }

    }

    private Gender getRandomGender() {

        if (new Random().nextBoolean()) {
            return Gender.MALE;
        } else {
            return Gender.FEMALE;
        }
    }


    private LocalDate generateRandomBirthdate() {

        long minDay = MIN_BIRTHDATE.toEpochDay();
        long maxDay = MAX_BIRTHDATE.toEpochDay();
        long randomDay = minDay + (long) (Math.random() * (maxDay - minDay));

        return LocalDate.ofEpochDay(randomDay);
    }

}
