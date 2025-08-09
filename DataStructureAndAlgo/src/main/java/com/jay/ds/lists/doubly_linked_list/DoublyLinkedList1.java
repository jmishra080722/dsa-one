package com.jay.ds.lists.doubly_linked_list;

import java.util.NoSuchElementException;

public class DoublyLinkedList1 {
    private ListNode head;
    private ListNode tail;
    private int length;


    public class ListNode{
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }
    public DoublyLinkedList1(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return this.length == 0;  //Or this.head == null
    }

    public int length(){
        return this.length;
    }

    public void insertLast(int value){
        ListNode newNode = new ListNode(value);
        if(isEmpty()){
            head = newNode;
        }else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    private void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            tail = newNode;
        }else {
            head.previous = newNode;
            newNode.next = head;
        }
        head = newNode;
        length++;
    }

    private ListNode deleteFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("Linked list is empty!");
        }
        ListNode temp = head;
        if(head == tail){
            tail = null;
        }else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }

    private ListNode deleteLast(){
        if(isEmpty()){
            throw new NoSuchElementException("List is empty!");
        }
        ListNode temp = tail;
        if(head == tail){
            head = null;
        } else {
            tail.previous.next = null;
        }
        tail = tail.previous;
        temp.previous = null;
        length--;
        return temp;
    }

    public void displayForward(){
        if(head == null){
            return;
        }
        System.out.print("Forward: ");
        ListNode temp = head;
        while (temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward(){
        if(tail == null){
            return;
        }
        System.out.print("Backward: ");
        ListNode temp = tail;
        while (temp != null){
            System.out.print(temp.data+" --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        DoublyLinkedList1 dll1 = new DoublyLinkedList1();
        //insertLast test
        /*dll1.insertLast(4);
        dll1.insertLast(7);
        dll1.insertLast(9);
        dll1.insertLast(10);
        dll1.displayForward();
        dll1.displayBackward();*/

        //insertFirst test
        /*dll1.insertFirst(1);
        dll1.insertFirst(10);
        dll1.insertFirst(12);
        dll1.displayForward();
        dll1.displayBackward();*/

        //deleteFirst test
        /*dll1.insertLast(4);
        dll1.insertLast(7);
        dll1.insertLast(9);
        dll1.insertLast(10);
        dll1.displayForward();
        ListNode deletedNode = dll1.deleteFirst();
        System.out.println("DeletedNode data: "+deletedNode.data);
        deletedNode = dll1.deleteFirst();
        System.out.println("DeletedNode data: "+deletedNode.data);
        dll1.displayForward();*/

        //deleteLast test
        dll1.insertLast(4);
        dll1.insertLast(7);
        dll1.insertLast(9);
        dll1.insertLast(10);
        dll1.displayForward();
        ListNode deletedNode = dll1.deleteLast();
        System.out.println("Deleted node: "+ deletedNode.data);
        deletedNode = dll1.deleteLast();
        System.out.println("Deleted node: "+ deletedNode.data);
        dll1.displayForward();
    }

}
