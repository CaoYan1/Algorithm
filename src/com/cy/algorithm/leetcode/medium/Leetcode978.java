package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 最长湍流子数组
 * 题目 : 当 A 的子数组 A[i], A[i+1], ..., A[j] 满足下列条件时，我们称其为湍流子数组：
 *     若 i <= k < j，当 k 为奇数时， A[k] > A[k+1]，且当 k 为偶数时，A[k] < A[k+1]；
 *     或 若 i <= k < j，当 k 为偶数时，A[k] > A[k+1] ，且当 k 为奇数时， A[k] < A[k+1]。
 * 也就是说，如果比较符号在子数组中的每个相邻元素对之间翻转，则该子数组是湍流子数组。
 * 返回 A 的最大湍流子数组的长度。
 *
 * 思路 : 动态规划,数据记录每个元素结尾的最长子数组
 *
 * @author clay
 * @date 19-1-20 10:40
 */
public class Leetcode978 {
    public static void main(String[] args){
        Solution s = new Leetcode978().new Solution();
        System.out.println(s.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
    }
    class Solution {
        public int maxTurbulenceSize(int[] A) {
            if(A == null || A.length <= 0){
                return 0;
            }
            int max = 1;
            int[][] dp = new int[A.length][2];
            dp[0][0] = dp[0][1] = 1;
            for(int i = 1; i < A.length; i++){
                if(A[i] > A[i - 1]){
                    dp[i][1] = dp[i-1][0] + 1;
                }else {
                    dp[i][1] = 1;
                }
                if(A[i] < A[i - 1]){
                    dp[i][0] = dp[i-1][1] + 1;
                }else {
                    dp[i][0] = 1;
                }
                max = Math.max(dp[i][1],Math.max(dp[i][0],max));
            }
            return max;
        }
    }
}
