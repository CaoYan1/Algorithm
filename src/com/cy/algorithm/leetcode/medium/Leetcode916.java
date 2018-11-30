package com.cy.algorithm.leetcode.medium;

import java.util.*;

/**
 * 题目 : 单词子集
 * 题名 : 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
 * 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，但不是 “world” 的子集。
 * 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。
 * 你可以按任意顺序以列表形式返回 A 中所有的通用单词。
 *
 * 思路 : 将B中单词用hashmap记录每个字母最大出现次数,再用A中比较每个字母出现次数都要大于B中的最大次数
 * 执行时间 : 128ms
 * @author clay
 * @date 18-11-30 20:46
 */
public class Leetcode916 {

    class Solution {
        public List<String> wordSubsets(String[] A, String[] B) {
            Map<Character,Integer> wordCount = new HashMap<>();
            Map<Character,Integer> curCount = new HashMap<>();
            for (String b : B){
                char[] cs = b.toCharArray();
                for(char c : cs){
                    int times = curCount.getOrDefault(c,0);
                    times++;
                    curCount.put(c,times);
                }
                for(Iterator<Map.Entry<Character,Integer>> it = curCount.entrySet().iterator();
                        it.hasNext();){
                    Map.Entry<Character,Integer> entry = it.next();
                    int times = wordCount.getOrDefault(entry.getKey(),0);
                    if(entry.getValue() > times){
                        wordCount.put(entry.getKey(),entry.getValue());
                    }
                }
                curCount = new HashMap<>();
            }
            Map<Character,Integer> wordCount1 = new HashMap<>();
            List<String> result = new LinkedList<>();
            for(String a : A){
                char[] cs = a.toCharArray();
                boolean flag = true;
                for(char c : cs){
                    int times = wordCount1.getOrDefault(c,0);
                    times++;
                    wordCount1.put(c,times);
                }
                for(Iterator<Map.Entry<Character,Integer>> it = wordCount.entrySet().iterator();
                    it.hasNext();){
                    Map.Entry<Character,Integer> entry = it.next();
                    int times = wordCount1.getOrDefault(entry.getKey(),0);
                    if(entry.getValue() > times){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    result.add(a);
                }
                wordCount1 = new HashMap<>();
            }
            return result;
        }
    }

    public static void main(String ...args){
        Solution s = new Leetcode916().new Solution();
        List<String> result = s.wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"},
                new String[]{"l","e"});
        for(String r : result){
            System.out.println(r);
        }
    }
}
