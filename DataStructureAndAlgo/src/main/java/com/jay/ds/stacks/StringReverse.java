package com.jay.ds.stacks;

import java.util.Stack;

public class StringReverse {
    public static void main(String[] args) {
        String str = "ABCD";
        String reversedString = reverse(str);
        System.out.println("Reversed string of "+str+" is: "+reversedString);
    }

    private static String reverse(String str) {
        if(str.isEmpty()){
            throw new IllegalArgumentException("Input String is null or empty~");
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            stack.push(aChar);
        }
        for(int i = 0; i < chars.length; i++){
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
