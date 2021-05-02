package lt.jurgitavis.persongenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class PersonGeneratorApplication extends SpringBootServletInitializer {

	private static String DATA_URI = "https://opendata.ecdc.europa.eu/covid19/nationalcasedeath/json/";

	public static void main(String[] args) {
		SpringApplication.run(PersonGeneratorApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PersonGeneratorApplication.class);
	}

	/**
	 * Docket for REST documentation
	 */
	@Bean
	public Docket swaggerDocket() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("lt.jurgitavis")).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Random person generator -- REST documentation").version("0.0.1-SNAPSHOT")
				.build();
	}
	

}
