package com.cy.algorithm.leetcode.hard;

import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 题名 : 奇偶跳
 * 题目 : 给定一个整数数组 A，你可以从某一起始索引出发，跳跃一定次数。在你跳跃的过程中，第 1、3、5... 次跳跃称为奇数跳跃，而第 2、4、6... 次跳跃称为偶数跳跃。
 * 你可以按以下方式从索引 i 向后跳转到索引 j（其中 i < j）：
 *     在进行奇数跳跃时（如，第 1，3，5... 次跳跃），你将会跳到索引 j，使得 A[i] <= A[j]，A[j] 是可能的最小值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *     在进行偶数跳跃时（如，第 2，4，6... 次跳跃），你将会跳到索引 j，使得 A[i] => A[j]，A[j] 是可能的最大值。如果存在多个这样的索引 j，你只能跳到满足要求的最小索引 j 上。
 *     （对于某些索引 i，可能无法进行合乎要求的跳跃。）
 * 如果从某一索引开始跳跃一定次数（可能是 0 次或多次），就可以到达数组的末尾（索引 A.length - 1），那么该索引就会被认为是好的起始索引。
 * 返回好的起始索引的数量。
 *
 * 思路 : 使用TreeMap,从右往左遍历,每遍历一个加入到TreeMap中,key为值,value为索引,当为奇数跳时,
 * 搜索树中大于等于当前元素的(因为TreeMap的key不能重复,所以对了相同的元素只保留索引小的刚好符合题意)
 * 当为偶数跳搜索树中小于等于当前元素的,使用数组记录当前位置奇数跳和偶数跳能否到终点.
 * @author clay
 * @date 19-1-13 11:43
 */
public class Leetcode975 {

    public static void main(String[] args){
        Solution s = new Leetcode975().new Solution();
        System.out.println(s.oddEvenJumps(new int[]{2,3,1,1,4}));
    }

    public class Solution1 {

        public int oddEvenJumps(int[] A) {
            if(A == null || A.length <= 0){
                return 0;
            }
            int[][] dp = new int[A.length][2];
            TreeSet<int[]> treeSet1 = new TreeSet<>((i1,i2)->{
                if(i1[1] > i2[1]){
                    return 1;
                }else if(i1[1] < i2[1]){
                    return -1;
                }else{
                    if(i1[0] < i2[0]){
                        return -1;
                    }else {
                        return 1;
                    }
                }
            });
            TreeSet<int[]> treeSet2 = new TreeSet<>((i1,i2)->{
                if(i1[1] > i2[1]){
                    return 1;
                }else if(i1[1] < i2[1]){
                    return -1;
                }else{
                    if(i1[0] < i2[0]){
                        return 1;
                    }else {
                        return -1;
                    }
                }
            });
            int []cur = new int[]{A.length - 1,A[A.length - 1]};
            treeSet1.add(cur);
            treeSet2.add(cur);
            dp[A.length - 1][0] = 1;
            dp[A.length - 1][1] = 1;
            int count = 1;
            for(int i = A.length - 2; i >= 0; i--){
                cur = new int[]{i,A[i]};
                int[] next = treeSet1.ceiling(cur);
                boolean can = false;
                if(next == null || dp[next[0]][1] == 0){
                    dp[i][0] = 0;
                }else {
                    count++;
                    dp[i][0] = 1;
                }
                next = treeSet2.floor(cur);
                if(next == null || dp[next[0]][0] == 0){
                    dp[i][1] = 0;
                }else {
                    dp[i][1] = 1;
                }
                treeSet1.add(cur);
                treeSet2.add(cur);
            }
            return count;
        }
    }

    public class Solution {
        private int N;
        private int ans = 0;
        TreeMap<Integer, Integer> numToIndices = new TreeMap<>();
        public int oddEvenJumps(int[] A) {
            N = A.length;
            numToIndices.put(A[N - 1], N - 1);
            boolean[] odd = new boolean[N], even = new boolean[N];
            odd[N - 1] = even[N - 1] = true;
            for (int i = N - 1; i >= 0; --i) {
                if (!numToIndices.isEmpty() && numToIndices.lastKey() >= A[i]) {
                    int ceil = numToIndices.ceilingKey(A[i]);
                    if (odd[i] = even[numToIndices.get(ceil)])
                        ans++;
                }
                if (!numToIndices.isEmpty() && numToIndices.firstKey() <= A[i]) {
                    int fl = numToIndices.floorKey(A[i]);
                    even[i] = odd[numToIndices.get(fl)];
                }
                numToIndices.put(A[i], i);
            }

            return ans;
        }
    }
}
