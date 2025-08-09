package com.jay.algorithms.array;

public class RemoveEvenInteger {

    public static void main(String[] args) {
        int[] arr = {5, 3, 4, 8, 10, 23, 8};
        RemoveEvenInteger removeEvenInteger = new RemoveEvenInteger();
        System.out.println("Original array: ");
        removeEvenInteger.printArray(arr);
        int[] oddArr = removeEvenInteger.removeEven(arr);
        System.out.println("Odd int array: ");
        removeEvenInteger.printArray(oddArr);

    }

    public void printArray(int[] arr){
        int len = arr.length;
        for(int i = 0; i < len; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    private int[] removeEven(int[] arr){
        int len = arr.length;
        int oddCount = 0;
        for(int i = 0; i < len; i++){
            if(arr[i] % 2 != 0){
                oddCount++;
            }
        }

        int idx = 0;
        int[] result = new int[oddCount];
        for(int i = 0; i < len; i++){
            if(arr[i] % 2 != 0){
                result[idx] = arr[i];
                idx++;
            }
        }

        return result;
    }
}
