package com.jay.ds.queues;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNBinaryNumber {

    private String[] generateNBinaryNums(int num){
        String[] result = new String[num];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i = 0; i< num; i++){
            result[i] = queue.poll();
            String next1 = result[i] +"0";
            String next2 = result[i] + "1";
            queue.offer(next1);
            queue.offer(next2);
        }
        return result;
    }
    public static void main(String[] args) {
        GenerateNBinaryNumber generateNBinaryNumber = new GenerateNBinaryNumber();
        String[] strings = generateNBinaryNumber.generateNBinaryNums(10);
        for(String binary: strings){
            System.out.print(binary+" ");
        }
    }
}
