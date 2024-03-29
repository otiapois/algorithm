package com.fouo.tx.day09;

import java.util.Stack;

/**
 * @author KONGLH
 * @title: 判断是否是回文字链表
 * @projectName
 * @description:
 * @date 2022/5/9 11:01
 */
public class Code02_IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    // need n extra space
//	public static boolean isPalindrome1(Node head) {
//		Stack<Node> stack = new Stack<>();
//		Node cur = head;
//		while (cur != null) {
//			stack.push(cur);
//			cur = cur.next;
//		}
//		while (head != null) {
//			if (head.value != stack.pop().value) {
//				return false;
//			}
//			head = head.next;
//		}
//		return true;
//	}
    public static boolean isPalindrome1(Node head) {
        Stack<Integer> stack = new Stack();
        Node cur = head;
        boolean res = true;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }

        while (head != null) {
            if (head.value != stack.pop()) {
                return false;
            }
            head = head.next;
        }
        return res;
    }

    // need n/2 extra space
//    public static boolean isPalindrome2(Node head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//        Node right = head.next;
//        Node cur = head;
//        // 0 1 2 3 4 right 中点右边 或者 中下  例 将3 4加入栈中
//        while (cur.next != null && cur.next.next != null) {
//            right = right.next;
//            cur = cur.next.next;
//        }
//        Stack<Node> stack = new Stack<>();
//        while (right != null) {
//            stack.push(right);
//            right = right.next;
//        }
//        // 0 1 1 0     stack (1 0)
//        while (!stack.isEmpty()) {
//            if (head.value != stack.pop().value) {
//                return false;
//            }
//            head = head.next;
//        }
//        return true;
//    }
    public static boolean isPalindrome2(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node right = head.next;
        Node cur = head;

        while (cur.next != null && cur.next.next != null) {
            right = right.next;
            cur = cur.next.next;
        }

        Stack<Integer> stack = new Stack<>();
        while (right != null) {
            stack.push(right.value);
            right = right.next;
        }
        boolean res = true;

        while (!stack.isEmpty()) {
            if (head.value != stack.pop()) {
                res = false;
            }
            head = head.next;
        }

        return res;
    }

    // need O(1) extra space
//    public static boolean isPalindrome3(Node head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        Node n1 = head;
//        Node n2 = head;
//        while (n2.next != null && n2.next.next != null) { // find mid node
//            n1 = n1.next; // n1 -> mid
//            n2 = n2.next.next; // n2 -> end
//        }
//        // n1 中点
//
//
//        n2 = n1.next; // n2 -> right part first node
//        n1.next = null; // mid.next -> null
//        Node n3 = null;
//        while (n2 != null) { // right part convert
//            n3 = n2.next; // n3 -> save next node
//            n2.next = n1; // next of right node convert
//            n1 = n2; // n1 move
//            n2 = n3; // n2 move
//        }
//
//        n3 = n1; // n3 -> save last node
//        n2 = head;// n2 -> left first node
//        boolean res = true;
//        while (n1 != null && n2 != null) { // check palindrome
//            if (n1.value != n2.value) {
//                res = false;
//                break;
//            }
//            n1 = n1.next; // left to mid
//            n2 = n2.next; // right to mid
//        }
//
//        n1 = n3.next;
//        n3.next = null;
//        while (n1 != null) { // recover list
//            n2 = n1.next;
//            n1.next = n3;
//            n3 = n1;
//            n1 = n2;
//        }
//
//        return res;
//    }
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }

        // 0 1
        Node n1 = head;
        Node n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }

        Node n3;
        n2 = n1.next;
        n1.next = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // n1tail n2head
        n2 = head;
        // 记录最后一个节点
        n3 = n1;
        boolean res = true;
        while (n1 != null && n2 != null) {
            if (n1.value != n2.value) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }

        n2 = null;
        while (n3 != null) {
            n1 = n3.next;
            n3.next = n2;
            n2 = n3;
            n3 = n1;
        }
        return res;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

}
