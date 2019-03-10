package com.cy.algorithm.leetcode.hard;

/**
 * 题名 : 先序遍历构造二叉树
 * 题目 : 返回与给定先序遍历 preorder 相匹配的二叉搜索树（binary search tree）的根结点。
 *
 * 思路 : 数组第一个为根结点,找到两边的结点然后递归
 * @author clay
 * @date 19-3-10 11:17
 */
public class Leetcode1008 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    class Solution {

         private TreeNode doBst(int[] pre, int from, int to){
             if (from > to){
                 return null;
             }
             if (from == to){
                 return new TreeNode(pre[from]);
             }
             TreeNode node = new TreeNode(pre[from]);
             int i;
             for (i = from + 1; i <= to; i++){
                 if (pre[i] > pre[from]){
                     break;
                 }
             }
             node.left = doBst(pre,from + 1,i-1);
             node.right = doBst(pre, i,to);
             return node;
         }

        public TreeNode bstFromPreorder(int[] preorder) {
            return doBst(preorder,0,preorder.length - 1);
        }
    }
}
