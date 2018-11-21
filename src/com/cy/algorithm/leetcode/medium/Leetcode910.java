package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 最小差值II
 * 题目 : 给定一个整数数组 A，对于每个整数 A[i]，我们可以选择 x = -K 或是 x = K，并将 x 加到 A[i] 中。
 * 在此过程之后，我们得到一些数组 B。
 * 返回 B 的最大值和 B 的最小值之间可能存在的最小差值。
 *
 * 思路 : 先排序然后找到分割点
 * 执行时间 : 16ms
 * @author clay
 * @date 18-11-21 18:47
 */
public class Leetcode910 {

    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int result = A[n-1] - A[0];
        for(int i = 0; i+1 < n; i++){
            result = Math.min(Math.max(A[i] + K, A[n-1]-K) - Math.min(A[0]+K,A[i+1]-K),result);
        }
        return result;
    }

    public static void main(String ...args){
        Leetcode910 l = new Leetcode910();
        System.out.println(l.smallestRangeII(new int[]{1,3,5,13},5));
    }

}
