package com.sl.patterns.creational.prototype;

import java.util.ArrayList;
import java.util.List;

class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<String>();
    }

    public Vehicle(List<String> list) {
        this.vehicleList = list;
    }

    public void insertData() {
        vehicleList.add("Honda amaze");
        vehicleList.add("Audi A4");
        vehicleList.add("Hyundai Creta");
        vehicleList.add("Maruti Baleno");
        vehicleList.add("Renault Duster");
    }

    public List<String> getVehicleList() {
        return this.vehicleList;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<String>();

        for(String s : this.getVehicleList()) {
            tempList.add(s);
        }

        return new Vehicle(tempList);
    }
}

public class PrototypeExample {


    /*
    Prototype Design pattern

    - Creational design pattern
    - Used when you want to avoid multiple Object creation of same
      instance; instead you copy the object to new object & then we can
      modify as per our need

    - Object which we're copying should provide copying feature by
      implementing Cloneable interface
    - we can override clone() method to implement as per our need




     */
    public static void main(String[] args) throws CloneNotSupportedException {

        Vehicle a = new Vehicle();
        a.insertData();

        Vehicle b = (Vehicle) a.clone();
        List<String> list = b.getVehicleList();
        list.add("Honda new Amaze");

        System.out.println(a.getVehicleList());
        System.out.println(list);

        b.getVehicleList().remove("Audi A4");
        System.out.println(list);
        System.out.println(a.getVehicleList());

    }
}
