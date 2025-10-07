package com.lld1.concurrency.synchronization.producerconsumersemaphore;

import java.util.concurrent.ConcurrentLinkedDeque;

public class Store {
    private int maxItems;
    private ConcurrentLinkedDeque<Object> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();

    public Store(int maxItems, ConcurrentLinkedDeque<Object> list) {
        this.maxItems = maxItems;
        this.concurrentLinkedDeque = list;
    }

    public void addItem(Object item){
        System.out.println("Producing item to Current Size " + concurrentLinkedDeque.size());
        concurrentLinkedDeque.add(item);

    }

    public void removeItem(){
        System.out.println("Removing item  Current Size " + concurrentLinkedDeque.size());
        concurrentLinkedDeque.removeLast();
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public ConcurrentLinkedDeque<Object> getConcurrentLinkedDeque() {
        return concurrentLinkedDeque;
    }

    public void setConcurrentLinkedDeque(ConcurrentLinkedDeque<Object> concurrentLinkedDeque) {
        this.concurrentLinkedDeque = concurrentLinkedDeque;
    }
}
