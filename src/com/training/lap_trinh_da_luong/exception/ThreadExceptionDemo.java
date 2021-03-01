package com.training.lap_trinh_da_luong.exception;

/**
 * Phương thức Thread.setDefaultUncaughtExceptionHandler() thiết lập mặc định xử lý khi luồng
 * đột ngột chấm dứt do một ngoại lệ xảy ra mà không có xử lý khác đã được xác định cho luồng đó.
 */
public class ThreadExceptionDemo {
    public static void main(String[] args) {
        System.out.println("==> Main thread running...");

        Thread thread = new Thread(new WorkingThread());
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("#Thread: " + t);
            System.out.println("#Thread exception message: " + e.getMessage());
        });

        thread.start();
        System.out.println("==> Main thread end!!!");
    }
}
