package com.cy.algorithm.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 题名 : 按递增顺序显示卡牌
 * 题目 : 牌组中的每张卡牌都对应有一个唯一的整数。你可以按你想要的顺序对这套卡片进行排序。
 * 最初，这些卡牌在牌组里是正面朝下的（即，未显示状态）。
 * 现在，重复执行以下步骤，直到显示所有卡牌为止：
 *     从牌组顶部抽一张牌，显示它，然后将其从牌组中移出。
 *     如果牌组中仍有牌，则将下一张处于牌组顶部的牌放在牌组的底部。
 *     如果仍有未显示的牌，那么返回步骤 1。否则，停止行动。
 * 返回能以递增顺序显示卡牌的牌组顺序。
 * 答案中的第一张牌被认为处于牌堆顶部。
 *
 * 思路 : 动态规划的思想, 如果一堆卡牌满足题目的要求,如果牌底移动到牌顶,并向牌顶放入一个最小值也还是满足要求
 * 所以可以先排个序,从最大的开始往上递推.
 *
 * 执行时间 : 9ms
 *
 * @author clay
 * @date 18-12-19 20:02
 */
public class Leetcode950 {

    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int[] result = new int[deck.length];
            Deque<Integer> deque = new ArrayDeque<>(deck.length);
            for(int i = 0; i < deck.length; i++){
                deque.addLast(i);
            }
            int cur = 0;
            while (!deque.isEmpty()){
                int i = deque.pollFirst();
                result[i] = deck[cur];
                cur++;
                if(!deque.isEmpty()){
                    deque.addLast(deque.pollFirst());
                }

            }
            return result;
        }

        //优化版本
        public int[] deckRevealedIncreasing1(int[] deck) {
            int[] result = new int[deck.length];
            int n = deck.length;
            Arrays.sort(deck);
            Deque<Integer> deque = new ArrayDeque<>(n);
            deque.offerFirst(result[n - 1]);
            for(int i = n - 2; i >= 0; i--){
                deque.offerFirst(deque.pollLast());
                deque.offerFirst(deck[i]);
            }
            int i = -1;
            while(++i < n){
                result[i] = deque.pollFirst();
            }
            return result;
        }
    }
}
