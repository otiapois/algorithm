package com.fouo.xs.day06;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回树的最大深度
 *
 * @author fouo
 * @date 2021/12/8 23:39
 */
public class ContructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode buildTree1(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        return f(pre, 0, pre.length - 1, in, 0, in.length - 1);

    }

    public static TreeNode buildTree2(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return g(pre, 0, pre.length - 1, in, 0, in.length - 1, map);
    }

    public static TreeNode f(int[] pre, int left1, int right1, int[] in, int left2, int right2) {
        //左树 或者 右树为空
        if (left1 > right1) {
            return null;
        }
        //创建头节点
        TreeNode head = new TreeNode(pre[left1]);
        if (left1 == right1) {
            return head;
        }

        //找L1在 中序上的位置
        int find = left2;
        while (in[find] != pre[left1]) {
            find++;
        }
        //构建前序左树  中序左树
        head.left = f(pre, left1 + 1, left1 + find - left2, in, left2, find - 1);
        head.right = f(pre, left1 + find - left2 + 1, right1, in, find + 1, right2);
        return head;
    }

    /**
     * 可以省略掉遍历行为
     * 空间换时间  和f函数相比来说
     * @param pre
     * @param left1
     * @param right1
     * @param in
     * @param left2
     * @param right2
     * @param map
     * @return
     */
    public static TreeNode g(int[] pre, int left1, int right1, int[] in, int left2, int right2, Map<Integer, Integer> map) {
        //左树 或者 右树为空
        if (left1 > right1) {
            return null;
        }
        //创建头节点
        TreeNode head = new TreeNode(pre[left1]);
        if (left1 == right1) {
            return head;
        }

        //找L1在 中序上的位置
//        int find = left2;
//        while (pre[find] != pre[left1]) {
//            find++;
//        }

        int find = map.get(pre[left1]);
        //构建前序左树  中序左树
        head.left = g(pre, left1 + 1, left1 + find - left2, in, left2, find - 1,map);
        head.right = g(pre, left1 + find - left2 + 1, right1, in, find + 1, right2,map);
        return head;
    }

}
