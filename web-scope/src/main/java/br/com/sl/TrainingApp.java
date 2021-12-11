//package br.com.sl;
//
//import br.com.sl.training.ShapeFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//import javax.swing.*;
//@SpringBootApplication
//public class TrainingApp implements CommandLineRunner {
//
//
//    public static void main(String[] args) {
//        SpringApplication.run(TrainingApp.class, args);
//    }
//
//    @Autowired
//    ShapeFactory factory;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("Training App");
//        factory.printArea("T", 10, 20);
//        factory.printArea("R", 10, 20);
//    }
//}
