package com.fouo.tx.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author KONGLH
 * @title: 将一个多叉树转换成一个二叉树
 * @projectName
 * @description:
 * @date 2022/5/17 16:12
 */

// 本题测试链接：https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree
public class Code03_EncodeNaryTreeToBinaryTree {

    // 提交时不要提交这个类
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 提交时不要提交这个类
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // 只提交这个类即可
    class Codec {
        public TreeNode encode(Node root) {
            if (root == null) {
                return null;
            }
            TreeNode head = new TreeNode(root.val);
            head.left = en(root.children);
            return head;
        }

        private TreeNode en(List<Node> children) {
            TreeNode head = null;
            TreeNode cur = null;
            for (Node child : children) {
                TreeNode tNode = new TreeNode(child.val);
                if (head == null) {
                    head = tNode;
                } else {
                    cur.right = tNode;
                }
                cur = tNode;
                cur.left = en(child.children);
            }
            return head;
        }

        public Node decode(TreeNode root) {
            if (root == null) {
                return null;
            }
            return new Node(root.val, de(root.left));
        }

        private List<Node> de(TreeNode head) {
            List<Node> ans = new ArrayList<>();
            while (head != null) {
                Node node = new Node(head.val,de(head.left));
                ans.add(node);
                head = head.right;
            }
            return ans;
        }
//        // Encodes an n-ary tree to a binary tree.
//        public TreeNode encode(Node root) {
//            if (root == null) {
//                return null;
//            }
//            TreeNode head = new TreeNode(root.val);
//            head.left = en(root.children);
//            return head;
//        }
//
//        private TreeNode en(List<Node> children) {
//            TreeNode head = null;
//            TreeNode cur = null;
//            for (Node child : children) {
//                TreeNode tNode = new TreeNode(child.val);
//                if (head == null) {
//                    head = tNode;
//                } else {
//                    cur.right = tNode;
//                }
//                cur = tNode;
//                cur.left = en(child.children);
//            }
//            return head;
//        }
//
//        // Decodes your binary tree to an n-ary tree.
//        public Node decode(TreeNode root) {
//            if (root == null) {
//                return null;
//            }
//            return new Node(root.val, de(root.left));
//        }
//
//        public List<Node> de(TreeNode root) {
//            List<Node> children = new ArrayList<>();
//            while (root != null) {
//                Node cur = new Node(root.val, de(root.left));
//                children.add(cur);
//                root = root.right;
//            }
//            return children;
//        }

    }

}
