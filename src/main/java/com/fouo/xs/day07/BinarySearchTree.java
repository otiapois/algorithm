package com.fouo.xs.day07;
/**
 * 搜索二叉树
 *
 * @author fouo
 * @date 2021/12/12 11:11
 */
public class BinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }


    public static class Info {
        public boolean isBST;
        public int max;
        public int min;

        public Info(boolean is, int ma, int mi) {
            isBST = is;
            max = ma;
            min = mi;
        }
    }

    public static Info process(TreeNode x) {
        if(x==null){
            return  null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);

        int max = x.val;
        int min = x.val;

        if(leftInfo!=null){
            max = Math.max(leftInfo.max, max);
            min = Math.max(leftInfo.min, max);
        }

        if(rightInfo!=null){
            max = Math.max(rightInfo.max, max);
            min = Math.max(rightInfo.min, max);
        }

        boolean isBST = true;
        if(leftInfo!=null && !leftInfo.isBST){
            isBST = false;
        }
        if(rightInfo!=null && !rightInfo.isBST){
            isBST = false;
        }

        boolean leftFlag = leftInfo == null ?true:(leftInfo.max<x.val);
        boolean rightFlag = rightInfo == null ?true:(rightInfo.min>x.val);
        if(!leftFlag || !rightFlag){
            isBST = false;
        }

        return new Info(isBST,max,min);
    }

   /* public static Info process(TreeNode x) {
        if(x==null){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        //判断当前节点的最小值最大值   整棵树的最大值 最小值
        if(leftInfo!=null){
            max =  Math.max(leftInfo.max, max);
            min =  Math.max(leftInfo.min, min);
        }

        if(rightInfo!=null){
            max =  Math.max(rightInfo.max, max);
            min =  Math.max(rightInfo.min, min);
        }

        boolean isBST = true;
        if(leftInfo!=null && !leftInfo.isBST){
            isBST = false;
        }

        if(rightInfo!=null && !rightInfo.isBST){
            isBST = false;
        }

        //左树的最大值 小于x   右树的最小值 大于x
        boolean leftLessMax = leftInfo == null?true:(leftInfo.max< x.val);
        boolean rightThanMin = rightInfo == null?true:(rightInfo.min> x.val);

        if(!leftLessMax || !rightThanMin){
            isBST = false;
        }
        return new Info(isBST,max, min);
    }*/

}
