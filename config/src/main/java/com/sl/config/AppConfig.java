package com.sl.config;

import com.sl.config.repository.ConfigRepository;
import com.sl.config.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// How to create your first Spring Application (without Spring Boot)
// ref: https://www.youtube.com/watch?v=e8aSyQo0nHo
// ref list: https://www.youtube.com/watch?v=e8aSyQo0nHo&list=RDCMUCc98QQw1D-y38wg6mO3w4MQ&start_radio=1&rv=e8aSyQo0nHo&t=1787

// TODO:  JdbcTemplate
// ref https://www.journaldev.com/17053/spring-jdbctemplate-example

@Configuration
@ComponentScan("com.sl")
@PropertySource("classpath:database.properties")
public class AppConfig {

    @Autowired
    Environment environment;

    private final String URL = "url";
    private final String USER = "dbuser";
    private final String DRIVER = "driver";
    private final String PASSWORD = "dbpassword";

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setUrl(environment.getProperty(URL));
        driverManagerDataSource.setUsername(environment.getProperty(USER));
        driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
        driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
        return driverManagerDataSource;
    }

//    @Bean("configRepository")
//    public ConfigRepository getConfigRepository() {
//        return new ConfigRepository();
//    }
//
//    @Bean("configService")
//    public ConfigService getCourseService() {
//        return new ConfigService(getConfigRepository());
//    }
}
