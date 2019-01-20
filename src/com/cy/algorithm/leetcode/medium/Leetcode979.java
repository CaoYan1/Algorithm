package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 在二叉树中分配硬币
 * 题目 :给定一个有 N 个结点的二叉树的根结点 root，树中的每个结点上都对应有 node.val 枚硬币，并且总共有 N 枚硬币。
 * 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。(移动可以是从父结点到子结点，或者从子结点移动到父结点。)。
 * 返回使每个结点上只有一枚硬币所需的移动次数。
 *
 * 思路 : 递归,将硬币往上一层传,却硬币可以看做负数(即往下传)
 * @author clay
 * @date 19-1-20 10:57
 */
public class Leetcode979 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String[] args){
        TreeNode node = new Leetcode979().new TreeNode(3);
        node.left = new Leetcode979().new TreeNode(0);
        node.right = new Leetcode979().new TreeNode(0);
        Solution s = new Leetcode979().new Solution();
        System.out.println(s.distributeCoins(node));
    }
    class Solution {
        public int count = 0;
        public int doDistributeCoins(TreeNode root) {
            if(root == null){
                return 0;
            }
            int left = doDistributeCoins(root.left);
            int right = doDistributeCoins(root.right);
            root.val = root.val + left + right;
            count += Math.abs(left);
            count += Math.abs(right);
            return root.val - 1;
        }
        public int distributeCoins(TreeNode root){
           doDistributeCoins(root);
           return count;
        }
    }
}
