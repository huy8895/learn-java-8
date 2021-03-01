package com.training.lap_trinh_da_luong.sync.methods;

public class ShareMemory {
    public synchronized void printData(String threadName) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(threadName + ": " + i);
        }
    }
}
