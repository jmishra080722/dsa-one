package com.jay.ds.stacks;


import java.util.Stack;

//Replace Array Element With First Higher greater Element towards right, If not present that place -1
public class ReplaceArrayElement {

    public static void main(String[] args) {
        int[] input = {4,7,3, 4, 8, 1};  // {7, 8,4,8,-1, -1}
        int[] output = replace(input);
        for(int n: output){
            System.out.print(n+" ");
        }
    }

    private static int[] replace(int[] input) {
        // {4, 7, 3, 4, 8, 1}
        int[] result = new int[input.length];
        if(input.length == 0){
            throw new IllegalArgumentException("Array has no element");
        }
        Stack<Integer> stack = new Stack<>();
        for(int i = input.length - 1; i >= 0; i--){
            if(!stack.isEmpty()){
                while (!stack.isEmpty() && stack.peek() <= input[i]){
                    stack.pop();
                }
            }
            if(stack.isEmpty()){
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(input[i]);
        }
        return result;
    }
}
