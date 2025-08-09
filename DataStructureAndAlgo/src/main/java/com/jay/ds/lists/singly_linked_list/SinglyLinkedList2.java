package com.jay.ds.lists.singly_linked_list;

public class SinglyLinkedList2 {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int value){
            this.data = value;
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

    public void insertFirstNode(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //Assume position is correct and start from 1, In real world validate the position by calculating the length of SinglyLinedList
    public void insert(int data, int position){
        ListNode node = new ListNode(data);
        if(position == 1){
            node.next = head;
            head = node;
        }else{
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = node;
            node.next = current;
        }
    }

    public void insertAtEnd(int value){
        ListNode node = new ListNode(value);
        if(head == null ){
            head = node;
            return;
        }
        ListNode current = head;
        while (current.next != null){
            current = current.next;
        }
        current.next = node;
    }

    public ListNode deleteFirst(){
        if(head == null){
          return null;
       }

      ListNode temp = head;
      head = head.next;
      temp.next = null;
      return temp;
    }

    //Assuming position is valid and start form 1. In real world need to validate position by count number of node in SinglyListList.
    public  void delete(int position){
        if(position == 1){
            head = head.next;
        }else{
            ListNode previous = head;
            int count = 1;
            while (count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            previous.next = current.next;
            current.next = null;
        }
    }

    public ListNode deleteLast(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null){  //If current node is not last node, move forward
            previous = current;
            current = current.next;
        } //When Current node is last node, break the connection between previous and current
        previous.next = null;
        return current;
    }

    public boolean find(ListNode head, int searchKey){
        if(head == null){
            return false;
        }
        ListNode current = head;
        while (current != null){
            if(current.data == searchKey){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void main(String[] args) {
        SinglyLinkedList2 sll2 = new SinglyLinkedList2();

        /*sll2.insertFirstNode(11);
        sll2.display();
        sll2.insertFirstNode(8);
        sll2.display();
        sll2.insertFirstNode(6);
        sll2.display();

        sll2.insertAtEnd(20);
        sll2.display();

        sll2.insertFirstNode(6);
        sll2.display();

        sll2.insertAtEnd(2);
        sll2.display();

        sll2.insert(9, 1);
        sll2.display();

        sll2.insert(5, 4);
        sll2.insert(7, 6);
        sll2.display();

        System.out.println("DeletedNode :"+ sll2.deleteFirst().data);
        System.out.println("DeletedNode :"+ sll2.deleteFirst().data);
        sll2.display();

        System.out.println("Deleted last node: "+sll2.deleteLast().data);
        sll2.display();

        sll2.insert(11, 4);
        sll2.insert(15, 5);
        sll2.display();

        sll2.delete(3);
        sll2.display();
        sll2.delete(4);
        sll2.display();*/


        sll2.insertFirstNode(11);
        sll2.insertFirstNode(8);
        sll2.insertFirstNode(6);
        sll2.insertAtEnd(20);
        sll2.display();

        int searchKey = 6;
        System.out.println("Is "+searchKey+" present in SinglyLinkedList ? " +sll2.find(null, searchKey));
        System.out.println("Is "+searchKey+" present in SinglyLinkedList ? " +sll2.find(sll2.head, searchKey));
    }
}
