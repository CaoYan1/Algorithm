package com.cy.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题名 : 二叉树的完全性检验
 * 题目 : 给定一个二叉树，确定它是否是一个完全二叉树。
 * 百度百科中对完全二叉树的定义如下：
 * 若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
 *
 * 思路 : 广度优先搜索,直到最后一层(左右结点有一个为空)用变量记录下来,然后如果已经是最后一层,
 * 后面的结点不能有子结点,否则就不是完全的
 *
 * @author clay
 * @date 18-12-28 20:31
 */
public class Leetcode958 {

    public static void main(String[] args){
        Solution s = new Leetcode958().new Solution();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(s.isCompleteTree(root));
    }

     static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
     }

    class Solution {
        public boolean isCompleteTree(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            boolean bottom = false;
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.left == null){
                    bottom = true;
                    if(node.right != null){
                        return false;
                    }
                }else if(bottom){
                    return false;
                }else if(node.right == null){
                    queue.offer(node.left);
                    bottom = true;
                }else {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            return true;
        }
    }
}
