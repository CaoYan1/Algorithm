package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 下降路径最小和
 * 题目 :给定一个方形整数数组 A，我们想要得到通过 A 的下降路径的最小和。
 * 下降路径可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列。
 *
 * 思路 : 动态规划,记录上一层最小的和,F[i][j] = min(F[i-1][j-1],F[i-1][j],F[i-1][j+1])+A[j])
 * 执行时间 : 10ms
 * @author clay
 * @date 18-12-2 19:10
 */
public class Leetcode931 {

    class Solution {
        public int minFallingPathSum(int[][] A) {
            if(A.length == 1){
                return A[0][0];
            }
            int col = A[0].length;
            int row = A.length;
            int[] dp1 = new int[col];
            int[] dp2 = new int[col];
            int[] temp;
            int result = Integer.MAX_VALUE;
            for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(j == 0){
                        dp2[j] = Math.min(dp1[j],dp1[j+1]) + A[i][j];
                    }else if(j == col - 1){
                        dp2[j] = Math.min(dp1[j],dp1[j-1]) + A[i][j];
                    }else {
                        dp2[j] = Math.min(dp1[j],Math.min(dp1[j-1],dp1[j+1])) + A[i][j];
                    }
                    if(i == row-1){
                        result = Math.min(dp2[j],result);
                    }
                }
                temp = dp1;
                dp1 = dp2;
                dp2 = temp;
            }
            return result;
        }
    }

    public static void main(String ...args){
        Solution s = new Leetcode931().new Solution();
        System.out.println(s.minFallingPathSum(new int[][]{{69}}));
    }
}
