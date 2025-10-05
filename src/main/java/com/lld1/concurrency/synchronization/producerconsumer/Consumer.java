package com.lld1.concurrency.synchronization.producerconsumer;

public class Consumer implements Runnable {
    private Store store;

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            if (store.getList().size() > 0) {
                store.removeItem(store.getList().get(0));
            }
        }
    }
}
