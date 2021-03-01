package com.training.lap_trinh_da_luong.example1;

public class ThreadDemoTest {
    public static void main(String args[]) {
        System.out.println("Main thread running... ");

        ThreadDemo T1 = new ThreadDemo("Thread-1-HR-Database");
        ThreadDemo T2 = new ThreadDemo("Thread-2-Send-Email");

        T1.start();
        T2.start();

        System.out.println("==> Main thread stopped!!! ");
    }
}
