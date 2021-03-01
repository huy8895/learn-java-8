package com.training.lap_trinh_da_luong.example;

public class WorkingThread extends Thread {
    public WorkingThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("Luồng: %s có độ ưu tiên là %d \n", getName(), getPriority());
        }
    }
}
