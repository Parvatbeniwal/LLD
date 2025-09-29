package com.lld1.concurrency.mergesort;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = List.of(21, 43, 64, 74, 59, 50, 64, 62, 27, 18, 34);

        final ExecutorService executor =  Executors.newCachedThreadPool();
        final MergeSort mergeSort = new MergeSort(list, executor);

        final Future<List<Integer>> future = executor.submit(mergeSort);

        System.out.println(future.get());
    }
}
