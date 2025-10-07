package com.lld1.concurrency.synchronization.addersubstracter;

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

        Thread adderThread = new Thread(adder);
        adderThread.start();

        Thread subtracterThread =  new Thread(subtracter);
        subtracterThread.start();

        adderThread.join();
        subtracterThread.join();
        System.out.println("Output Without Lock :  " + count.getValue());
    }


    private static void lockSolution() throws InterruptedException {
        Count count = new Count(0);
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(count, lock);
        Subtracter subtracter = new Subtracter(count, lock);

        Thread adderThread = new Thread(adder);
        Thread subtracterThread =  new Thread(subtracter);

        adderThread.start();
        subtracterThread.start();

        adderThread.join();
        subtracterThread.join();

        System.out.println("Output With Lock :  " + count.getValue());
    }



    private static void synchronizedSolution() {
        // Check out Method  Adder & Subtracter decrement_with_sync & increment_with_sync
        // implement with new method name just to show usage
    }
}
