package com.training.java_8.optional;

import java.util.Optional;

public class OptionalExample2 {
    public static void main(String[] args) {
        // Pre java 8

        // Java 8
        String listOpt2 = getList2().orElse("orElse");
        String listOpt3 = getList2().orElseGet(() -> String.valueOf(getList2().get()));

        System.out.println("listOpt2 = " + listOpt2);
        System.out.println("listOpt3 = " + listOpt3);
    }

    private static String getList() {
        return "null";
    }

    private static Optional<String> getList2() {
        return Optional.ofNullable("hehe");
    }
}
