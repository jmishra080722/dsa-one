package com.jay.algorithms.array;

public class FindMissingNumber {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 4, 8, 7, 6};
        System.out.println("Array...");
        ArrayUtils2.printArray(nums);
        int missingNum = findMissing(nums);
        System.out.println("\nMissing number is : "+missingNum);
    }

    private static int findMissing(int[] nums) {
        int range = nums.length + 1;
        int sum = range * (range + 1) / 2;
        for(int n : nums){
            sum = sum - n;
        }
        return sum;
    }
}
