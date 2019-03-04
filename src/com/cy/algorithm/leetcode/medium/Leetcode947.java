package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题名 : 移除最多同行或同列的石头
 * 题目 : 在二维平面上，我们将石头放置在一些整数坐标点上。每个坐标点上最多只能有一块石头。
 * 现在，move 操作将会移除与网格上的某一块石头共享一列或一行的一块石头。
 * 我们最多能执行多少次 move 操作？
 *
 * 思路 : 并查集算法将所有同行或同列石头分成不同集合中,这里可以优化,把列加上一个比较大的值,使之与行不重复,
 * 并且可以合并到同一个树中. 每个集合只有一个石头无法移除
 * 执行时间 : 15ms
 *
 * @author clay
 * @date 18-12-18 20:34
 */
public class Leetcode947 {
    class Solution {
        public int removeStones(int[][] stones) {
            int[] parent = new int[20000];
            Arrays.fill(parent, -1);
            for(int[] pos : stones){
                insert(parent,pos[0],pos[1] + 10000);
            }

            Set<Integer> set = new HashSet<>();
            for(int[] pos : stones){
                set.add(root(parent, pos[0]));
            }
            return stones.length - set.size();
        }

        private void insert(int[] parent, int x, int y){
            int a = root(parent, x);
            int b = root(parent, y);
            if(a != b){
                parent[a] = b;
            }
        }

        private int root(int[] parent, int a){
            return parent[a] == -1 ? a : (parent[a] = root(parent, parent[a]));
        }
    }
}
