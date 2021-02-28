package com.training.java_8.predicate;

import java.util.function.Predicate;

public class PredicateExample2 {
    public static void main(String[] args) {
        Predicate<String> predicate = s -> s.equals("gpcoder");

        // AND logical operation
        Predicate<String> predicateAnd = predicate.and(e -> e.length() == 7);
        System.out.println("predicateAnd.test(\"gpcoder\") = " + predicateAnd.test("gpcoder"));


        // OR logical operation
        Predicate<String> predicateOr = predicate.or(e -> e.length() > 2);
        System.out.println("predicateOr.test(\"245\") = " + predicateOr.test("245"));

        // NEGATE logical operation
        Predicate<String> negate = predicate.negate();
        System.out.println("negate.test(\"gpcoder\") = " + negate.test("gpcoder1"));

    }
}
