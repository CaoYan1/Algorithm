package com.cy.algorithm.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

/**
 * 题名 : k个不同整数的子数组
 * 题目 : 给定一个正整数数组 A，如果 A 的某个子数组中不同整数的个数恰好为 K，则称 A 的这个连续、不一定独立的子数组为好子数组。
 * （例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。）
 * 返回 A 中好子数组的数目。
 *
 * 思路 : 计算K-1情况下,每个元素为子数组末尾的情况下不同整数个数最接近k-1的子数组的长度,同理计算
 * k的情况下,二者相减.(k个不同整数的子数组的长度减去k-1个不同整数的子数组的长度就为k个不同整数的子数组的个数)
 *
 * @author clay
 * @date 19-2-10 11:54
 */
public class Leetcode992 {
    class Solution {
            public int subarraysWithKDistinct(int[] A, int K) {
                return count(A, K) - count(A, K-1);
            }

            int count(int[] a, int K) {
                int n = a.length;
                int[] f = new int[n+1];
                int dis = 0;
                int p = 0;
                int ret = 0;
                for(int i = 0;i < n;i++){
                    if(++f[a[i]] == 1){
                        dis++;
                    }
                    while(dis > K){
                        if(--f[a[p++]] == 0){
                            dis--;
                        }
                    }
                    ret += i-p+1;
                }
                return ret;
            }
    }
}
