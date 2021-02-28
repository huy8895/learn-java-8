package com.training.java_8.predicate.vs.bi.predicate;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {

        BiPredicate<Integer, String> condition = (i, s) -> i > 2 && s.startsWith("J");
        System.out.println(condition.test(5, "Java")); // true
        System.out.println(condition.test(2, "Javascript")); // false
        System.out.println(condition.test(1, "C#")); // false
    }
}
