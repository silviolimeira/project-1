package com.sl.javafuncional;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println(
            isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(
                isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(
                isPhoneNumberValidPredicate.test("09155500000"));

        // and(containsNumber3, or(containsNumber3...
        System.out.println("\n\nContains number 3 and valid: " +
                isPhoneNumberValidPredicate.or(containsNumber3).test("07300000")
        );

    }

    static Predicate<String> containsNumber3 = phoneNumber -> {
        System.out.println("\nContains number 3");
        return phoneNumber.contains("3");
    };

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber -> {
        System.out.println("\nLength 11 characters and start with 07");
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    };

}
