package com.jay.ds.lists.singly_linked_list;

public class SinglyLinkedList4 {

    public ListNode head;

    public static class ListNode{
        private int data;
        private ListNode next;

       public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void display(ListNode head){
        if(head == null){
            System.out.println("Null");
        }
        ListNode current = head;
        while (current != null){
            System.out.print(current.data+ " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    //In below method we assume list is sorted
    public void removeDuplicate(ListNode head){
        ListNode current = head;
        while (current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    public ListNode insertNewNodeInSortedLinkedList(ListNode head, ListNode newNode){
        if(head ==  null){
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;

        while (current != null && current.data < newNode.data){
            temp = current;
            current = current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    public ListNode deleteNode(ListNode head, int key){
        ListNode current = head;
        ListNode previous = null;

        if(current != null && current.data == key){
            head = current.next;
            return head;
        }

        while(current != null && current.data != key){
            previous = current;
            current = current.next;
        }
        if(current == null){
            return head;
        }
        previous.next = current.next;
        return head;
    }

    private boolean containsLoop(ListNode head){
        if(head == null){
            return false;
        }

        ListNode fastPtr= head;
        ListNode slowPtr = head;
        while(fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    private ListNode createALoopInLinkedList(){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth  =  new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        head.next  = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = third;
        return head;

    }

    private ListNode startNodeOfLoop(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        if(head == null){
            return null;
        }
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return getStartingNode(head, slowPtr);
            }
        }
        return null;
    }

    private ListNode getStartingNode(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (temp != slowPtr){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;   //Starting node of the loop of   SinglyLinkedList
    }

    public ListNode removeLoopFromLinkedList(ListNode head){
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        while (fastPtr != null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(fastPtr == slowPtr){
                return removeLoop(head, slowPtr);
            }
        }
        return head;
    }

    private ListNode removeLoop(ListNode head, ListNode slowPtr) {
        ListNode temp = head;
        while (temp.next != slowPtr.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode second = new ListNode(6);
        ListNode third = new ListNode(8);
        ListNode fourth  =  new ListNode(8);
        ListNode fifth = new ListNode(8);
        ListNode sixth = new ListNode(10);
        ListNode seventh = new ListNode(13);
        head.next  = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        SinglyLinkedList4 sll4 = new SinglyLinkedList4();
        sll4.display(head);

        /*sll4.display(head);
        sll4.removeDuplicate(head);
        sll4.display(head);*/

        /*sll4.insertNewNodeInSortedLinkedList(head, new ListNode(9));
        sll4.display(head);*/

        /*ListNode listNode = sll4.deleteNode(head, 3);
        sll4.display(listNode);*/


        boolean containsLoop = sll4.containsLoop(head);
        System.out.println("containsLoop : " +containsLoop);

        ListNode aLoopInLinkedList = sll4.createALoopInLinkedList();
        containsLoop = sll4.containsLoop(aLoopInLinkedList);
        System.out.println("containsLoop : " +containsLoop);

        /*ListNode startOfLoop = sll4.startNodeOfLoop(aLoopInLinkedList);
        System.out.println("Starting node of loop is: "+startOfLoop.data);*/

        ListNode listNode = sll4.removeLoopFromLinkedList(aLoopInLinkedList);
        sll4.display(listNode);


    }
}
