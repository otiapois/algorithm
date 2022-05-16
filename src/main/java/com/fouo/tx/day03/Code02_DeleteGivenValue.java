package com.fouo.tx.day03;

import java.util.LinkedList;

/**
 * @author KONGLH
 * @title: 把给定的数都删除
 * @projectName
 * @description:
 * @date  2022/4/11 14:07
 */
public class Code02_DeleteGivenValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node removeValue(Node head, int num) {
		while(head!=null){
			if(head.value==num){
				head = head.next;
			}else{
				break;
			}
		}
		Node cur = head;
		Node pre = head;
		while(cur!=null){
			if(cur.value == num){
				pre.next = cur.next;
			}else{
				pre = cur;
			}
			cur = cur.next;
		}
		return  pre;
	}

	// head = removeValue(head, 2);
	public static Node removeValue3(Node head, int num) {
		while(head!=null){
			if(head.value == num){
				head = head.next;
			}else{
				break;
			}
		}
		Node pre = head;
		Node cur = head;
		while(cur!=null){
			if(cur.value == num){
				pre.next = cur.next;
			}else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}



	public static Node test(Node head, int num){
		LinkedList<Node> list = new LinkedList<>();
		Node cur = head;
		while(cur!=null){
			list.add(cur);
			cur = cur.next;
		}

		list.removeIf(node -> {
			return node.value == num;
		});

		Node res = null;
		for(int i=0;i<list.size();i++){
			if(i==0){
				res = list.get(0);
			}
			if(i!=list.size()-1){
				list.get(i).next = list.get(i+1);
			}
			list.get(i).next = null;
		}
		return res;
	}



	public static Node removeValue1(Node head, int num) {
		// head来到第一个不需要删的位置
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		// 1 ) head == null
		// 2 ) head != null
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(1);
		Node node4 = new Node(2);
//		System.out.println(node1 == node2);
		node1.next = node2;
		node3.next = node4;
//		System.out.println(node1);
		Node node = removeValue(node1, 2);
		Node test = test(node3, 2);
		System.out.println(node.value==test.value);
	}
}
