package com.cy.algorithm.leetcode.easy;

/**
 * 题名 : 找到小镇的法官
 * 题目 : 在一个小镇里，按从 1 到 N 标记了 N 个人。传言称，这些人中有一个是小镇上的秘密法官。
 * 如果小镇的法官真的存在，那么：
 *     小镇的法官不相信任何人。
 *     每个人（除了小镇法官外）都信任小镇的法官。
 *     只有一个人同时满足属性 1 和属性 2 。
 * 给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示标记为 a 的人信任标记为 b 的人。
 * 如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的标记。否则，返回 -1。
 *
 * 思路 : 记录每个人被信任的次数,当某个人被信任次数为N-1并且它不信任任何人就代表他是法官
 * @author clay
 * @date 19-2-24 10:22
 */
public class Leetcode997 {

    public static void main(String[] args) {
        Solution s = new Leetcode997().new Solution();
        System.out.println(s.findJudge(2,new int[][]{{1,2}}));
    }
    class Solution {
        public int findJudge(int N, int[][] trust) {
            int[] dp = new int[N+1];
            boolean[] trustAny = new boolean[N+1];
            for (int i = 0; i < trust.length; i++){
                dp[trust[i][1]]++;
                trustAny[trust[i][0]] = true;
            }
            for (int i = 1; i <= N; i++){
                if (dp[i] == N - 1 && !trustAny[i]){
                    return i;
                }
            }
            return -1;

        }
    }
}
