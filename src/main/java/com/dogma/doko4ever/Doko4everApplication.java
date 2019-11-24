package com.dogma.doko4ever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.dogma.doko4ever" })
public class Doko4everApplication {

	public static void main(String[] args) {
		SpringApplication.run(Doko4everApplication.class, args);

		// TODO auto testing, login spring-security, jms queueing Apache ActiveMQ,
		// spring-batch, json
		// microservice
	}

}
