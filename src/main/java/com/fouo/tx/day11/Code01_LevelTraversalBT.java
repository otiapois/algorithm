package com.fouo.tx.day11;

import java.util.LinkedList;
import java.util.Queue;
/**
 * @author KONGLH
 * @title: 树按层遍历
 * @projectName
 * @description:
 * @date  2022/5/16 9:27
 */
public class Code01_LevelTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

    public static void level(Node head) {
        if (head == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
		queue.add(head);

		while(!queue.isEmpty()){
			Node poll = queue.poll();
			System.out.println(poll.value);
			if(poll.left!=null){
				queue.add(poll.left);
			}
			if(poll.right!=null){
				queue.add(poll.right);
			}
		}
    }
//	public static void level(Node head) {
//		if (head == null) {
//			return;
//		}
//		Queue<Node> queue = new LinkedList<>();
//		queue.add(head);
//		while (!queue.isEmpty()) {
//			Node cur = queue.poll();
//			System.out.println(cur.value);
//			if (cur.left != null) {
//				queue.add(cur.left);
//			}
//			if (cur.right != null) {
//				queue.add(cur.right);
//			}
//		}
//	}

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        level(head);
        System.out.println("========");
    }

}
