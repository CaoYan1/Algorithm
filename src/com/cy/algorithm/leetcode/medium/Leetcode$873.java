package com.cy.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 题名 : 最长的斐波那契子序列的长度
 * 题目 : 如果序列 X_1, X_2, ..., X_n 满足下列条件，就说它是 斐波那契式 的：
 *     n >= 3
 *     对于所有 i + 2 <= n，都有 X_i + X_{i+1} = X_{i+2}
 * 给定一个严格递增的正整数数组形成序列，找到 A 中最长的斐波那契式的子序列的长度。如果一个不存在，返回  0 。
 * （回想一下，子序列是从原序列 A 中派生出来的，它从 A 中删掉任意数量的元素（也可以不删），而不改变其余元素的顺序。例如， [3, 5, 8] 是 [3, 4, 5, 6, 7, 8] 的一个子序列）
 *
 * 思路 : 用一个map记录每一个数字对应的索引,另一个map记录一i,j索引元素结尾的最大长度,然而遍历所以两个元素的组合,
 * 比如i,j最大长度就为j-i,i最大长度+1,如果j-i不存在长度就为2,记录i,j的长度的时候可以把i,j压缩成i*n+j,因为ij都小于
 * n所以不会存在两个不同的ij使i*n+j相同
 *
 * @author clay
 * @date 19-1-22 22:05
 */
public class Leetcode$873 {

    public static void main(String[] args){
        Solution s = new Leetcode$873().new Solution();
        System.out.println(s.lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }

    class Solution {
        public int lenLongestFibSubseq(int[] A) {
            int N = A.length;
            Map<Integer, Integer> index = new HashMap();
            for (int i = 0; i < N; ++i)
                index.put(A[i], i);

            Map<Integer, Integer> longest = new HashMap();
            int ans = 0;

            for (int k = 0; k < N; ++k)
                for (int j = 0; j < k; ++j) {
                    int i = index.getOrDefault(A[k] - A[j], -1);
                    if (i >= 0 && i < j) {
                        int cand = longest.getOrDefault(i * N + j, 2) + 1;
                        longest.put(j * N + k, cand);
                        ans = Math.max(ans, cand);
                    }
                }

            return ans >= 3 ? ans : 0;
        }
    }

}
