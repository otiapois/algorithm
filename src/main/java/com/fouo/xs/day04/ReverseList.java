package com.fouo.xs.day04;

/**
 * 反转链表
 *
 * @author fouo
 * @date 2021/11/25 20:40
 */
public class ReverseList {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;
        public DoubleNode next;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    /**
     * 链表反转
     * 边界条件是head不等于空
     *
     * 就是把节点后指向转向前面
     * @param head
     * @return
     */
    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 双向列表反转
     * 就是把节点后指向转向前面
     *            前指向转向后面
     * @param head
     * @return
     */
    public static DoubleNode reverseLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node.next = node2;
        node2.next = node3;
        System.out.println(reverseLinkedList(node).value);

    }
}
