package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 从结点开始的最小字符串
 * 题目 : 给定一颗根结点为 root 的二叉树，书中的每个结点都有一个从 0 到 25 的值，分别代表字母 'a' 到 'z'：值 0 代表 'a'，值 1 代表 'b'，依此类推。
 * 找出按字典序最小的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 *
 * 思路 : 递归左右子树的最小字符串
 * @author clay
 * @date 19-2-17 15:31
 */
public class Leetcode988 {

     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

    public static void main(String[] args) {
        System.out.println("cc".compareTo("abc"));
    }

    class Solution {
         public String smallestFromLeaf(TreeNode root) {
             char cur = (char)(97 + root.val);
             String left, right;
             if (root.left == null && root.right == null){
                 return "" + cur;
             }else if (root.right == null){
                 return smallestFromLeaf(root.left) + cur;
             }else if (root.left == null){
                 return smallestFromLeaf(root.right) + cur;
             }else {
                 left = smallestFromLeaf(root.left) + cur;
                 right = smallestFromLeaf(root.right) + cur;
                 return left.compareTo(right) > 0 ? right : left;
             }
         }
    }
}
