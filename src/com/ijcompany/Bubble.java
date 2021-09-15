package com.ijcompany;

public class Bubble extends Helper {
    public static void sort(Comparable[] arr) {
        int i, j;

        for (j=0; j < arr.length-1; j++)
            for (i = 1; i < arr.length - j; i++)
                if (less(arr[i], arr[i - 1]))
                    swap(arr, i, i - 1);
    }
    public static void betterSort(Comparable[] arr) {
        int i, j;
        boolean isSorted = false;
        // I don't know how much the boolean helps, given that the input is
        // random and likely not almost ordered...

        for (j=0; j < arr.length-1 && !isSorted; j++) {
            isSorted = true;
            for (i = 1; i < arr.length - j; i++) {
                if (less(arr[i], arr[i - 1])) {
                    swap(arr, i, i - 1);
                    isSorted = false;
                }
            }
        }
    }
}
