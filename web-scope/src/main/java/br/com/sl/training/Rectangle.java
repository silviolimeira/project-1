package br.com.sl.training;

import org.springframework.stereotype.Component;

@Component
class Rectangle implements Shape {

    @Override
    public void area(int x, int y) {
        System.out.println("rectangle " + (x * y));
    }
}
