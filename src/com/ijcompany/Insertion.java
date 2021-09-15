package com.ijcompany;

public class Insertion extends Helper {
    public static void sort(Comparable[] arr) {
        int i, j;

        for (i=1; i<arr.length; i++) {
            j = i;
            while (arr[j-1].compareTo(arr[j]) == 1) {
                swap(arr, j-1, j);
                j--;
                if (j==0) break;
            }
        }
    }
    public static void sort(Comparable[] arr, int lo, int hi) {

        int i, j;
        for (i=lo+1; i<=hi; i++) {
            j = i;
            while (arr[j-1].compareTo(arr[j]) == 1) {
                swap(arr, j-1, j);
                j--;
                if (j==lo) break;
            }
        }
    }
}
