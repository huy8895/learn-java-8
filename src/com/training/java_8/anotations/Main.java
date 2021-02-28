package com.training.java_8.anotations;

import com.training.java_8.reflection.anotation.MyAnnotation;

public class Main {
    @MyAnnotation(name = "demo")
    static String namespace = "huy";

    public static void main(String[] args) {
	// write your code here
        System.out.println("namespace = " + namespace);
    }
}
