package com.fouo.xs.day06;

/**
 * 判断一个树为镜面树
 *
 * @author fouo
 * @date 2021/12/8 22:43
 */
public class SymmetricTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSymmetricTree(TreeNode head){
        return isMirror(head,head);
    }
    public static boolean isMirror(TreeNode h1, TreeNode h2) {

        if (h1 == null ^ h2 == null) {
            return false;
        }
        if (h1 == null & h2 == null) {
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left, h2.right) && isMirror(h1.right, h2.left);
    }
}
