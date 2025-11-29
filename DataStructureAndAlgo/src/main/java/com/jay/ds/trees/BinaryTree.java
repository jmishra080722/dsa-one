package com.jay.ds.trees;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {
    private TreeNode root;

    public static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private int data;   //This can be any Generic type

        TreeNode(int data){
            this.data = data;
            this.left  = null;
            this.right = null;
        }
    }

    public void createBinaryTree(){
        TreeNode first  = new TreeNode(1);
        TreeNode  second = new TreeNode(2);
        TreeNode third  = new TreeNode(3);
        TreeNode fourth  = new TreeNode(4);
        TreeNode fifth  = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.right = sixth;
    }

    //Recursive way
    /*public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }*/

    //Iterative way
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
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

    //Recursive  way
    /*public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
    }*/

    //Iterative way
    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode  temp = root;
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

    //Recursive way
    /*public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }*/

    //Iterative way: https://www.youtube.com/watch?v=uigaktgcQWU&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=109
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (!stack.isEmpty() || current != null ){
            if(current !=null){
                stack.push(current);
                current = current.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    System.out.print(temp.data+" ");
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        System.out.print(temp.data+" ");
                    }
                }else {
                    current = temp;
                }
            }
        }
    }

    private void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            System.out.print(temp.data+" ");
            if(temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        System.out.print("PreOrder: ");
        bt.preOrder(bt.root);

        System.out.print("\n\nInOrder: ");
        bt.inOrderTraversal(bt.root);

        System.out.print("\n\nPostOrder: ");
        bt.postOrder(bt.root);

        System.out.print("\n\nLevel Order Traversal: ");
        bt.levelOrderTraversal(bt.root);
    }

}
