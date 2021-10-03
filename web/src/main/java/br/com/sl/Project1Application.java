package br.com.sl;


import com.sl.batch.QuartzExample;
import com.sl.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@PostConstruct
	public void batch() {
		//QuartzExample.test();
		//System.out.println("Database name: " + Config.getDB(1));
		Config.testPersonDAO();
	}

	@PreDestroy
	public void preDestroy() {

	}

}
