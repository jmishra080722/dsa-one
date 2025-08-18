package com.jay.ds.queues;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;  //Deletion
    private ListNode rear;  //Insertion
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Queue(){
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    public int length(){
        return this.length;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    private void display(){
        if(isEmpty()){
            return;
        }
        ListNode temp = this.front;
        while (temp != null){
            System.out.print(temp.data +" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    private void enqueue(int data){
        ListNode newNode = new ListNode(data);
        if(isEmpty()){
            this.front = newNode;
        }else {
            this.rear.next = newNode;
        }
        this.rear = newNode;
        this.length++;
    }

    private int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        int result = this.front.data;
        front = front.next;
        if(front == null){
            this.rear = null;
        }
        this.length--;
        return result;

    }

    private int first(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        return this.front.data;
    }

    private int last(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty!");
        }
        return this.rear.data;
    }

    public static void main(String[] args) {

        Queue queue = new Queue();
        System.out.println("Enqueue test...");
        queue.enqueue(12);
        queue.enqueue(10);
        queue.enqueue(15);
        queue.display();
        System.out.println("First Element is: "+queue.first());
        System.out.println("Last Element is: "+queue.last());

        System.out.println("\nDeque test...");
        int removed = queue.dequeue();
        System.out.println("Removed node data : "+removed);
        queue.display();
    }
}
