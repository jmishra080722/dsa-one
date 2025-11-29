package com.jay.ds.trees;

import java.util.Stack;

public class BinarySearchTreeTwo {
    public TreeNode root;

    public static class TreeNode{
        public TreeNode left;
        public TreeNode right;
        public int data;

        public TreeNode(int value){
            this.data = value;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode insert(TreeNode root, int value){
        if(root == null){
            root = new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left, value);
        }else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    public void insert(int value){
        root = insert(root, value);
    }

    public static void main(String[] args) {
        BinarySearchTreeTwo bst2 = new BinarySearchTreeTwo();
        bst2.insert(5);
        bst2.insert(3);
        bst2.insert(7);
        bst2.insert(1);
        bst2.insert(8);
        bst2.insert(2);

        bst2.inOrderTraversalDisplay();

        System.out.println("\n");
        boolean valid = bst2.isValid(bst2.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("Above three is a valid Binary Search Tree ? " +valid);
    }

    private void inOrderTraversalDisplay(){
        inOrderTraversalDisplay(root);
    }

    private void inOrderTraversalDisplay(BinarySearchTreeTwo.TreeNode root){
        if(root == null){
            return;
        }
        Stack<BinarySearchTreeTwo.TreeNode> stack = new Stack<>();
        BinarySearchTreeTwo.TreeNode temp = root;
        while (!stack.isEmpty() || temp != null){
            if(temp != null){
                stack.push(temp);
                temp = temp.left;
            }else{
                temp = stack.pop();
                System.out.print(temp.data+" ");
                temp = temp.right;
            }
        }
    }


    public boolean isValid(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }
        if(root.data <= min || root.data >= max){
            return false;
        }

        boolean left = isValid(root.left, min, root.data);
        if(left){
            boolean right = isValid(root.right, root.data, max);
            return right;
        }
        return false;
    }
}
