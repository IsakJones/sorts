package com.ijcompany;

import java.util.Random;

public class Shuffler extends Helper {
    public static void shuffle(Comparable[] arr) {

        int destIndex;
        Random random = new Random();
        for (int i=0; i<arr.length; i++) {
            // Generate random int up to arr.len - 1
            destIndex = random.nextInt(arr.length);
            swap(arr, i, destIndex);
        }
    }
}
