package com.lld1.concurrency.synchronization;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AdderSubtractRunner {

    public static void main(String[] args) throws InterruptedException {


        withOutLockScenario();


        //--- Lock the Count
        lockSolution();

        // synchronized solution
        synchronizedSolution();

    }

    private static void withOutLockScenario() throws InterruptedException {
        Count count = new Count(0);
        Adder adder = new Adder(count);
        Subtracter subtracter = new Subtracter(count);

        new Thread(adder).start();
        new Thread(subtracter).start();
        Thread.sleep(2000);
        System.out.println("Output Without Lock :  " + count.getValue());
    }


    private static void lockSolution() throws InterruptedException {
        Count count = new Count(0);
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtracter subtracter = new Subtracter(count, lock);

        new Thread(adder).start();
        new Thread(subtracter).start();

        Thread.sleep(2000);

        System.out.println("Output With Lock :  " + count.getValue());
    }



    private static void synchronizedSolution() {
        // Check out Method  Adder & Subtracter decrement_with_sync & increment_with_sync
        // implement with new method name just to show usage
    }
}
