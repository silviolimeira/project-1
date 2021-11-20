package com.sl.patterns.creational.singleton;

class SingletonEager {
    private static SingletonEager instance = new SingletonEager();

    private SingletonEager(){}

    public static SingletonEager getInstance() {
        return instance;
    }
}

class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}

class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    private SingletonSynchronizedMethod(){}

    public static synchronized SingletonSynchronizedMethod getInstance() {
        if(instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized(){}

    public static SingletonSynchronized getInstance() {
        if(instance == null) {
            synchronized (SingletonSynchronized.class) {
                if(instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

/*
Singleton Design pattern - Properties

- Creational design pattern
- Only one instance of the class should exist
- Other classes should be able to get instance of Singleton class
- Used in Logging, Cache, Session, Drivers

# Implementation
    - Constructor should be private
    - Public method for returning instance
    - Instance type - private static

    Initialization Type:
        - Eager Initialization
        - Lazy Initialization
        - Thread safe Method to Initialization
        - Thread save block Initialization

*/

public class SingletonExample {

    public static void main(String[] args) {

        SingletonSynchronized instance = SingletonSynchronized.getInstance();

        System.out.println(instance);

        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();

        System.out.println(instance1);
    }
}