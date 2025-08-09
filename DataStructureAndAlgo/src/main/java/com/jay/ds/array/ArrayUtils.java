package com.jay.algorithms.array;

public class ArrayUtils {
    public static void main(String[] args) {

        ArrayUtils arrayUtils = new ArrayUtils();
        arrayUtils.arrayDemo();
    }

    public void printArray(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            System.out.print(arr[i] +" ");
        }
        System.out.println("\n");
    }

    public void arrayDemo(){
        int[] myArray = new int[5];
        System.out.println("Default value...");
        printArray(myArray);

        myArray[0] = 5;
        myArray[1] = 7;
        myArray[2] = 12;
        myArray[3] = 2;
        myArray[4] = 8;
        System.out.println("Initial passed value...");
        printArray(myArray);

        myArray[3] = 34;
        myArray[2] = 87;
        System.out.println("Last element of myArray: "+myArray[myArray.length - 1]);
        System.out.println("Updated values...");
        printArray(myArray);


        int[] newArray = {6, 3, 3, 65, 12, 34};
        System.out.println("NewArray length: "+newArray.length);
        System.out.println("newArray last element: "+newArray[newArray.length - 1]);
    }
}
