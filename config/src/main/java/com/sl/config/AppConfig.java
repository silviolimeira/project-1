package com.sl.config;

import com.sl.config.repository.ConfigRepository;
import com.sl.config.service.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// How to create your first Spring Application (without Spring Boot)
// ref: https://www.youtube.com/watch?v=e8aSyQo0nHo
// ref list: https://www.youtube.com/watch?v=e8aSyQo0nHo&list=RDCMUCc98QQw1D-y38wg6mO3w4MQ&start_radio=1&rv=e8aSyQo0nHo&t=1787



@Configuration
@ComponentScan("com.sl")
public class AppConfig {

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
