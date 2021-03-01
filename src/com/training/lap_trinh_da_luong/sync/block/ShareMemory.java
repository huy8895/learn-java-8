package com.training.lap_trinh_da_luong.sync.block;

public class ShareMemory {
    int counter = 0;

    public  void printData(String threadName) {
        synchronized(this){
            for (int i = 1; i <= 5; i++) {
                counter ++;
                System.out.println(threadName + ": " + counter);
            }
        }
    }
}
