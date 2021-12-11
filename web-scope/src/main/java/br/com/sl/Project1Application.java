package br.com.sl;


import br.com.sl.model.Employee;
import br.com.sl.training.Shape;
import br.com.sl.training.ShapeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
@Configuration
//@ComponentScan(basePackages = "br.com.sl")
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableScheduling
public class Project1Application {

	public static void main(String[] args) {

		SpringApplication.run(Project1Application.class, args);

	}

	@Autowired
	ApplicationContext context;

    @Autowired
	ShapeFactory factory;

	@PostConstruct
	public void postConstruct() {
		Employee emp = context.getBean(Employee.class);
		System.out.println(emp);
		emp.setName("Rohan");
		System.out.println(emp);

		Employee emp1 = context.getBean(Employee.class);
		System.out.println(emp1);

        System.out.println("Training App");
        factory.printArea("T", 10, 20);
		factory.printArea("T", 10, 20);
        factory.printArea("R", 10, 20);
		factory.printArea( "R", 10, 20);
	}

//	@PostConstruct
//	public void batch() {
//		//QuartzExample.test();
//		//System.out.println("Database name: " + Config.getDB(1));
//		//Config.testPersonDAO();
//		//JpaExample.test();
//	}

	@PreDestroy
	public void preDestroy() {

	}


//	@Bean
//	CommandLineRunner run(UserService userService) {
//
//		System.out.println("T");
//
//		return args -> {
//
//			//String email, String password, String firstName, String lastName
//			userService.saveUser(new User("silvio@mail.com.br","1234","Silvio","Limeira"));
//
//		};
//
//	}


}
