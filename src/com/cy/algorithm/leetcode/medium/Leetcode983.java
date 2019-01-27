package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 最低票价
 * 题目 : 在一个火车旅行很受欢迎的国度，你提前一年计划了一些火车旅行。在接下来的一年里，你要旅行的日子将以一个名为 days 的数组给出。每一项是一个从 1 到 365 的整数。
 * 火车票有三种不同的销售方式：
 *     一张为期一天的通行证售价为 costs[0] 美元；
 *     一张为期七天的通行证售价为 costs[1] 美元；
 *     一张为期三十天的通行证售价为 costs[2] 美元。
 * 通行证允许数天无限制的旅行。 例如，如果我们在第 2 天获得一张为期 7 天的通行证，那么我们可以连着旅行 7 天：第 2 天、第 3 天、第 4 天、第 5 天、第 6 天、第 7 天和第 8 天。
 * 返回你想要完成在给定的列表 days 中列出的每一天的旅行所需要的最低消费。
 *
 * 思路 : dfs + 记忆化搜索,找出买三种票价分别的最小价格
 * @author clay
 * @date 19-1-27 11:01
 */
public class Leetcode983 {
    public static void main(String[] args) {
        Solution s = new Leetcode983().new Solution();
        System.out.println(s.mincostTickets(new int[]{6,9,10,14,15,16,17,18,20,22,23,24,29,30,31,33,35,37,38,40,41,46,47,51,54,57,59,65,70,76,77,81,85,87,90,91,93,94,95,97,98,100,103,104,105,106,107,111,112,113,114,116,117,118,120,124,128,129,135,137,139,145,146,151,152,153,157,165,166,173,174,179,181,182,185,187,188,190,191,192,195,196,204,205,206,208,210,214,218,219,221,225,229,231,233,235,239,240,245,247,249,251,252,258,261,263,268,270,273,274,275,276,280,283,285,286,288,289,290,291,292,293,296,298,299,301,303,307,313,314,319,323,325,327,329,334,339,340,341,342,344,346,349,352,354,355,356,357,358,359,363,364},
                new int[]{21,115,345}));
    }
    class Solution {
        public int[] dp = new int[366];
        public int[] costs;
        public int r(int[] days, int i, int cur){
            if(cur <= days[0]){
                return 0;
            }
            if(dp[cur] != 0){
                return dp[cur];
            }
            while (days[i] >= cur){
                i--;
            }
            int a = r(days, i, days[i]) + costs[0];
            int b = r(days, i, days[i] - 6) + costs[1];
            int c = r(days, i, days[i] - 29) + costs[2];
            int min = Math.min(a,Math.min(b,c));
            dp[cur] = min;
            return min;
        }
        public int mincostTickets(int[] days, int[] costs) {
            this.costs = costs;
            return r(days,days.length - 1, days[days.length - 1] + 1);
        }
    }
}
