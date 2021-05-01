# Random Lithuanian Person data generator
 
Developed system returns following Lithuanian person data in json format: Name, Surname, LT Personal code, Phone number, Age, Birthdate, Gender, Citizenship.

![Preview](images/random-person.jpg)

#### Technologies used: 
- Spring Boot 2.4.5, 
- Java 11
- Swagger-UI, Maven

## Getting Started

- Clone the repository `git clone https://github.com/JurgitaVisa/person-generator.git`

### Run with Maven 

- go to project folder `cd {yourPathToFolder}/person-generator`
- Run `mvn spring-boot:run` (application will start on port 8080)  

http://localhost:8080/person

### Running the application with Executable JAR 

The code can also be built into a jar and then executed/run. 
Once the jar is built `person-generator.jar` file will appear in the `{yourPathToFolder}\person-generator\target` folder.
Run the jar by double clicking on it or by using the command provided.

```shell
$ cd {yourPathToFolder}/person-generator
$ mvn package -DskipTests
$ java -jar target/person-generator.jar --spring.profiles.active=test
```
To stop the jar run the following:
```shell
$ netstat -ano | find "8080"
$ taskkill /F /PID <yourprocessID>
```

### Accessing API documentation

http://localhost:8080/swagger-ui/

## Author

Copyright&copy; 2021, JurgitaVisa