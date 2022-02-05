package com.fouo.xs.day06;

import sun.reflect.generics.tree.Tree;

/**
 * 判断两颗树相等
 *
 * @author fouo
 * @date 2021/12/8 22:32
 */
public class SameTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        //两个树有一个为空一个不为空返回true    两个都为空 或两个都不为空 返回false
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null & q == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
