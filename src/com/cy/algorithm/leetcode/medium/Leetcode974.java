package com.cy.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 题名 : 可被K整除的子数组
 * 题目 : 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
 *
 * 思路 : 从左往右遍历,hash表记录上一个元素能组成的所有子数组的和并取余数,把当前元素的值
 * 与上一个的所有和相加组成新的hash表
 *
 * @author clay
 * @date 19-1-13 10:44
 */
public class Leetcode974 {

    public static void main(String[] args){
        Solution s = new Leetcode974().new Solution();
        System.out.println(s.subarraysDivByK(new int[]{1,-10,5},9));
    }

    class Solution {
        public int subarraysDivByK(int[] A, int K) {
            if (A == null || A.length <= 0) {
                return 0;
            }
            HashMap<Integer,Integer> last = new HashMap<>();
            HashMap<Integer,Integer> cur = new HashMap<>();
            int count = 0;
            if(A[0] % K == 0){
                count++;
            }
            last.put(A[0] % K, 1);
            for(int i = 1; i < A.length; i++){
                for(Map.Entry<Integer,Integer> entry : last.entrySet()){
                    int key = entry.getKey();
                    int value = entry.getValue();
                    key = (key + A[i]) % K;
                    if(key == 0){
                        count += value;
                    }
                    cur.put(key,value);
                }
                if(A[i] % K == 0){
                    count++;
                }
                int times = cur.getOrDefault(A[i] % K, 0);
                cur.put(A[i] % K, ++times);
                last = cur;
                cur = new HashMap<>();
            }
            return count;


        }

    }
}
