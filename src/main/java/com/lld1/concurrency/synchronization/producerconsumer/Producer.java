package com.lld1.concurrency.synchronization.producerconsumer;

public class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            if (store.getList().size() < store.getMaxItems()) {
                store.addItem(new Object());
            }
        }
    }
}
