package com.training;

import com.training.reflection.anotation.MyAnnotation;

public class Main {
    @MyAnnotation(name = "demo")
    static String namespace = "huy";

    public static void main(String[] args) {
	// write your code here
        System.out.println("namespace = " + namespace);
    }
}
