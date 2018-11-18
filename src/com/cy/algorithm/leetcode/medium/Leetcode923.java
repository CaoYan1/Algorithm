package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 三数之和的多种可能
 * 题目 : 给定一个整数数组 A，以及一个整数 target 作为目标值，
 * 返回满足 i < j < k 且 A[i] + A[j] + A[k] == target 的元组 i, j, k 的数量。
 * 由于结果会非常大，请返回 结果除以 10^9 + 7 的余数。
 * 思路 : 动态规划,F(i,j,n)代表使用前i个数中选n+1个数,和为j的数量,则F(i,j,n) = F(i-1,j,n)+F(i-1,j-A[i],n-1)
 * 执行时间 :161ms
 * @author clay
 * @date 18-11-11 15:22
 */
public class Leetcode923 {

    public static int threeSumMulti(int[] A, int target) {
        int [][][]dp = new int[A.length+1][target+1][4];
        int mod = 1000000000 + 7;
        //初始化第一列
        for(int i = 0; i < A.length; i++){
            dp[i][0][0] = 1;
        }

        for(int i = 1; i <= A.length; i++){
            for(int j = 0; j <= target; j++){
                for(int k = 1; k <= 3; k++){
                    dp[i][j][k] = dp[i-1][j][k];
                    if(j >= A[i-1]){
                        dp[i][j][k]+=dp[i-1][j-A[i-1]][k-1];
                    }
                    dp[i][j][k] %= mod;
                }
            }
        }

        return dp[A.length][target][3];
    }

    public static void main(String ...args){
        int A[] = {0,0,0};
        System.out.println(threeSumMulti(A,0));
    }
}
