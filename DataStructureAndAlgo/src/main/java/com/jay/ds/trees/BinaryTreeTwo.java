package com.jay.ds.trees;

import com.sun.source.tree.Tree;

import java.util.Stack;

public class BinaryTreeTwo {
    private TreeNode root;

    private static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;

        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    private void createTreeNode(){
        TreeNode first  = new TreeNode(4);
        TreeNode second = new TreeNode(3);
        TreeNode third  = new TreeNode(6);
        first.left = second;
        first.right = third;

        TreeNode fourth  = new TreeNode(7);
        second.left = fourth;

        TreeNode fifth  = new TreeNode(9);
        TreeNode sixth = new TreeNode(1);
        third.left = fifth;
        third.right = sixth;

        this.root = first;
    }

    //Iterative way
    private void preOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
        if(temp.right != null){
            stack.push(temp.right);
        }
        if(temp.left != null){
            stack.push(temp.left);
        }
        }
    }

    private int findMax(TreeNode root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        int result = root.data;
        int leftMax = findMax(root.left);
        int rightMax = findMax(root.right);
        if(leftMax > result){
            result = leftMax;
        }
        if(rightMax > result){
            result = rightMax;
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTreeTwo bt2 = new BinaryTreeTwo();
        bt2.createTreeNode();
        bt2.preOrderTraversal(bt2.root);
        int max = bt2.findMax(bt2.root);
        System.out.println("\nLargest element in the tree is: "+ max);
    }
}
