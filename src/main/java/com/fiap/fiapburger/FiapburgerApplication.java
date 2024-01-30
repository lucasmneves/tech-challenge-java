package com.fiap.fiapburger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fiap.fiapburger.infraestructure.persistence.repositories")
public class FiapburgerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FiapburgerApplication.class, args);
	}
}
