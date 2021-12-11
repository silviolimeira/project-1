package br.com.sl.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Table;

@Component
@Scope("prototype")
public class Employee {

    String name;

    public Employee() {
        System.out.println("One Employee object created...");
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Value("Raju")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
