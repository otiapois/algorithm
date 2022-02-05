package com.fouo.xs.day07;

import sun.plugin.javascript.navig.Link;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 测试链接：https://leetcode.com/problems/binary-tree-level-order-traversal-ii

/**
 * 将树返回成一个list 按照每层封装
 * 二叉树的层序遍历 II
 * @author fouo
 * @date 2021/12/11 21:59
 */
public class BinaryTreeLevelOrderTraversalII {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curAns.add(cur.val);

                if(cur.left!=null){
                    queue.add(cur.left);
                }
                if(cur.right!=null){
                    queue.add(cur.right);
                }
            }
            ans.add(0,curAns);
        }
        return ans;
    }


//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> ans = new LinkedList<>();
//        if (root == null) {
//            return ans;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        //先将头结点加入到队列中去
//        queue.add(root);
//        while(!queue.isEmpty()){
//            //先获取队列中数量，以决定接下来需要做的行为
//            int size = queue.size();
//            LinkedList<Integer> curAns = new LinkedList<>();
//
//            for(int i=0;i<size;i++){
//                TreeNode curNode = queue.poll();
//                curAns.add(curNode.val);
//                if(curNode.left!=null){
//                    queue.add(curNode.left);
//                }
//                if(curNode.right!=null){
//                    queue.add(curNode.right);
//                }
//            }
//            ans.add(0,curAns);
//        }
//        return ans;
//    }
}
