package com.ijcompany;

import java.lang.Math;
import java.util.Arrays;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Tester {

    public static Integer[] arrayGenerator(int len, int lowerBound, int upperBound) {
        Integer[] arr = Generator.arr(len, lowerBound, upperBound);
        if (arr.length <= 200) System.out.println(Arrays.toString(arr));
        if (Tester.isSorted(arr)) System.out.println("This array is sorted already!");
        else                      System.out.println("This array is not sorted.");
        return arr;
    }
    public static void selectionSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Selection.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Selectionsort works!");
        else                      System.out.println("Selectionsort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void insertionSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Insertion.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Insertionsort works!");
        else                      System.out.println("Insertionsort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void shellSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Shell.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Shellsort works!");
        else                      System.out.println("Shellsort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void elemMergeSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Merge.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Elementary Mergesort works!");
        else                      System.out.println("Elementary Mergesort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void betterMergeSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Merge.betterSort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Improved Mergesort works!");
        else                     System.out.println("Improved Mergesort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void elemQuickSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Quick.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Quicksort works!");
        else                     System.out.println("Quicksort doesn't work...");
        if (arr.length <= 200) System.out.println(Arrays.toString(arr));
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void betterQuickSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Quick.betterSort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Improved Quicksort works!");
        else                     System.out.println("Improved Quicksort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    public static void quickSelection(Comparable[] arr) {
        int k = Generator.num(0, arr.length);
        boolean greatest = true;
        Comparable kth = Quick.selection(arr, greatest, k);
        if (Tester.isKth(arr, kth, greatest, k)) {
            System.out.println("Quick selection works!");
            System.out.format("The %dth greatest element is " + kth + "\n", k);
        } else {
            System.out.println("Quick selection doesn't work...");
        }
    }
    public static void heapSort(Comparable[] arr) {
        long startTime = System.currentTimeMillis();
        Heap.sort(arr);
        long endTime = System.currentTimeMillis();
        if (Tester.isSorted(arr)) System.out.println("Heapsort works!");
        else                     System.out.println("Heapsort doesn't work...");
        time_and_array(arr, (endTime - startTime));
        Shuffler.shuffle(arr);
    }
    private static void time_and_array(Comparable[] arr, long duration) {
        System.out.println("The sort took " + duration + " milliseconds.");
        if (arr.length <= 200) System.out.println(Arrays.toString(arr));
    }
    private static boolean isSorted(Comparable[] arr) {
        for (int i=1; i<arr.length; i++) {
            if (arr[i-1].compareTo(arr[i]) == 1) { return false; }
        }
        return true;
    }
    private static boolean isKth(Comparable[] arr, Comparable elem, boolean greatest, int k) {
        // Checks if elem really is the kth greatest element
        Comparable[] copy = Arrays.copyOf(arr, arr.length);
        Merge.betterSort(copy);

        k = greatest ? arr.length-k : k;
        return copy[k] == elem;
    }
}
