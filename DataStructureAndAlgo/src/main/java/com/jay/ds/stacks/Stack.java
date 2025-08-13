package com.jay.ds.stacks;

import java.util.EmptyStackException;

public class Stack {
    private ListNode top;
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Stack(){
        this.top = null;
        this.length = 0;
    }

    private boolean isEmpty(){
        return length == 0;
    }

    private int length(){
        return this.length;
    }

    private void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }

    private int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    private int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        System.out.println("Stack top element is : "+stack.peek());

        int removedElement = stack.pop();
        System.out.println("Popped element is : "+removedElement);
        System.out.println("Stack top element is : "+stack.peek());


    }

}
