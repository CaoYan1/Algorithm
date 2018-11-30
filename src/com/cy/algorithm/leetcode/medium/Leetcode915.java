package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 分割数组
 * 题目 : 给定一个数组 A，将其划分为两个不相交（没有公共元素）的连续子数组 left 和 right， 使得：
 *     left 中的每个元素都小于或等于 right 中的每个元素。
 *     left 和 right 都是非空的。
 *     left 要尽可能小。
 * 在完成这样的分组后返回 left 的长度。可以保证存在这样的划分方法。
 *
 * 思路 : 从左往右遍历,记录当前最小长度的最大值和当前最大值,遇到比最小长度最大值小的时候更新结果
 * 和当前最小长度最大值
 * 执行时间 : 7ms
 * @author clay
 * @date 18-11-30 20:18
 */
public class Leetcode915 {

    class Solution {
        public int partitionDisjoint(int[] A) {
            int max1 = A[0], max2 = A[0], result = 0;
            for(int i = 1; i < A.length; i++){
                if(A[i] < max1){
                    max1 = max2;
                    result = i;
                }else {
                    if(A[i] > max2){
                        max2 = A[i];
                    }
                }
            }
            return result + 1;
        }
    }

    public static void main(String[] args){
        Solution s = new Leetcode915(). new Solution();
        System.out.println(
                s.partitionDisjoint(new int[]{1,1,1,1,1,1})
        );
    }
}
