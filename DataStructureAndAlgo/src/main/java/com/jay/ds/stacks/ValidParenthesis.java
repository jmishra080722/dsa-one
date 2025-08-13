package com.jay.ds.stacks;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {
        String str = "(){([])}";
        boolean isValid = validate(str);
        System.out.println(isValid);
    }

    private static boolean validate(String str){
        Stack<Character>  stack = new Stack<>();
        char[] chars = str.toCharArray();
        for(char c : chars){
            if(c == '(' || c =='{' || c == '['){
                stack.push(c);
            }else {
                if(!stack.isEmpty() && (c == ')' && stack.peek() == '(' ||
                c == '}' && stack.peek() == '{' ||
                c == ']' && stack.peek() == '[')){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
