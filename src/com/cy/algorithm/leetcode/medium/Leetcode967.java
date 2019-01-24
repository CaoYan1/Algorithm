package com.cy.algorithm.leetcode.medium;

import java.util.*;

/**
 * 题名 : 连续差相同的数字
 * 题目 : 返回所有长度为 N 且满足其每两个连续位上的数字之间的差的绝对值为 K 的非负整数。
 * 请注意，除了数字 0 本身之外，答案中的每个数字都不能有前导零。例如，01 因为有一个前导零，所以是无效的；但 0 是有效的。
 * 你可以按任何顺序返回答案。
 *
 * 思路 : 深度优先搜索,把相隔为K的用数组保存,然后dfs搜索N个数字出来.
 *
 * @author clay
 * @date 19-1-23 17:22
 */
public class Leetcode967 {
    public static void main(String[] args) {
        Solution s = new Leetcode967().new Solution();
        System.out.println(s.numsSameConsecDiff(1,6));
    }
    class Solution {
        public Set<Integer> result = new HashSet<>();
        int count;
        int interval;
        public void dfs(List<Integer> list, int start, int cur ,int n){
            if(n == 0){
                result.add(cur);
                return;
            }
            if(start < 0 || start >= list.size()){
                return;
            }
            if(n == count && list.get(start) == 0 && count != 1){
                return;
            }
            if(interval == 0){
                dfs(list, start, cur * 10 + list.get(start), n - 1);
            }
            dfs(list, start + 1, cur * 10 + list.get(start), n - 1);
            dfs(list, start - 1, cur * 10 + list.get(start), n - 1);

        }
        public int[] numsSameConsecDiff(int N, int K) {
            count = N;
            interval = K;
            boolean[] visited = new boolean[10];
            for(int i = 0; i < 10; i++){
                if(i == 4){
                    System.out.println('a');
                }
                List<Integer> list = new ArrayList<>(10);
                list.add(i);
                if(visited[i]){
                   continue;
                }
                visited[i] = true;
                int t = i;
                while((t += K) < 10 && !visited[t]){
                    visited[t] = true;
                    list.add(t);
                }
                for(int j = 0; j < list.size(); j++){
                    dfs(list,j,0,N);
                }
            }
            return result.stream().mapToInt((i)->i).toArray();
        }
    }
}
