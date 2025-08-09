package com.jay.ds.lists.singly_linked_list;

public class SinglyLinkedList3 {
    public ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            next = null;
        }
    }

    private void display(ListNode head){
        ListNode current = head;
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public ListNode reverse(ListNode head){
        if(head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode findMiddleNode(ListNode head){
        if(head == null){
            return head;
        }
        ListNode slowPtr = head;
        ListNode fastPtr =  head;
        while (fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public void insertAtEnd(ListNode head, int data){
        ListNode node = new ListNode(data);
        if(head == null){
            head = node;
            return;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
    }


    //We assume n is less that SLL length, In real world need to validate
    public ListNode getNthNodeFromEnd(ListNode head, int n){
        if(head == null){
            return null;
        }
        if(n < 0){
            throw new IllegalArgumentException("Invalid value of n: "+n);
        }

        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while (count < n){
            if(refPtr == null){
                throw new IllegalArgumentException(n+" is grater than the number of nodes in list!");
            }
            refPtr = refPtr.next;
            count++;
        }

        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(8);
        ListNode third = new ListNode(1);
        ListNode fourth = new ListNode(11);
        head.next = second;
        second.next = third;
        third.next = fourth;

        SinglyLinkedList3 sll3 = new SinglyLinkedList3();
        System.out.println("Original SLL: ");
        sll3.display(head);

        /*ListNode reversedSll = sll3.reverse(head);
        System.out.println("Reversed SLL: ");
        sll3.display(reversedSll);*/

       /* ListNode middleNode = sll3.findMiddleNode(head);
        System.out.println("MiddleNode is: "+ middleNode.data);*/
        sll3.insertAtEnd(head, 19);
        sll3.insertAtEnd(head, 5);
        sll3.insertAtEnd(head, 4);
        sll3.display(head);
        /*ListNode middleNode1 = sll3.findMiddleNode(head);
        System.out.println("MiddleNode is: "+ middleNode1.data);*/

        ListNode node = sll3.getNthNodeFromEnd(head, 3);
        System.out.println("Third Node from last is - "+node.data);
    }
}
