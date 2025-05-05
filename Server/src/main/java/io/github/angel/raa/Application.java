package io.github.angel.raa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final String API_VERSION = "/api/v1";


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
