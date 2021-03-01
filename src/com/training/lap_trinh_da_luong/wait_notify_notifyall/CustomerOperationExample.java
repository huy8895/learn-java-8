package com.training.lap_trinh_da_luong.wait_notify_notifyall;

public class CustomerOperationExample {
    public static void main(String[] args) {
        final Customer c = new Customer();


        Thread t1 = new Thread(() -> c.withdraw(2000));
        t1.start();

        Thread t2 = new Thread(() -> {
            c.deposit(500);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c.deposit(3000);
        });
        t2.start();
    }
}
