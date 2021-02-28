package com.training.java_8.supplier;

import java.util.function.Supplier;

public class SupplierExample1 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Welcome to gpcoder.com";
        String hello = supplier.get();
        System.out.println(hello);
    }
}
