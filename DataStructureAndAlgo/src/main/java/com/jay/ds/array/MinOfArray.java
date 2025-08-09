package com.jay.algorithms.array;

public class MinOfArray {
    public static void main(String[] args) {
        int[] nums = {5, 9, 3, 15, 1, 2};
        System.out.println("Original Array Elements: ");
        ArrayUtils2.printArray(nums);

        int min ;
        try {
            min = findMin(nums);
            System.out.println("\nSmallest element of above array is: "+min);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static int findMin(int[] numes){

        if(numes == null || numes.length == 0){
            throw new IllegalArgumentException("Invalid input array");
        }
        int min = numes[0];
        for(int i = 1; i < numes.length; i++){
            if(numes[i] < min){
                min = numes[i];
            }
        }
        return min;
    }
}
