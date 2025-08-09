package com.jay.ds.lists.circular;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode{
        private int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList(){
        this.last = null;
        this.length = 0;
    }

    public int length(){
        return this.length;
    }

    public boolean isEmpty(){
        return this.length == 0;
    }

    public void createCircularSinglyLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void display(){
        if(last == null){
            return;
        }

        ListNode first = last.next;
        while (first != last){
            System.out.print(first.data +" --> ");
            first = first.next;
        }
        System.out.println(first.data);
    }

    public void insertFirst(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
        }else{
            newNode.next = last.next;
        }
        last.next = newNode;
        length++;
    }

    public void insertLast(int data){
        ListNode newNode = new ListNode(data);
        if(last == null){
            last = newNode;
        }else {
            newNode.next = last.next;
        }
        last.next = newNode;
        last = newNode;
        length++;
    }

    private int deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular linked list is empty!");
        }
        ListNode firstNode = last.next;
        if(last.next == last){
            last = null;
        }else{
            last.next = firstNode.next;
        }
        firstNode.next = null;
        length--;
        return firstNode.data;
    }

    private ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException("Circular linked list is empty!");
        }
        //ListNode firstNode = last.next;
        ListNode temp = last.next;
        ListNode lastNode = last;
        if(temp == last ){
            last = null;
        }else {
            while (temp.next != last ){
                temp = temp.next;
            }
            temp.next = last.next;
            last.next = null;
            last = temp;
        }
        length--;
        return lastNode;
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        //csll.createCircularSinglyLinkedList();
        //csll.display();

        //insertFirst test
        /*csll.insertFirst(3);
        csll.insertFirst(5);
        csll.insertFirst(8);
        csll.display();*/

        //insertLast test
        /*csll.insertLast(5);
        csll.insertLast(10);
        csll.insertLast(12);
        csll.insertLast(14);
        csll.display();*/

        //deleteFirst test
        /*csll.insertLast(45);
        csll.insertFirst(34);
        csll.insertFirst(23);
        csll.insertLast(50);
        csll.display();
        int deleteValue = csll.deleteFirst();
        System.out.println("deleteValue: "+deleteValue);
        csll.display();
        deleteValue = csll.deleteFirst();
        System.out.println("deleteValue: "+deleteValue);
        csll.display();*/


        //deleteLast test
        csll.insertFirst(45);
        csll.insertFirst(34);
        csll.insertFirst(23);
        csll.insertFirst(50);  //50->23->34->45
        csll.display();
        ListNode lastNode = csll.deleteLast();
        System.out.println("Deleted last node: "+lastNode.data);
        csll.display();
        lastNode = csll.deleteLast();
        System.out.println("Deleted last node: "+lastNode.data);
        csll.display();
        lastNode = csll.deleteLast();
        System.out.println("Deleted last node: "+lastNode.data);
        csll.display();

    }
}
