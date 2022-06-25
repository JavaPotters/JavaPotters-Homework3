package com.ironhacker.JavaPottersHomework3;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication
public class JavaPottersHomework3Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaPottersHomework3Application.class, args);
	}

}

/*@SpringBootApplication
public class JavaPottersHomework3Application implements CommandLineRunner {
	//private static Logger LOG = (Logger) LoggerFactory.getLogger(JavaPottersHomework3Application.class);
	public static void main(String[] args) {
		//LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(JavaPottersHomework3Application.class, args);
		//LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world");
		//LOG.info("EXECUTING : command line runner");
		/*for (int i = 0; i < args.length; ++i) {
			LOG.info("args[{}]: {}", i, args[i]);
		}
	}
			}
			*/
