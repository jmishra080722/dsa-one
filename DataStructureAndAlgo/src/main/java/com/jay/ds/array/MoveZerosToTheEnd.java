package com.jay.algorithms.array;

public class MoveZerosToTheEnd {
    public static void main(String[] args) {
        int[] num = {8, 1, 0, 2, 1, 0, 3, 0, 0, 4, 8, 0, 0, 0, 4, 5, 3};
        System.out.println("Original Array: ");
        ArrayUtils2.printArray(num);

        System.out.println("\nUpdate array:");
        moveZerosToEnd(num, num.length);
        ArrayUtils2.printArray(num);
    }

    private static void moveZerosToEnd(int[] num, int length) {

        int j = 0;  //Focus on ZERO element
        for(int i = 0; i< length; i++){    // i //Focus on NON-ZERO element
            if(num[i] != 0 && num[j] == 0){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
            }
            if(num[j] != 0){
                j++;
            }
        }
    }
}
