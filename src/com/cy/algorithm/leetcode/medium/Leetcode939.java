package com.cy.algorithm.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 题名 : 最小面积矩形
 * 题目 : 给定在 xy 平面上的一组点，确定由这些点组成的矩形的最小面积，其中矩形的边平行于 x 轴和 y 轴。
 * 如果没有任何矩形，就返回 0。
 *
 * 思路 : 把每个点加入set任取两个点,判断是否存在另外两个点,保存当前最小面积
 * @author clay
 * @date 18-11-23 10:05
 */
public class Leetcode939 {

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


}
