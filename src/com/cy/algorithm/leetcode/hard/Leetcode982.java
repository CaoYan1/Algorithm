package com.cy.algorithm.leetcode.hard;

/**
 * 题名 : 按位与为零的三元组
 * 题目 : 给定一个整数数组 A，找出索引为 (i, j, k) 的三元组，使得：
 *     0 <= i < A.length
 *     0 <= j < A.length
 *     0 <= k < A.length
 *     A[i] & A[j] & A[k] == 0，其中 & 表示按位与（AND）操作符。
 *
 * 思路 : 先两两相与,去重记录重复的次数,然后再把每个结果与A中的每个相与一次.
 * @author clay
 * @date 19-1-27 11:45
 */
public class Leetcode982 {

    public static void main(String[] args) {
        System.out.println(2037 & 2036);
    }
    class Solution {
        public int countTriplets(int[] A) {
            int[] count = new int[65536];
            for(int i : A){
                for(int j : A){
                    count[i&j]++;
                }
            }
            int res = 0;
            for(int i = 0; i < 2048; i++){
                if(count[i] == 0){
                    continue;
                }
                for(int j : A){
                    if((i & j) == 0){
                        res += count[i];
                    }
                }
            }
            return res;

        }
    }
}
