package com.sl.javafuncional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {
        int increment = incrementByOneFunction.apply(1);
        System.out.println("add more one to apply parameter number: " +  increment);

        int multiply = multiplyBy10Function.apply(increment);
        System.out.println("multiply by 10 increment function: " + multiply);

        // Function example
        Function<Integer, Integer> addAndMultiply =
                incrementByOneFunction.andThen(multiplyBy10Function);

        System.out.println("\n--> increment and multiply: " + addAndMultiply.apply(1));

        // BiFunction example
        BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiply) -> {
                return (numberToIncrementByOne + 1) * numberToMultiply;
            };

        System.out.println(String.format("\n--> BiFunction: %d+1 * %d = %d", 2, 10, incrementByOneAndMultiplyBiFunction.apply(2, 10)));


    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

}
