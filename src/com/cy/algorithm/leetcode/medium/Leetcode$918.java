package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 环形数组的最大和
 * 题目 : 给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。
 * 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，而当 i >= 0 时 C[i+A.length] = C[i]）
 * 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, k2 <= j 其中 k1 % A.length = k2 % A.length）
 *
 * 思路 : 分两种情况,一种是结果在数组中间(不跨越边界),直接使用动态规划得到最大值,一种是结果在两端,
 * 当为这种情况是,不在结果中的其它元素之和一定是数组的连续最小和(此时最大值为 数组和-最小和),
 * 最后再判断是否全为负.
 * 执行时间 : 12ms
 * @author clay
 * @date 18-11-22 14:44
 */
public class Leetcode$918 {

    public int maxSubarraySumCircular(int[] A) {
        int lastMin,lastMax,min,max,sum;
        min = max = lastMax = lastMin = sum = A[0];
        for(int i = 1; i < A.length; i++){
            if(lastMax > 0){
                lastMax += A[i];
            }else {
                lastMax = A[i];
            }
            if(lastMin < 0){
                lastMin += A[i];
            }else {
                lastMin = A[i];
            }
            if(lastMax > max){
                max = lastMax;
            }
            if(lastMin < min){
                min = lastMin;
            }
            sum += A[i];
        }
        if(max < 0){
            return max;
        }
        return Math.max(sum - min, max);
    }

    public static void main(String ...args){
        Leetcode$918 l = new Leetcode$918();
        System.out.println(l.maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
