package com.codingshuttle.restpractice.restPractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestPracticeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RestPracticeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello! This is for REST api practice");
	}
}
