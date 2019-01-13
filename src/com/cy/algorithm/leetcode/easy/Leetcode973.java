package com.cy.algorithm.leetcode.easy;

import java.util.Arrays;

/**
 * 题名 : 最接近原点的K个点
 * 题目 : 我们有一个由平面上的点组成的列表 points。需要从中找出 K 个距离原点 (0, 0) 最近的点。
 * （这里，平面上两点之间的距离是欧几里德距离。）
 * 你可以按任何顺序返回答案。除了点坐标的顺序之外，答案确保是唯一的。
 *
 * 思路 : 分治快排思想,pivot位置大于k只排序前一半
 * @author clay
 * @date 19-1-13 10:29
 */
public class Leetcode973 {
    public static void main(String[] args){
        Solution s = new Leetcode973().new Solution();
        System.out.println(s.kClosest(new int[][]{{1,3},{-2,2},{5,9}},1));
    }

    class Solution {
        public int[][] kClosest(int[][] points, int K) {
            if(points == null || points.length <= 0 || K <= 0){
                return new int[][]{};
            }
            Arrays.sort(points,(points1,points2)->{
                return (points1[0]*points1[0] + points1[1]*points1[1]) >=
                        (points2[0]*points2[0] + points2[1]*points2[1]) ? 1 : -1;
            });
            int[][] result = new int[K][2];
            System.arraycopy(points,0,result,0,K);
            return result;
        }
    }
}
