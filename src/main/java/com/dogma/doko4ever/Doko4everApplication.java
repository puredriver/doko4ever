package com.dogma.doko4ever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.dogma.doko4ever.repository")
@EntityScan(basePackages = { "com.dogma.doko4ever.model" })
public class Doko4everApplication {

	public static void main(String[] args) {
		SpringApplication.run(Doko4everApplication.class, args);

		// TODO auto testing, login spring-security, jms queueing Apache ActiveMQ,
		// spring-batch, json
		// microservice
	}

}
