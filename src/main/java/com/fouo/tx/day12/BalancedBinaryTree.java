package com.fouo.tx.day12;

/**
 * 查询是否是平衡二叉树
 *
 * @author fouo
 * @date 2021/12/11 22:56
 */
// 测试链接：https://leetcode.com/problems/balanced-binary-tree
public class BalancedBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isBalance(TreeNode root){
        return process(root).isBalanced;
    }
    //以某个节点为头的时候， 1)整棵树是否平 2)整棵树的高度是什么
    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public static Info process(TreeNode root) {

        //当空数的时候是平衡的 高度是0
        if (root == null) {
            return new Info(true, 0);
        }
        //当root不为空时
        //左树
        Info leftInfo = process(root.left);
        //右树
        Info rightInfo = process(root.right);
        //取左右树中最大树的高度再加1就为整体树高
        Integer height = Math.max(leftInfo.height, rightInfo.height) + 1;
        //左树是平衡的  右树是平衡的 左右两个树的差的绝对值得小于2
        boolean isBalance = leftInfo.isBalanced && rightInfo.isBalanced && Math.abs(leftInfo.height - rightInfo.height) < 2;

        return new Info(isBalance, height);


    }


}
