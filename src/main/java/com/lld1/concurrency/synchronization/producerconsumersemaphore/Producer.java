package com.lld1.concurrency.synchronization.producerconsumersemaphore;

import java.util.concurrent.Semaphore;

public class Producer implements Runnable {
    private Store store;
    private Semaphore produce;
    private Semaphore consume;

    public Producer(Store store, Semaphore produce, Semaphore consume) {
        this.store = store;
        this.produce = produce;
        this.consume = consume;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                produce.acquire();

                System.out.println("Producer who can produce : " + produce.availablePermits());
                store.addItem(new Object());
                consume.release();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
