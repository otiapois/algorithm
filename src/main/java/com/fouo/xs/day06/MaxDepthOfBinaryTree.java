package com.fouo.xs.day06;
/**
 * 返回树的最大深度
 *
 * @author fouo
 * @date 2021/12/8 23:39
 */
public class MaxDepthOfBinaryTree {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }
    public static int maxDepth(TreeNode root){
        if(root ==null){
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }

}
