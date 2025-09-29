package com.lld1.concurrency.basic;

import java.util.concurrent.Callable;

public class NumberPrinterCallable  implements Callable<String> {

    private int number;

    public NumberPrinterCallable(int number) {
        this.number = number;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Thread Name " + Thread.currentThread().getName() + "    Number - " +  number );
        return "";
    }
}
