package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题目 : 令牌放置
 * 题名 : 你的初始能量为 P，初始分数为 0，只有一包令牌。
 * 令牌的值为 token[i]，每个令牌最多只能使用一次，可能的两种使用方法如下：
 *     如果你至少有 token[i] 点能量，可以将令牌置为正面朝上，失去 token[i] 点能量，并得到 1 分。
 *     如果我们至少有 1 分，可以将令牌置为反面朝上，获得 token[i] 点能量，并失去 1 分。
 * 在使用任意数量的令牌后，返回我们可以得到的最大分数。
 *
 * 思路 : 贪心思想,先排序,从左往右得分,不够了就从右往左得能量,要注意得能量的时候分数够不够.
 * 执行时间 : 17ms
 * @author clay
 * @date 18-12-19 19:33
 */
public class Leetcode948 {

    class Solution {
        public int bagOfTokensScore(int[] tokens, int P) {
            if(tokens == null || tokens.length < 1){
                return 0;
            }
            Arrays.sort(tokens);
            int start = 0, end = tokens.length - 1;
            int count = 0;
            while(start < end){
                if (P >= tokens[start]){
                    P -= tokens[start];
                    count++;
                    start++;
                }else {
                    if(count == 0){
                        break;
                    }
                    P += tokens[end];
                    end--;
                    count--;
                }
            }
            if(P >= tokens[start]){
                count++;
            }
            return count;
        }
    }

    public static void main(String[] args){
        Solution s = new Leetcode948().new Solution();
        System.out.println(s.bagOfTokensScore(new int[]{100,200,300,400}, 200));
    }

}
