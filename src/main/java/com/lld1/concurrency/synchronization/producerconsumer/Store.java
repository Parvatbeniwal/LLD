package com.lld1.concurrency.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private int maxItems;
    private List<Object> list = new ArrayList<>();

    public Store(int maxItems, List<Object> list) {
        this.maxItems = maxItems;
        this.list = list;
    }

    public void addItem(Object item){
        System.out.println("Producing item " + item + "  to Current Size " + list.size());
        list.add(item);

    }

    public void removeItem(Object item){
        System.out.println("Removing item " + item + "  to Current Size " + list.size());
        list.remove(item);
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
