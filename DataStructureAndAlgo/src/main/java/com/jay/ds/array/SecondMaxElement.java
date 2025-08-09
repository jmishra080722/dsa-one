package com.jay.algorithms.array;

public class SecondMaxElement {
    public static void main(String[] args) {
        int[] num = {3, 24, 35, 87, 30, 65, 46, 20, 87};
        System.out.println("Original Array element...");
        ArrayUtils2.printArray(num);

        int secondMax = secondMax(num);
        System.out.println("\nSecond max element of array is: "+secondMax);
    }

    private static int secondMax(int[] num) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for(int i = 0; i< num.length; i++){
            if(num[i] > max){
                secondMax = max;
                max = num[i];
            } else if(num[i] > secondMax && num[i] != max){
                secondMax = num[i];
            }
        }
        return secondMax;
    }
}
