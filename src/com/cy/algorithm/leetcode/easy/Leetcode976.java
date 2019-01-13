package com.cy.algorithm.leetcode.easy;

import java.util.Arrays;


/**
 * 题名 : 三角形的最大周长
 * 题目 : 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * 如果不能形成任何面积不为零的三角形，返回 0。
 *
 * 思路 : 先排序,从大到小找三条边,第一个是三角形的就是最大的
 * @author clay
 * @date 19-1-13 10:40
 */
public class Leetcode976 {
    class Solution {
        public int largestPerimeter(int[] A) {
            if(A == null || A.length <= 2){
                return 0;
            }
            Arrays.sort(A);
            for(int i = A.length - 1; i >= 0; i--){
                for(int j = i - 1; j >= 0; j--){
                    for (int k = j - 1; k >= 0; k--){
                        if(A[k] + A[j] > A[i]){
                            return A[k] + A[j] + A[i];
                        }
                    }
                }
            }
            return 0;
        }
    }
}
