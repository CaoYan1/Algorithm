package com.cy.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 题名 : 所有可能的满二叉树
 * 题目 : 满二叉树是一类二叉树，其中每个结点恰好有 0 或 2 个子结点。
 * 返回包含 N 个结点的所有可能满二叉树的列表。 答案的每个元素都是一个可能树的根结点。
 * 答案中每个树的每个结点都必须有 node.val=0。
 * 你可以按任何顺序返回树的最终列表。
 *
 * 思路 : 递归左右子树
 * 执行时间 : 8ms
 *
 * @author clay
 * @date 18-11-25 20:23
 */
public class Leetcode894 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if(N%2 == 0){
            return new LinkedList<>();
        }
        if(N <= 0){
            return new LinkedList<>();
        }
        if(map.containsKey(N)){
            return map.get(N);
        }else {

            List<TreeNode> result = new LinkedList<>();
            if(N == 1){
                result.add(new TreeNode(0));
            }else {
                for(int i = 0; i < N; i++){
                    int j = N - 1 - i;
                    for(TreeNode left : allPossibleFBT(i)){
                        for(TreeNode right : allPossibleFBT(j)){
                            TreeNode node = new TreeNode(0);
                            node.left = left;
                            node.right = right;
                            result.add(node);
                        }
                    }
                }
                map.put(N,result);
            }
            return result;
        }
    }
}
