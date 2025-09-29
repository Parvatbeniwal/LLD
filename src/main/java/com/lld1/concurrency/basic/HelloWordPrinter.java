package com.lld1.concurrency.basic;

public class HelloWordPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello Word Printer" + Thread.currentThread().getName());
    }
}
