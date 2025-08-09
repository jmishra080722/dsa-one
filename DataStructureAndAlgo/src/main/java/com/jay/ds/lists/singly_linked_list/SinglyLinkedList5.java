package com.jay.ds.lists.singly_linked_list;

public class SinglyLinkedList5 {

    private ListNode head;

    public static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    private void display(ListNode headNode){
        ListNode current = headNode;
        if(headNode == null){
            return;
        }
        while (current != null){
            System.out.print(current.data+" --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    private ListNode insertAtBeginning(ListNode head, int data){
        ListNode node = new ListNode(data);
        node.next = head;
        return node;
    }

    public ListNode mergeSortedLinkedList(ListNode node1, ListNode node2){
        System.out.println("This is mergeSortedLinkedList2 method");
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while(node1 != null && node2 != null){
            if(node1.data < node2.data){
                tail.next = node1;
                node1 = node1.next;
            }else{
                tail.next = node2;
                node2 = node2.next;
            }
            tail = tail.next;
        }
        if(node1 == null){
            tail.next = node2;
        }

        if(node2 == null){
            tail.next = node1;
        }
        return dummy.next;
    }

    public ListNode mergeSortedLinkedList2(ListNode node1, ListNode node2){
        System.out.println("This is mergeSortedLinkedList2 method");
        ListNode head  = null;
        if(node1.data < node2.data){
            head = node1;
            node1 = node1.next;
        }else {
            head = node2;
            node2 = node2.next;
        }
        ListNode tail = head;

    while (node1 != null && node2 != null){
        if(node1.data < node2.data){
            tail.next = node1;
            node1 = node1.next;
        }else{
            tail.next = node2;
            node2 = node2.next;
        }
        tail = tail.next;
    }
    if(node1 == null){
        tail.next = node2;
    }

    if(node2 == null){
        tail.next = node1;
    }
    return head;
    }

    private ListNode addLinkedList(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;
        while (node1 != null || node2 != null){
            int x = node1 != null ? node1.data : 0;
            int y = node2 != null ? node2.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            ListNode newNode  = new ListNode(sum%10);
            tail.next = newNode;
            tail = tail.next;
            if(node1 != null){
                node1 = node1.next;
            }
            if(node2 != null){
                node2 = node2.next;
            }
        }
        if(carry > 0){
            ListNode carryNode = new ListNode(carry);
            tail.next = carryNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList5 sll5 = new SinglyLinkedList5();
        ListNode listNode1 = sll5.insertAtBeginning(sll5.head, 9);
        ListNode listNode2 = sll5.insertAtBeginning(listNode1,7);
        ListNode listNode3 = sll5.insertAtBeginning(listNode2,5);
        ListNode listNode4 = sll5.insertAtBeginning(listNode3, 1);
        System.out.print("List 1: ");
        sll5.display(listNode4);

        ListNode listNode5 = sll5.insertAtBeginning(sll5.head, 8);
        ListNode listNode6 = sll5.insertAtBeginning(listNode5,6);
        ListNode listNode7 = sll5.insertAtBeginning(listNode6,4);
        ListNode listNode8 = sll5.insertAtBeginning(listNode7, 0);
        System.out.print("List 2: ");
        sll5.display(listNode8);

        /*ListNode mergedList = sll5.mergeSortedLinkedList(listNode4, listNode8);
        System.out.print("Merged List: ");
        sll5.display(mergedList);*/

        ListNode result = sll5.addLinkedList(listNode4, listNode8);
        System.out.println("Summation of two node is : ");
        sll5.display(result);
    }
}
