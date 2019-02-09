package com.cy.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 题名 : 最大宽度坡
 * 题目 : 给定一个整数数组 A，坡是元组 (i, j)，其中  i < j 且 A[i] <= A[j]。这样的坡的宽度为 j - i。
 * 找出 A 中的坡的最大宽度，如果不存在，返回 0 。
 *
 * 思路 : 将索引和值组成二元组,根据值排序,遍历一遍记录最大的索引差
 *
 * @author clay
 * @date 19-2-9 19:10
 */
public class Leetcode962 {
    class Solution {
        public int maxWidthRamp(int[] A) {
            int[][] B = new int[A.length][2];
            for(int i = 0; i < A.length; i++){
                B[i] = new int[]{A[i],i};
            }
            Arrays.sort(B,(a,b)->a[0]>b[0]?1:a[0]==a[1]?0:-1);
            int min = Integer.MAX_VALUE, max = 0;
            for(int i = 0; i < A.length; i++){
                if(B[i][1] < min){
                    min = B[i][1];
                }
                if(B[i][1] - min > max){
                    max = B[i][1] - min;
                }
            }
            return max;
        }
    }
}
