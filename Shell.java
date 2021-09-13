package com.ijcompany;

public class Shell extends Helper {
    public static void sort(Comparable[] arr) {

        int i, j, k;
        int h = arr.length / 3;

        while (h != 0) { // To progressively reduce h
            for (i=0; i<h; i++) {
                for (j=i+h; j<arr.length; j+=h) {
                    k = j;
                    while (arr[k-h].compareTo(arr[k]) == 1) {
                        swap(arr, k-h, k);
                        k -= h;
                        if (k-h < 0) break;
                    }
                }
            }
            h = h==2 ? 1 : h/3;
        }
    }
}
