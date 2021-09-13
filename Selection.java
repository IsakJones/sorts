package com.ijcompany;

public class Selection extends Helper {
    public static void sort(Comparable[] arr) {
        int i, j, minIndex;
        // The big loop is for each min search
        for (i=0; i<arr.length; i++) {
            minIndex = i;
            for (j=i; j<arr.length; j++)
                if (less(arr[j], arr[minIndex]))
                    minIndex = j;
            swap(arr, i, minIndex); // Swap first with minimum
        }
    }
}
