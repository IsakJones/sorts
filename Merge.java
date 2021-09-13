package com.ijcompany;

import java.util.Arrays;

public class Merge extends Helper {
    public static void sort(Comparable[] arr) {
        if (arr.length <= 1) return;
        sort(arr, 0, arr.length-1);
    }
    public static void betterSort(Comparable[] arr) {
        if (arr.length <= 1) return;
        betterSort(arr, 0, arr.length-1);
    }
    private static void sort(Comparable[] arr, int lo, int hi) {

        if (lo == hi)
            return;
        else if (lo == hi-1) {
            if  (arr[lo].compareTo(arr[hi]) == 1)
                swap(arr, lo, hi);
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        sort(arr, lo, mid);
        sort(arr, mid+1, hi);

        int p1 = lo;
        int p2 = mid+1;
        Comparable[] copyArr = Arrays.copyOf(arr, arr.length);

        for (int i=lo; i<=hi; i++) {
            if      (p1 > mid)
                arr[i] = copyArr[p2++];
            else if (p2 > hi)
                arr[i] = copyArr[p1++];
            else if (copyArr[p1].compareTo(copyArr[p2]) == 1)
                arr[i] = copyArr[p2++];
            else
                arr[i] = copyArr[p1++];
        }
    }
    private static void betterSort(Comparable[] arr, int lo, int hi) {
        if (hi - lo <= 7) {
            Insertion.sort(arr, lo, hi);
            return;
        }
        int mid = (hi - lo) / 2 + lo;
        betterSort(arr, lo, mid);
        betterSort(arr, mid+1, hi);
        if (arr[mid+1].compareTo(arr[mid]) == 1)
            return;

        int p1 = lo;
        int p2 = mid+1;
        Comparable[] copyArr = Arrays.copyOf(arr, arr.length);

        for (int i=lo; i<=hi; i++) {
            if      (p1 > mid)
                arr[i] = copyArr[p2++];
            else if (p2 > hi)
                arr[i] = copyArr[p1++];
            else if (copyArr[p1].compareTo(copyArr[p2]) == 1)
                arr[i] = copyArr[p2++];
            else
                arr[i] = copyArr[p1++];
        }
    }
}
