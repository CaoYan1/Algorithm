package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 二倍数对数组
 * 题目 : 给定一个长度为偶数的整数数组 A，只有对 A 进行重组后可以满足 “对于每个 0 <= i < len(A) / 2，都有 A[2 * i + 1] = 2 * A[2 * i]” 时，返回 true；否则，返回 false。
 *
 * 思路 : 将数组排个序,然后分为大于0和小于0两种情况,两个指针i,j记录两个位置
 *
 * @author clay
 * @date 18-12-27 13:44
 */
public class Leetcode954 {


    public static void main(String[] args){
        Solution s = new Leetcode954().new Solution();
        System.out.println(s.canReorderDoubled(new int[]{0,4,0,2,-6,-4,8,-3,0,0,2,-6,-3,-6,-2,-3,1,4}));
    }

    class Solution {

        public boolean func(int []arr, int a, int b){
            if(b - a + 1 <= 0){
                return true;
            }else if((b - a + 1) % 2 != 0){
                return false;
            }
            int[] bak = new int[b - a + 1];
            Arrays.fill(bak,-100001);
            int j = 0, k = 2;
            if(arr[a] <= 0){
                bak[0] = arr[b];
                for(int i = b - 1; i >= a; i--){
                    if(j < bak.length && arr[i] == bak[j] * 2){
                        bak[j + 1] = arr[i];
                        j += 2;
                    }else if (k >= bak.length){
                        return false;
                    }else {
                        bak[k] = arr[i];
                        k += 2;
                    }
                }
            }else {
                bak[0] = arr[a];
                for(int i = a + 1; i <= b; i++){
                    if(arr[i] == bak[j] * 2){
                        bak[j + 1] = arr[i];
                        j += 2;
                    }else if (k >= bak.length){
                        return false;
                    }else {
                        bak[k] = arr[i];
                        k += 2;
                    }
                }
            }
            return true;
        }

        public boolean canReorderDoubled(int[] A) {
            Arrays.sort(A);
            int i;
            for(i = 0; i < A.length; i++){
                if(A[i] > 0) break;
            }
            return func(A, 0 , i - 1) && func(A, i, A.length - 1);
        }
    }
}
