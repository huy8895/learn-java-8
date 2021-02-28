package com.training.java_8.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample1 {
    public static void main(String[] args) {

        // Predicate String
        Predicate<String> predicateString = s -> s.equals("gpcoder");
        System.out.println(predicateString.test("gpcoder")); // true
        System.out.println(predicateString.test("GP Coder")); // false

        // Predicate integer
        Predicate<Integer> predicateInt = i -> i > 0;
        System.out.println(predicateInt.test(1)); // true
        System.out.println(predicateInt.test(-1)); // false


        List<String> strings = Arrays.asList("cat", "cow", "dog");
        Predicate<String> containString = strings::contains;
        System.out.println("containString.test(\"cat\") = " + containString.test("cat"));
    }
}
