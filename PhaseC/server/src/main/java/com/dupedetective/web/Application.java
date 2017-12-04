package com.dupedetective.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * Spring boot Application Main
 */
@SpringBootApplication
@CrossOrigin("*")
public class Application {

	/**
	 * Start the Application server
	 * @param args arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
