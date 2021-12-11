package br.com.sl.training;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// Spring Boot tutorials | Spring boot full course - Using @Autowired and @Qualifier in Spring Boot
// ref: https://www.youtube.com/watch?v=S6XkVD22Eps

@Component
public class ShapeFactory {

    @Autowired
    @Qualifier("rectangle")
    Shape shape;

    @Autowired
    @Qualifier("triangle")
    Shape nshape;

    public void printArea(String choice, int x, int y) {
        System.out.println("Print Area");
        if (choice.equals("T")) {
            System.out.println("Triangle Area");
            nshape.area(x, y);
        } else if (choice.equals("R")) {
            System.out.println("Rectangle Area");
            shape.area(x, y);
        } else {
            System.out.println("Wrong Choice");
        }
    }

}
