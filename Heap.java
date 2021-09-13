package com.ijcompany;

import java.util.Arrays;

public class Heap extends Helper {
    // This is a min-oriented heap, necessary for heapsort.
    Comparable[] heap;
    int curIndex;

    public Heap(int len) {
        heap = new Comparable[len];
        curIndex = 0;
    }
    public Heap(Comparable[] arr) {
        heap = new Comparable[arr.length+1]; // plus 1 for the null heap[0]
        for (int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
    }
    public void insert(Comparable elem) {
        if (isFull()) return;
        heap[++curIndex] = elem;
        swim();
    }
    private void swim() {
        int k = curIndex; // k is the index of the child, k/2 of the parent
        while (k>1 && less(heap[k], heap[k/2])) {
        // i.e. so long as the child is less than the parent
            exch(k, k/2);
            k /= 2;
        }
    }
    public Comparable popMin() {
        if (isEmpty())  return null;
        Comparable result = heap[1];
        exch(1, curIndex--);
        sink();
        return result;
    }
    private void sink() {
        int child;
        int parent = 1;
        while (parent*2 <= curIndex) {
            child = parent*2;
            // If the other child is smaller, exchange the parent to the other child
            if (child+1 <= curIndex && less(heap[child+1], heap[child])) child++;
            // Break if the descending parent is less than its child
            if (less(heap[parent], heap[child])) break;
            exch(parent, child);
            parent = child;
        } // There's no need for a comparison between child and parent,
    }     // as we know that the sinking node is always greater than its children.
    public static void sort(Comparable[] arr) {
        Heap sortHeap = new Heap(arr);
        for (int i=0; i<arr.length; i++) {
            arr[i] = sortHeap.popMin();
        }
    }
    public boolean isEmpty() {
        return curIndex == 0;
    }
    public boolean isFull() {
        return curIndex == heap.length-1;
    }
    public void print() {
        System.out.println(Arrays.toString(heap));
    }
    private void exch(int i, int j) {
        swap(heap, i, j);
    }
}
