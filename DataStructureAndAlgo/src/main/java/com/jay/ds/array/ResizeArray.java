package com.jay.algorithms.array;

public class ResizeArray {
    public static void main(String[] args) {
        int[] num = {3, 4, 6, 9, 2};
        System.out.println("\nOriginal array size is : "+num.length+ " and elements are: ");
        ArrayUtils2.printArray(num);

        try {
            num = resize(num, num.length*3);
            System.out.println("\nNew array size is: "+num.length+" and elements are: ");
            ArrayUtils2.printArray(num);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static int[] resize(int[] num, int capacity) {
        if(capacity < num.length){
            throw new IllegalArgumentException("\nNew capacity can not be less than array length!");
        }
        int[] temp = new int[capacity];
        for(int i = 0; i < num.length; i++){
            temp[i] = num[i];
        }
        return temp;
    }
}
