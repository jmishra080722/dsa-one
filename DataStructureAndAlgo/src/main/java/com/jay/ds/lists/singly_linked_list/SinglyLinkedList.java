package com.jay.ds.lists.singly_linked_list;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length(){
        if(head == null){
            return 0;
        }
        int noOfNodes = 0;
        ListNode current = head;
        while(current != null){
            noOfNodes++;
            current = current.next;
        }
        return noOfNodes;
    }



    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third  = new ListNode(8);
        ListNode fourth = new ListNode(11);

        //Connect all nodes all together
        sll.head.next = second;  // 10 --> 1
        second.next = third;  // 10 --> 1 --> 8
        third.next = fourth;  // 10 --> 1 --> 8 --> 11 --> null

        sll.display();

        System.out.println("Sll length is : "+sll.length());
    }
}
