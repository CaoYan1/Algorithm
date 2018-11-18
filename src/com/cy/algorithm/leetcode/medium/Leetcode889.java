package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 题名 : 根据前序和后序遍历构造二叉树
 * 题目 : 返回与给定的前序和后序遍历匹配的任何二叉树。
 *  pre 和 post 遍历中的值是不同的正整数。
 *
 *  思路 : pre[0] = post[N-1],pre[1]是左子树头结点,post[N-2]是右子树头结点,找到分割点递归
 * 执行时间 : 15ms
 * @author clay
 * @date 18-11-14 14:57
 */
public class Leetcode889 {


     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int N = pre.length;
        if(N == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if(N == 1){
            return root;
        }
        int l = -1;
        for(int i = 0; i < N; i++){
            if(post[i] == pre[1]){
                l = i;
            }
        }
        root.left = constructFromPrePost(Arrays.copyOfRange(pre,1,l+2),
                Arrays.copyOfRange(post,0,l+1));
        root.right = constructFromPrePost(Arrays.copyOfRange(pre,l+2,N),
                Arrays.copyOfRange(post,l+1,N-1));
        return root;
    }

    public static void main(String []args){
        Leetcode889 l = new Leetcode889();
        TreeNode root = l.constructFromPrePost(new int[]{1,2,4,5,3,6,7},
                new int[]{4,5,2,6,7,3,1});
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null){
                continue;
            }
            queue.offer(node.left);
            queue.offer(node.right);
            System.out.print("" + node.val + " ");

        }
    }

}
