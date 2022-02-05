package com.fouo.xs.day07;

/**
 * 判断树中路径问题
 *
 * @author fouo
 * @date 2021/12/12 12:09
 */
// 测试链接：https://leetcode.com/problems/path-sum
public class PathSum {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static boolean isSum = false;

    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        isSum = false;
        process(root, 0, sum);
        return isSum;
    }

    private static void process(TreeNode x, int preSum, int sum) {
        //判定x是叶子节点
        if (x.left == null && x.right == null) {
            boolean cur = (x.val + preSum) == sum;
            if (cur) {
                isSum = true;
            }
            return;
        }
        //判定x是非叶子节点情况
        preSum = x.val+preSum;
        if(x.left!=null){
            process(x.left,preSum,sum);
        }
        if(x.right!=null){
            process(x.right,preSum,sum);
        }
    }
}
