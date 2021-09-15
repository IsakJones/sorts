package com.ijcompany;

public class Quick extends Helper {
    public static void sort(Comparable[] arr) {
        Shuffler.shuffle(arr);
        sort(arr, 0, arr.length-1);
    }
    public static void betterSort(Comparable[] arr) {
        Shuffler.shuffle(arr);
        betterSort(arr, 0, arr.length-1);
    }
    public static Comparable selection(Comparable[] arr, boolean greatest, int k) {
        // Returns kth ordered element, if greater than kth greatest else smallest
        Shuffler.shuffle(arr);
        if (greatest == false) return selection(arr, k, 0, arr.length-1);
        else                   return selection(arr, arr.length-k, 0, arr.length-1);
    }
    private static void sort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo) return; // hi-lo <= 1 also excludes length 2 arrays

        int watershed = partition(arr, lo, hi);
        sort(arr, lo, watershed-1);
        sort(arr, watershed+1, hi);
    }
    private static void betterSort(Comparable[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        if (hi - lo < 10) {
            Insertion.sort(arr, lo, hi);
            return;
        }
        int watershed = partition(arr, lo, hi);
        betterSort(arr, lo, watershed-1);
        betterSort(arr, watershed+1, hi);
    }
    private static int partition(Comparable[] arr, int lo, int hi) {
        // Returns the index of the partitioning element
        // NB hi is the last index of the subarray
        int left = lo;
        int right = hi + 1; //Plus One because of the --right below

        while (true) {
            while (arr[++left].compareTo(arr[lo]) == -1) // If arr[left] < arr[lo], move on;
                if (left == hi) break;
            while (arr[--right].compareTo(arr[lo]) == 1)
                if (right == lo) break;

            if (left >= right) break; // If left == right, you want to interrupt so that right doesn't move
            swap(arr, left, right);
        }
        swap(arr, lo, right);
        return right;
    }
    private static Comparable selection(Comparable[] arr, int k, int lo, int hi) {
        int watershed = partition(arr, lo, hi);

        if      (watershed > k) return selection(arr, k, lo, watershed-1);
        else if (watershed < k) return selection(arr, k, watershed+1, hi);

        return arr[watershed];
    }
}
