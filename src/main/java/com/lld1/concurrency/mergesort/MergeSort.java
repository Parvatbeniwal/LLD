package com.lld1.concurrency.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSort implements Callable<List<Integer>> {
    private List<Integer> list;
    private ExecutorService executor;

    public MergeSort(List<Integer> list, ExecutorService executor) {
        this.list = list;
        this.executor = executor;
    }

    @Override
    public List<Integer> call() throws Exception {
        if (list.size() <= 1) {
            return list; // already sorted
        }

        int mid = list.size() / 2;
        List<Integer> leftPart = new ArrayList<>(list.subList(0, mid));
        List<Integer> rightPart = new ArrayList<>(list.subList(mid, list.size()));

        // submit subtasks
        Future<List<Integer>> leftFuture = executor.submit(new MergeSort(leftPart, executor));
        Future<List<Integer>> rightFuture = executor.submit(new MergeSort(rightPart, executor));

        // wait for results
        List<Integer> leftSorted = leftFuture.get();
        List<Integer> rightSorted = rightFuture.get();

        // merge results
        return merge(leftSorted, rightSorted);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        final List<Integer> merged = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) merged.add(left.get(i++));
        while (j < right.size()) merged.add(right.get(j++));

        return merged;
    }
}
