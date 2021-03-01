package com.training.lap_trinh_da_luong.sync.block;

public class WorkingThread extends Thread {
    private ShareMemory mShareMemory;
    private String mThreadName;

    public WorkingThread(ShareMemory sm, String threadName) {
        this.mShareMemory = sm;
        this.mThreadName = threadName;
    }

    @Override
    public void run() {
        mShareMemory.printData(mThreadName);
    }
}
