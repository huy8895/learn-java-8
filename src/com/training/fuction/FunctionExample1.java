package com.training.fuction;

import java.util.function.Function;

public class FunctionExample1 {
    public static void main(String[] args) {
        Function<String, Integer> numberConverter = null;
        try {
            numberConverter = string -> Integer.parseInt(string);
            System.out.println("numberConverter.apply(\"1\") = " + numberConverter.apply("a"));
        } catch (Exception exception){
            System.out.println("exception.getClass() = " + exception.getClass());
            System.out.println(exception.getMessage());
        }
    }
}
