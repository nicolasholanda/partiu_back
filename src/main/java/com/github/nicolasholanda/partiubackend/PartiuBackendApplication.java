package com.github.nicolasholanda.partiubackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PartiuBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(PartiuBackendApplication.class, args);
	}

}
