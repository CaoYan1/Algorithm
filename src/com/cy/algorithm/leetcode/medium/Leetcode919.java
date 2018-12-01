package com.cy.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题名 : 完全二叉树插入器
 * 题目 :完全二叉树是每一层（除最后一层外）都是完全填充（即，结点数达到最大）的，并且所有的结点都尽可能地集中在左侧。
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 *     CBTInserter(TreeNode root) 使用头结点为 root 的给定树初始化该数据结构；
 *     CBTInserter.insert(int v) 将 TreeNode 插入到存在值为 node.val = v  的树中以使其保持完全二叉树的状态，并返回插入的 TreeNode 的父结点的值；
 *     CBTInserter.get_root() 将返回树的头结点。
 *
 * 思路 : 用队列存储所有子节点数为0的节点(广度优先直到队列头子节点数<2),
 * 新节点插入队列头的左/右,如果队列头节点左右都不为空则出队,新节点入队
 * 执行时间 : 90ms
 *
 * @author clay
 * @date 18-12-1 19:55
 */
public class Leetcode919 {

    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    class CBTInserter {

        private Queue<TreeNode> queue = new LinkedList<>();
        private TreeNode split = new TreeNode(-1);
        private int sum = 0;
        private TreeNode curNode;
        private TreeNode root;

        public CBTInserter(TreeNode root) {
            this.root = root;
            queue.offer(root);
            sum++;
            while (!queue.isEmpty()){
                curNode = queue.poll();
                if(curNode.right != null){
                    queue.add(curNode.left);
                    queue.add(curNode.right);
                    sum += 2;
                }else if(curNode.left != null){
                    queue.add(curNode.left);
                    sum++;
                    break;
                }else {
                    break;
                }
            }
        }

        public int insert(int v) {
            TreeNode node = new TreeNode(v);
            int ret = curNode.val;
            sum++;
            if(sum % 2 == 0){
                curNode.left = node;
            }else {
                curNode.right = node;
                curNode = queue.poll();
            }
            queue.offer(node);
            return ret;
        }

        public TreeNode get_root() {
            return root;
        }
    }

    public static void main(String ...args){
        TreeNode root = new Leetcode919().new TreeNode(0);
        CBTInserter inserter = new Leetcode919().new CBTInserter(root);
        System.out.println(inserter.insert(1));
        System.out.println(inserter.insert(2));
        System.out.println(inserter.insert(3));
        System.out.println(inserter.insert(4));
        System.out.println(inserter.insert(5));
    }
}
