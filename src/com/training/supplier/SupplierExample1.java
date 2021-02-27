package com.training.supplier;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class SupplierExample1 {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Welcome to gpcoder.com";
        String hello = supplier.get();
        System.out.println(hello);
    }
}
