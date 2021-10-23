package com.sl.imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Teste imperative !");
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("ALex", Gender.MALE),
                new Person("Acile", Gender.FEMALE)
        );

        // Imperative approach
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        // Declarative approach

        people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        System.out.println("\n\n// Declarative approach\n");
        List<Person> females1 = new ArrayList<>();

        females1 = people.stream()
                .filter(person -> Gender.FEMALE.equals(person.gender))
                .collect(Collectors.toList());

        System.out.println("Females1: " + females);

        List<Person> males = new ArrayList<>();


        Predicate<Person> personPredicate = person -> Gender.MALE.equals(person.gender);

        males = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());

        System.out.println("\n==> Males: " + males);


    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Gender getGender() {
            return gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {

        MALE("M"), FEMALE("F");

        private final String value;

        private Gender(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}

