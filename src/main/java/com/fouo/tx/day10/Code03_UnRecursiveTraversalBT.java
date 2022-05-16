package com.fouo.tx.day10;

import java.util.Stack;

public class Code03_UnRecursiveTraversalBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }

//	public static void pre(Node head) {
//		System.out.print("pre-order: ");
//		if (head != null) {
//			Stack<Node> stack = new Stack<>();
//			stack.add(head);
//			while (!stack.isEmpty()) {
//				head = stack.pop();
//				System.out.print(head.value + " ");
//				if (head.right != null) {
//					stack.push(head.right);
//				}
//				if (head.left != null) {
//					stack.push(head.left);
//				}
//			}
//		}
//		System.out.println();
//	}

    public static void pre(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);

            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");

                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
            System.out.println("");
        }
    }

    //1 2 3 4 5 6 7  ->  4 2 5 1 6 3 7
    //        1
    //     2     3
    //   4  5   6  7
    public static void in(Node cur) {
        System.out.print("in-order: ");
        if (cur != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || cur != null) {
                if (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                } else {
                    cur  = stack.pop();
                    System.out.print(cur.value+" ");
                    cur = cur.right;
                }
            }
            System.out.println();
        }
    }

    //    public static void in(Node cur) {
//        System.out.print("in-order: ");
//        if (cur != null) {
//            Stack<Node> stack = new Stack<>();
//            while (!stack.isEmpty() || cur != null) {
//                if (cur != null) {
//                    stack.push(cur);
//                    cur = cur.left;
//                } else {
//                    cur = stack.pop();
//                    System.out.print(cur.value + " ");
//                    cur = cur.right;
//                }
//            }
//        }
//        System.out.println();
//    }
    public static void pos1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
           Stack<Node> stack1 = new Stack<>();
           Stack<Node> stack2 = new Stack<>();
           stack1.add(head);
           while(!stack1.isEmpty()){
               head = stack1.pop();
               stack2.push(head);
               if(head.left!=null){
                   stack1.push(head.left);
               }
               if(head.right!=null){
                   stack1.push(head.right);
               }
           }

           while(!stack2.isEmpty()){
               System.out.print(stack2.pop().value+" ");
           }


            System.out.println();
        }
    }
//    public static void pos1(Node head) {
//        System.out.print("pos-order: ");
//        if (head != null) {
//            Stack<Node> s1 = new Stack<Node>();
//            Stack<Node> s2 = new Stack<Node>();
//            s1.push(head);
//            while (!s1.isEmpty()) {
//                head = s1.pop(); // 头 右 左
//                s2.push(head);
//                if (head.left != null) {
//                    s1.push(head.left);
//                }
//                if (head.right != null) {
//                    s1.push(head.right);
//                }
//            }
//            // 左 右 头
//            while (!s2.isEmpty()) {
//                System.out.print(s2.pop().value + " ");
//            }
//        }
//        System.out.println();
//    }

    public static void pos2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<Node>();
            stack.push(h);
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        pre(head);
        System.out.println("========");
        in(head);
        System.out.println("========");
        pos1(head);
        System.out.println("========");
        pos2(head);
        System.out.println("========");
    }

}
