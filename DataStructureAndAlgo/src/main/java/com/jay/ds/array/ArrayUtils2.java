package com.jay.algorithms.array;

public class ArrayUtils2 {

    public static void main(String[] args) {
        printArray(new int[] {4, 6, 8, 6, 20});
    }
    public  static void printArray(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

}
