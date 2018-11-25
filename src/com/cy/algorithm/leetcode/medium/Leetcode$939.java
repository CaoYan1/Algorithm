package com.cy.algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * description
 *
 * @author clay
 * @date 18-11-23 10:05
 */
public class Leetcode$939 {

    public int minAreaRect(int[][] points) {
        final int MAX = 40000;
        int result = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int[] point1 : points){
            for(int []point2 : points){
                if(set.contains(point1[0] * MAX + point2[1]) &&
                        set.contains(point2[0] * MAX + point1[1])){
                    result = Math.min(result,
                            Math.abs((point1[0]-point2[0]) * (point1[1] - point2[1])));
                }
            }
            set.add(point1[0] * MAX + point1[1]);
        }
        return result == Integer.MAX_VALUE ? 0 : result;

    }

    public static void main(String ...args){
        Leetcode$939 l = new Leetcode$939();
        System.out.println(l.minAreaRect(new int[][]{{1,1},{1,3},{3,1},{3,3},{2,2}}));
    }
}
