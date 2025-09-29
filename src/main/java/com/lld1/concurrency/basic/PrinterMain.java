package com.lld1.concurrency.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrinterMain {

    public static void main(String[] args) throws InterruptedException {
        /*
        * 0. Statement : Print in Main thread and one thread
        * */
        printNumberMainThread();

        /*
        1. Statement : Print 10 words in new threads
        */
        printNumberNewThread();

        /*
        2. Statement : Print 100 words in Executor Service with FIXED Thread Pool
        */
        printNumberExecutorService_FixedPool();


        /*
        3. Statement : Print 100 words in Executor Service with CACHED Thread Pool
        */
        printNumberExecutorService_CachedPool();

    }

    /*
    * ------------------------------------private methods---------------------------------------------------------------
    *
    * */
    private static void printNumberMainThread() {
        System.out.println("Main Thread " + Thread.currentThread().getName());
        HelloWordPrinter printer = new HelloWordPrinter();
        printer.run(); // run in parent thread

        Thread thread = new Thread(printer);
        thread.start(); // starting thread
    }



    private static void printNumberNewThread() {
        for (int i = 0; i < 10; i++) {
            /*
            Variable used in lambda expression should be final or effectively final
            */
            int number = i;
            Thread thread1 = new Thread(() -> {
                try {
                    Thread.sleep(1);
                    System.out.println("Thread Name : " + Thread.currentThread().getName() + " : Number " + number);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            });
            thread1.start();
        }
        System.out.println("Task Assignment Done");
    }

    private static void printNumberExecutorService_FixedPool() {
       /*
        1. Fixed thread When all thread are busy task wait in work queue
        2. Executors.newFixedThreadPool(100000000);
        There is no limit on creating large thread but it will fail mid way if system config is not large
        */
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int i = 0 ; i < 1_00_00_000 ; i++){
            if (i == 50_000) {
                System.out.println("DEBUG : Check States of Worker, Queue");
            }
            NumberPrinterRunnable numberPrinterRunnable = new NumberPrinterRunnable(i);
            executor.execute(numberPrinterRunnable);
        }
    }

    private static void printNumberExecutorService_CachedPool() {
        /*
         1. No work queue when all thread are busy new thread is created for new task
         2. It will create new thread only if all thread are busy
         */
        final ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 1_00_00_000 ; i++){
            if (i == 50_000) {
                System.out.println("DEBUG : Check States of Worker, Queue");
            }
            NumberPrinterRunnable numberPrinterRunnable = new NumberPrinterRunnable(i);
            executor.execute(numberPrinterRunnable);
        }
    }
}
