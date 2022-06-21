package com.ironhacker.JavaPottersHomework3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaPottersHomework3Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JavaPottersHomework3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");
	}
}
