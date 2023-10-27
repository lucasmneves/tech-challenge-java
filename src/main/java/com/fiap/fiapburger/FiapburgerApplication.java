package com.fiap.fiapburger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import static java.lang.System.out;

@SpringBootApplication
public class FiapburgerApplication {
	public static void main(String[] args) {
		SpringApplication.run(FiapburgerApplication.class, args);
	}

}
