package com.jay.ds.trees;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class BinarySearchTree {

    private TreeNode root;

    private static class TreeNode{
        private int data;   //Any Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private void insert(int value){
        root = insert(root, value);
    }

    private TreeNode insert(TreeNode root, int value){
        if(root == null){
            root= new TreeNode(value);
            return root;
        }
        if(value < root.data){
            root.left = insert(root.left, value);
        }else {
            root.right = insert(root.right, value);
        }
        return root;
    }

    private void inOrderTraversalDisplay(){
        inOrderTraversalDisplay(root);
    }

    private void inOrderTraversalDisplay(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
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

    private boolean search(TreeNode root, int key){
        if(root == null){
            return false;
        }
        if(root.data ==key){
            return true;
        }

        if(key < root.data){
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(8);
        bst.insert(2);
        bst.inOrderTraversalDisplay();

        boolean nodePresent = bst.search(bst.root, 5);
        System.out.println("\nSearched Node present: "+ nodePresent);
    }
}
