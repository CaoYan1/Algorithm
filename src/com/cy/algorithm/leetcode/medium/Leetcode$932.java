package com.cy.algorithm.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题名 : 漂亮数组
 * 题目 : 对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：
 * 对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。
 * 那么数组 A 是漂亮数组。
 * 给定 N，返回任意漂亮数组 A（保证存在一个）。
 *
 * 思路 : 动态规划思想,如果一个数组是漂亮数组,那么把他所有元素乘以n(n > 0)也一定是漂亮数组,
 * 那么可以自底向上推出,把一个大小为N的数组分为左右两边(左边为全为奇数的漂亮数组,右边为全为偶数的漂亮数组),
 * 一边乘以2-1,一边乘以2,那么左边为奇数,
 * 右边为偶数,两边相加为奇数不可能存在题中的k,两边分别也不会存在k
 * @author clay
 * @date 18-12-7 21:27
 */
public class Leetcode$932 {
    class Solution {
        public int[] beautifulArray(int N) {
            if(N == 1){
                return new int[]{1};
            }
            int[] result = new int[N];
            int[] left = beautifulArray((N + 1) / 2);
            int[] right = beautifulArray(N / 2);
            for(int i = 0; i < N; i++){
                if(i < left.length){
                    result[i] = left[i];
                }else {
                    result[i] = right[i - left.length];
                }
            }
            return result;
        }
    }
}
