package com.cy.algorithm.leetcode.easy;

import java.util.LinkedList;
import java.util.List;

/**
 * 题名 : 数组形式的整数加法
 * 题目 : 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 思路 : 将K不断累加到A中并模10,然后加到LinkedList中,最后多余的K模10加到列表中
 *
 * @author clay
 * @date 19-2-10 10:30
 */
public class Leetcode989 {

    public static void main(String[] args) {
        Solution s = new Leetcode989().new Solution();
        s.addToArrayForm(new int[]{1,2,0,0},34);
    }

    class Solution {
        public List<Integer> addToArrayForm(int[] A, int K) {
            LinkedList<Integer> result = new LinkedList<>();
            int k = K;
            for(int i = A.length - 1; i >= 0 && k != 0; i--){
                A[i]+= k;
                k = A[i] / 10;
                A[i] %= 10;
                result.addFirst(A[i]);
            }
            while (k != 0){
                result.addFirst(k % 10);
                k /= 10;
            }
            return result;
        }
    }
}
