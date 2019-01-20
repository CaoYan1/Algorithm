package com.cy.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 题名 : 有序数组的平方
 * 题目 : 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 * 思路 : 平方后直接排序
 * @author clay
 * @date 19-1-20 10:30
 */
public class Leetcode977 {
    class Solution {
        public int[] sortedSquares(int[] A) {
            int[] result = new int[A.length];
            for(int i = 0; i < A.length; i++){
                result[i] = A[i] * A[i];
            }
            Arrays.sort(result);
            return result;
        }
    }
}
