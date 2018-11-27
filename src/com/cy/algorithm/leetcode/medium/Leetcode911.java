package com.cy.algorithm.leetcode.medium;

import java.util.*;

/**
 * 题名 : 在线选举
 * 题目 : 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
 * 现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
 * 在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜。
 *
 * 思路 : 用hashmap存储每一个时刻每个人的票数,不断更新最大票数
 * 执行时间 : 超时....
 * @author clay
 * @date 18-11-27 20:14
 */
public class Leetcode911 {

    static class TopVotedCandidate {

        private List<Long> result = new ArrayList<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            Map<Integer, Integer> map = new HashMap<>();
            int maxPerson = -1;
            int maxTimes = 0;
            for(int i = 0; i < times.length; i++){
                int update = map.getOrDefault(persons[i], 0) + 1;
                map.put(persons[i],update);
                if(update >= maxTimes){
                    maxPerson = persons[i];
                    maxTimes = update;
                }
                result.add((((long)times[i]) << 32) | maxPerson);
            }
        }

        public int q(int t) {
            int index = Collections.binarySearch(result,(long)t << 32);
            if(index < 0){
                index = -(index + 1);
            }
            if(index > result.size() || result.get(index) >> 32 != t){
                index--;
            }
            return result.get(index).intValue();
        }
    }

    public static void main(String ...args){
        TopVotedCandidate c = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0},
                new int[]{0,5,10,15,20,25,30});
        System.out.println(c.q(3));
        System.out.println(c.q(12));
        System.out.println(c.q(25));
        System.out.println(c.q(15));
        System.out.println(c.q(24));
        System.out.println(c.q(8));

    }
}
