package com.lld1.concurrency.synchronization;

import java.util.concurrent.locks.Lock;

public class Subtracter implements Runnable {
    private Count value;
    private Lock lock;

    public Subtracter(Count value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    public Subtracter(Count value) {
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0 ; i < 100_00_000 ; i++){
            if (lock != null) {
                lock.lock();
            }

            value.decrementValue();

            if (lock != null) {
                lock.unlock();
            }
        }
    }



    public void decrement_with_sync() {
        for (int i = 0 ; i < 100_00_000 ; i++){
            synchronized (value){
                value.decrementValue();
            }
        }
    }
}
