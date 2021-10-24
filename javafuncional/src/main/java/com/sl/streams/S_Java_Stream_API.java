package com.sl.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//Java Stream API
//ref: http://tutorials.jenkov.com/java-functional-programming/streams.html

public class S_Java_Stream_API {

    private static class User
    {
        String id;
        String name;

        public User(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();

        stringList.add("ONE");
        stringList.add("TWO");
        stringList.add("THREE");

        Stream<String> stream = stringList.stream();

        Stream<String> lowerCase = stream.map(value -> { return value.toLowerCase(Locale.ROOT); });

        System.out.println("Value of lowerCase: " + lowerCase.collect(Collectors.toList()));


        // Chaining for create another object

        AtomicReference<Integer> id = new AtomicReference<>(0);
        Stream input = stringList.stream()
            .map((String name) -> {
                id.getAndSet(id.get() + 1);
                return new User(id.toString(), name);
            })
            .map((User user) -> {
                user.setName(user.name.toLowerCase(Locale.ROOT));
                return user;
            });
//            .forEach((User user) -> {
//                System.out.println(String.format("User: %s", user));
//            });
        System.out.println(input.collect(Collectors.toSet()));


    }

}
