package com.lld1.concurrency.basic;

public class NumberPrinterRunnable implements Runnable{
    int number;

    public NumberPrinterRunnable(int number){
        this.number = number;
    }
    @Override
    public void run() {
        System.out.println("Thread Name " + Thread.currentThread().getName() + "    Number - " +  number );
    }
}
