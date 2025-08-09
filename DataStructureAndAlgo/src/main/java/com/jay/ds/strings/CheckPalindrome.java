package com.jay.ds.strings;

public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "Madam";
        System.out.println("String is: "+str);
        boolean isPalindrome = isPalindrome(str);
        System.out.println(str +" is a palindrome? "+isPalindrome );
    }

    private static boolean isPalindrome(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        int start = 0;
        int last = str.length()-1;
        while(start < last){
            if(chars[start]  != chars[last]){
                return false;
            }
            start++;
            last--;
        }
        return true;
    }
}
