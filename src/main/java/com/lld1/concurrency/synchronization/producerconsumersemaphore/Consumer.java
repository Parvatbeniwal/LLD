package com.lld1.concurrency.synchronization.producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class Consumer implements Runnable {
    private Store store;
    private Semaphore produce;
    private Semaphore consume;

    public Consumer(Store store, Semaphore produce, Semaphore consume) {
        this.store = store;
        this.produce = produce;
        this.consume = consume;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                consume.acquire();

                System.out.println("Consumer who can consume : " + consume.availablePermits());

                store.removeItem();
                produce.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }


        }
    }
}
