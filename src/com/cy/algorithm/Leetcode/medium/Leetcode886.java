package com.cy.algorithm.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 题名 : 可能的二分法
 * 题目 : 给定一组 N 人（编号为 1, 2, ..., N）， 我们想把每个人分进任意大小的两组。
 * 每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * 形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
 * 当可以用这种方法将每个人分进两组时，返回 true；否则返回 false。
 *
 * 思路 : 二分图算法
 * 执行时间 : 52ms
 * @author clay
 * @date 18-11-12 13:30
 */
public class Leetcode886 {

    static class Node{
        List<Node> next = new LinkedList<>();
        int value = -1;

        //判断奇偶性是否相同,相同则为同一边
        private boolean check(int value1, int value2){
            return ((value1 ^ value2) & 1) == 0;
        }

        //递归地将后面节点value + 1,如果已经初始化过并且不是同一边返回false
        public boolean setNextValue(int value){
            for(Node node : next){
                if(node.value == -1){
                    node.value = value;
                    if(!node.setNextValue(value + 1)){
                        return false;
                    }
                }else if(check(value,node.value)){
                    continue;
                }else {
                    return false;
                }

            }
            return true;
        }
    }

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        Node []nodes = new Node[N+1];
        for(int i = 1; i <= N; i++){
            nodes[i] = new Node();
        }
        for(int[] e : dislikes){
            int a = e[0], b = e[1];
            nodes[a].next.add(nodes[b]);
            nodes[b].next.add(nodes[a]);
        }
        for(int i = 1; i < N+1; i++){
            if(nodes[i].value == -1){
                nodes[i].value = 0;
                if(!nodes[i].setNextValue(1)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String ...args){
        boolean result = possibleBipartition(3,new int[][]{{1,2},{1,3},{2,3}});
        System.out.println(result);
    }

}
