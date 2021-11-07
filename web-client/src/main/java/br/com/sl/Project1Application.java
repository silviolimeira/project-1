package br.com.sl;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
	public WebClient webClient(WebClient.Builder builder) {

		return builder.baseUrl("http://localhost")
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
				.build();

	}

}
