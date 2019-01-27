package com.cy.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * description
 *
 * @author clay
 * @date 19-1-24 17:30
 */
public class Leetcode855 {
    class ExamRoom {

        private int N;
        private int left;
        private int right;
        private Queue<int[]> queue;
        private Map<Integer, int[]> map;

        public ExamRoom(int N) {
            this.N = N;
            left = N;
            right = 0;
            queue = new PriorityQueue<>((a,b)->
                Math.abs(a[0] - a[1]) > Math.abs(b[0] - b[1]) ? -1 : 1
            );
            map = new HashMap<>();
            queue.add(new int[]{-1,-1});
        }

        public int seat() {
            int maxLen = 0;
            int pos = Integer.MAX_VALUE;
            if(left - 0 >= maxLen){
                pos = 0;
            }
            if(N - right > maxLen){
                pos = N;
            }
            int[] p = queue.peek();
            if(Math.abs(p[0] - p[1]) / 2 >= maxLen){
                if(Math.abs(p[0] - p[1]) / 2 != maxLen || (p[0] + p[1])/2 < pos) {
                    pos = (p[0] + p[1]) / 2;
                    queue.poll();
                    queue.offer(new int[]{p[0],pos});
                    queue.offer(new int[]{pos,p[1]});
                    return (p[0] + p[1]) / 2;
                }
            }
            if(pos > right){
                right = pos;
                queue.offer(new int[]{right,pos});
            }
            if(pos < left){
                left = pos;
                queue.offer(new int[]{pos,left});
            }
            return 0;


        }

        public void leave(int p) {

        }
    }
}
