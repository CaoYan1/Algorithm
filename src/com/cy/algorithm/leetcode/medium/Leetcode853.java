package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 车队
 * 题目 : N  辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
 * 每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
 * 一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
 * 此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
 * 车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
 * 即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
 * 会有多少车队到达目的地?
 *
 * 思路 : 对距离排个序,从离终点最近的往前遍历,如果当前车能追上前面一辆就为一个车队,把当前车的速度改为前面一辆的
 * 否则车队数量+1
 * @author clay
 * @date 19-1-7 17:01
 */
public class Leetcode853 {

    public static void main(String[] args){
        Solution s = new Leetcode853().new Solution();
        System.out.println(s.carFleet(660732,new int[]{620831,145366,229113,144305,382893,514856,171642,87230,409014,65613},
                new int[]{327716,69772,667805,856849,78755,606982,696937,207697,275337,290550}));
    }

    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            if(position == null || position.length <= 0){
                return 0;
            }
            int n = position.length;
            int[][] car = new int[n][2];
            for(int i = 0; i < n; i++){
                car[i][0] = position[i];
                car[i][1] = speed[i];
            }
            Arrays.sort(car,(car1,car2)-> car1[0] > car2[0] ? 1 : -1);
            int count = 1;
            for(int i = n - 2; i >= 0; i--){
                if(car[i+1][0] != car[i][0] && (target - car[i+1][0])*(car[i][1]) < (target - car[i][0])*(car[i+1][1])){
                    count++;
                }else {
                    car[i][0] = car[i+1][0];
                    car[i][1] = car[i+1][1];
                }
            }
            return count;
        }
    }
}
