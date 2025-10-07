package com.lld1.concurrency.synchronization.addersubstracter;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    private Count value;
    private Lock lock;

    public Adder(Count value) {
        this.value = value;
    }

    public Adder(Count value, Lock lock) {
        this.value = value;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_00_000; i++) {
            // take the lock
            if (lock != null) {
                lock.lock();
            }

            value.incrementValue();

            if (lock != null) {
                lock.unlock();
            }
        }
    }


    public void increment_with_sync() {
        for (int i = 0 ; i < 100_00_000 ; i++){
            synchronized (value){
                value.incrementValue();
            }
        }
    }
}
