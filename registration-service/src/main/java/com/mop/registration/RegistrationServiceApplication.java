package com.mop.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.mop.registration.controller", "com.mop.registration.service"})
@EntityScan("com.mop.registration.entity")
@EnableJpaRepositories("com.mop.registration.repository")
public class RegistrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistrationServiceApplication.class, args);
	}
}
