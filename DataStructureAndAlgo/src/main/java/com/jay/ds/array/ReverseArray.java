package com.jay.algorithms.array;

public class ReverseArray {

    public void printArray(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private void reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 11, 5, 10,7, 8};
        ReverseArray reverseArray  = new ReverseArray();
        System.out.println("Original Array...");
        reverseArray.printArray(numbers);

        System.out.println("\nReversed Array...");
        reverseArray.reverse(numbers, 0, numbers.length - 1);
        reverseArray.printArray(numbers);
    }
}
