package br.com.sl.training;

import org.springframework.stereotype.Component;

@Component
public class Triangle implements Shape {

    @Override
    public void area(int x, int y) {
        System.out.println("triangle " + (5 * x * y));
    }
}
