package com.ijcompany;

import java.util.Random;

public class Generator {
    public static Integer[] arr(int len, int lowerBound, int upperBound) {
        Random random = new Random();
        Integer[] result = new Integer[len];
        for (int i=0; i<result.length; i++) {
            result[i] = num(random, lowerBound, upperBound);
        }
        return result;
    }
    public static int num(int lowerBound, int upperBound) {
        Random random = new Random();
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
    private static int num(Random random, int lowerBound, int upperBound) {
        return random.nextInt(upperBound - lowerBound) + lowerBound;
    }
}
