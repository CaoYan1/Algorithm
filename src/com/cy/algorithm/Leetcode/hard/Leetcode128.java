package com.cy.algorithm.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 题名 : 最长连续序列
 * 题目 : 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 *
 * 思路 : 用hash表存储最长的两端点,当遍历到nums[i]时与nums[i]-1的左端与nums[i]+1的右端合并
 * 执行时间 : 10ms
 * @author clay
 * @date 18-11-18 09:11
 */
public class Leetcode128 {

    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length <= 0){
            return 0;
        }
        Map<Integer,Integer> map = new HashMap<>();
        int result = 1;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                continue;
            }
            boolean left = map.containsKey(nums[i]-1);
            boolean right = map.containsKey(nums[i]+1);
            if (left && right){
                Integer start = map.get(nums[i]-1);
                Integer end = map.get(nums[i]+1);
                map.put(start,end);
                map.put(end,start);
                map.put(nums[i],nums[i]);
                if(end - start + 1 > result){
                    result = end - start + 1;
                }
            }else if (left){
                Integer start = map.get(nums[i]-1);
                map.put(start,nums[i]);
                map.put(nums[i],start);
                if(nums[i] - start + 1 > result){
                    result = nums[i] - start + 1;
                }
            }else if (right){
                Integer end = map.get(nums[i]+1);
                map.put(nums[i],end);
                map.put(end,nums[i]);
                if(end - nums[i] + 1 > result){
                    result = end - nums[i] + 1;
                }
            }else {
                map.put(nums[i],nums[i]);
            }
        }
        return result;
    }

    public static void main(String ...args){
        Leetcode128 l = new Leetcode128();
        System.out.println(l.longestConsecutive(
                new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
}
