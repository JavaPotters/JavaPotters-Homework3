package com.ironhacker.JavaPottersHomework3;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;


@SpringBootApplication
//@Profile("!test")
public class JavaPottersHomework3Application implements CommandLineRunner {
	@Autowired
	private MainMenu mainMenu;
	public static void main(String[] args) {
		SpringApplication.run(JavaPottersHomework3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// System.out.println("Hello world");
		mainMenu.main();
	}
}

