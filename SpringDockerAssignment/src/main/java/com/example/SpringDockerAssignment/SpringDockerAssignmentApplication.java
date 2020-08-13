package com.example.SpringDockerAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.SpringDockerAssignment")
public class SpringDockerAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDockerAssignmentApplication.class, args);
	}

}
