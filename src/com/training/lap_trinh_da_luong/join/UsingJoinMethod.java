package com.training.lap_trinh_da_luong.join;

/**
 * join() : thông báo rằng hãy chờ thread này hoàn thành rồi thread cha mới được tiếp tục chạy.
 */
public class UsingJoinMethod extends Thread {

    public UsingJoinMethod(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(getName());
        for (int i = 1; i <= 5; i++) {
            try {
                System.out.print(i + " ");
                Thread.sleep(300);
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws InterruptedException {
        UsingJoinMethod t1 = new UsingJoinMethod("Thread 1");
        UsingJoinMethod t2 = new UsingJoinMethod("Thread 2");
        t1.start();
        //join(long) : Thread cha cần phải đợi millisecond mới được tiếp tục chạy, kể từ lúc gọi join(long).
        //
        // Nếu tham số millis = 0 nghĩa là đợi cho tới khi luồng này kết thúc.
        t1.join();
        t2.start();
        System.out.println("Main Thread Finished");
    }
}
