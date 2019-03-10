package com.cy.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 题名 : K次取反后最大化的数组和
 * 题目 : 给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）
 * 以这种方式修改数组后，返回数组可能的最大和。
 *
 * 思路 : 从小到大将负数全部取反,多余的次数如果为偶数则为当前结果,否则将当最小的数再取反一次
 * @author clay
 * @date 19-3-10 10:32
 */
public class Leetcode1005 {
    public static void main(String[] args) {
        Solution s = new Leetcode1005().new Solution();
        System.out.println(s.largestSumAfterKNegations(new int[]{-8,3,-5,-3,-5,-2}, 6));
    }
    class Solution {
        public int largestSumAfterKNegations(int[] A, int K) {
            int sum = 0;
            Arrays.sort(A);
            int i = 0;
            while (i < A.length && A[i] <= 0 && i < K){
                A[i] = -A[i];
                i++;
            }
            if (i < K){
                if ((K-i)%2 != 0){
                    if (i == A.length){
                        sum -= 2 * A[i-1];
                    }else if (i == 0){
                        sum -= 2 * A[i];
                    }
                    else {
                        sum -= 2 * Math.min(A[i],A[i-1]);
                    }
                }
            }

            for (int a : A){
                sum += a;
            }
            return sum;
        }
    }
}
