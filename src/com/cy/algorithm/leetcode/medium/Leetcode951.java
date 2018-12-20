package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 翻转等价二叉树
 * 题目 : 我们可以为二叉树 T 定义一个翻转操作，如下所示：选择任意节点，然后交换它的左子树和右子树。
 * 只要经过一定次数的翻转操作后，能使 X 等于 Y，我们就称二叉树 X 翻转等价于二叉树 Y。
 * 编写一个判断两个二叉树是否是翻转等价的函数。这些树由根节点 root1 和 root2 给出。
 *
 * 思路 : 深度优先递归判断翻转和不翻转两种情况
 * 执行时间 : 4ms
 * @author clay
 * @date 18-12-20 20:07
 */
public class Leetcode951 {
    
     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    class Solution {
         public boolean flipEquiv(TreeNode root1, TreeNode root2) {
             if(root1 == null && root2 == null){
                 return true;
             }else if (root1 == null || root2 == null) {
                 return false;
             }else {
                 if (root1.val == root2.val){
                     return (flipEquiv(root1.left,root2.left) && flipEquiv(root1.right,root2.right))
                             || (flipEquiv(root1.left,root2.right) && flipEquiv(root1.right,root2.left));
                 }else {
                     return false;
                 }
             }
         }
    }
}
