package com.fouo.xs.day06;

/**
 * 二叉树
 * 前序  是  上 左 右
 * 中序  是  左 上 右
 * 后序  是  左 右 上
 * @author fouo
 * @date 2021/12/8 21:29
 */
public class TraversalBinaryTree {

    public  static class Node{
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void f(Node head){
        if(head ==null){
            return;
        }
        //1
        f(head.left);
        //2
        f(head.right);
        //3


    }

    /**
     * 二叉树前序打印
     * @param head
     */
    public static void pre(Node head){
        if(head == null){
            return ;
        }
        System.out.println(head.value);
        pre(head.left);
        pre(head.right);
    }

    /**
     * 二叉树中序打印
     * @param head
     */
    public static void in(Node head){
        if(head == null){
            return ;
        }
        in(head.left);
        System.out.println(head.value);
        in(head.right);
    }

    /**
     * 二叉树后序打印
     * @param head
     */
    public static void post(Node head){
        if(head == null){
            return ;
        }
        post(head.left);
        post(head.right);
        System.out.println(head.value);

    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

    }

}
