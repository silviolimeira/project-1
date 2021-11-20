package br.com.sl;


import br.com.sl.entity.User;
import br.com.sl.service.UserService;
import com.sl.batch.QuartzExample;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;

@SpringBootApplication
//@Configuration
//@ComponentScan(basePackages = "br.com.sl")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class Project1Application {

	public static void main(String[] args) {
		SpringApplication.run(Project1Application.class, args);
	}

	@PostConstruct
	public void batch() {
		//QuartzExample.test();
		//System.out.println("Database name: " + Config.getDB(1));
		//Config.testPersonDAO();
		//JpaExample.test();
	}

	@PreDestroy
	public void preDestroy() {

	}


	@Bean
	CommandLineRunner run(UserService userService) {

		System.out.println("T");

		return args -> {

			//String email, String password, String firstName, String lastName
			userService.saveUser(new User("silvio@mail.com.br","1234","Silvio","Limeira"));

		};

	}


}
