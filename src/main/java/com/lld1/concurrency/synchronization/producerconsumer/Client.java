package com.lld1.concurrency.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        final Store store = new Store(5, new ArrayList<>());

        for (int i = 0; i < 10; i++) {
            Producer producer = new Producer(store);
            executorService.execute(producer);
        }

        for (int i = 0; i < 15; i++) {
            Consumer consumer = new Consumer(store);
            executorService.execute(consumer);
        }


        /* Synchronized lock on store in both consumer and producer
        synchronized (store){

        }

        but with solution only one thread can work . We need to have more than one thread to work
        // SEMAPHORES
        */
    }
}
