package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 救生艇
 * 题目 : 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 * 思路 : 贪心算法,最重的带最轻的(如果能带),否则最重的一个人
 *
 * @author clay
 * @date 18-12-28 20:54
 */
public class Leetcode881 {
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);
            int left = 0,right = people.length - 1;
            int ship = 0;
            while (left <= right){
                if(people[right] + people[left] <= limit){
                    left++;
                    right--;
                }else{
                    right--;
                }
                ship++;
            }
            return ship;
        }
    }
}
