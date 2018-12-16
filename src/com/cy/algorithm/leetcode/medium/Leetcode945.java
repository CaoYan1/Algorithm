package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 使数组唯一的最小增量
 * 题目 : 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 思路 : 先对数组排序,从左到右遍历,记录当前最大值last,如果A[i]>last 则最大值为A[i]
 * 如果A[i]<last 则需要移动last+1-A[i]次并且最大值变为A[i-1]+1
 * 执行时间 :
 *
 * @author clay
 * @date 18-12-16 21:17
 */
public class Leetcode945 {

    class Solution {
        public int minIncrementForUnique(int[] A) {
            if(A == null || A.length < 2){
                return 0;
            }
            Arrays.sort(A);
            int result = 0;
            int last = A[0];
            for(int i = 1;i < A.length; i++){
                if(A[i] > last){
                    last = A[i];
                }else {
                    last = last + 1;
                    result += (last - A[i]);
                }
            }
            return result;
        }
    }

    public static void main(String[] args){
        Solution solution = new Leetcode945().new Solution();
        int result = solution.minIncrementForUnique(new int[]{1,0});
        System.out.println(result);
    }
}
