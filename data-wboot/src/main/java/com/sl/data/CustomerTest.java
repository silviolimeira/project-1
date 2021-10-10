package com.sl.data;


import com.sl.data.service.CustomerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CustomerTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sl.data");
        appContext.refresh();

        CustomerService customerService = (CustomerService) appContext.getBean("customerService");
        customerService.test();

        appContext.close();
    }

    public static void test() {

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sl.data");
        appContext.refresh();

        CustomerService customerService = (CustomerService) appContext.getBean("customerService");
        customerService.test();

        appContext.close();

    }

}
