package com.sl.patterns.creational.builder;

class Vehicle {
    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return this.engine;
    }

    public int getWheel() {
        return this.wheel;
    }

    public int getAirbags() {
        return this.airbags;
    }

    private Vehicle(VehicleBuilder builder) {
        this.engine = builder.engine;
        this.wheel = builder.wheel;
        this.airbags = builder.airbags;
    }

    public static class VehicleBuilder {
        private String engine;
        private int wheel;

        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;  // this return allow chaining multiple set's with dot
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}

/*
Builder Design pattern - Properties

- Creational design pattern
- Used when we have too many arguments to send in Constructor & it's
  hard to maintain the order.
- When we don't want to send all parameters in Object initialization
  (Generally we send optional parameters as Null)

* Implementation

- We create a 'VehicleBuilder static nested class', which contains all
  arguments of outer class.
- As per naming convention, if class name is 'Vehicle', builder class
  should be 'VehicleBuilder'
- Builder class have a public constructor with all required parameters.
- Builer class should have methods for optional parameters. Method
  will return the Builder object.
- A 'build()' method that will return the final Object.
- The main class 'Vehicle' has private constructor so to create instance
  only via Builder class.
- The main class 'Vehicle' has only getters.

*/

public class BuilderExample {

    public static void main(String[] args) {

        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheel());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheel());
        System.out.println(bike.getAirbags());
    }
}
