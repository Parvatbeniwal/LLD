package com.lld1.concurrency.synchronization.addersubstracter;

public class Count {
    private  int value;

    public Count(int value) {
        this.value = value;
    }

    public void decrementValue() {
        value = value - 1;
    }

    public void incrementValue() {
        value = value + 1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
