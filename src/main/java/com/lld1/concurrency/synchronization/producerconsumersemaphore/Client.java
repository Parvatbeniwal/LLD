package com.lld1.concurrency.synchronization.producerconsumersemaphore;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Store store = new Store(5, new ConcurrentLinkedDeque<>());

        Semaphore produce = new Semaphore(5);
        Semaphore consume = new Semaphore(0);

        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(store, produce, consume);
            executorService.execute(producer);
        }

        for (int i = 0; i < 10; i++) {
            Consumer consumer = new Consumer(store, produce, consume);
            executorService.execute(consumer);
        }

        Thread.sleep(2000);
        executorService.shutdownNow();                 // interrupts workers
        executorService.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS);
    }
}
