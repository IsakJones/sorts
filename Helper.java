package com.ijcompany;

public abstract class Helper {
    public static void swap(Comparable[] arr, int i, int j) {
        Comparable item = arr[i];
        arr[i] = arr[j];
        arr[j] = item;
    }
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) == -1;
    }
    public static boolean more(Comparable a, Comparable b) {
        return a.compareTo(b) == 1;
    }
}
