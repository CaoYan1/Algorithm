package com.cy.algorithm.Leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 题名 : 子数组按位或操作
 * 题目 : 我们有一个非负整数数组 A。
 * 对于每个（连续的）子数组 B = [A[i], A[i+1], ..., A[j]] （ i <= j），
 * 我们对 B 中的每个元素进行按位或操作，获得结果 A[i] | A[i+1] | ... | A[j]。
 * 返回可能结果的数量。 （多次出现的结果在最终答案中仅计算一次。）
 *
 * 思路 : 使用普通的动态规划会超时,这里使用三个set存储,分别代表
 * 所有的结果 上一行的结果 当前的结果
 * f(i,j)代表从j到i所有元素的或的结果,所以f(i,j) = f(i-1,j) | A[i]
 * 所以以每行为一次循环,每一行的结果为上一行所有结果与A[i]或操作
 * 执行时间 : 475ms
 * @author clay
 * @date 18-11-12 14:02
 */
public class Leetcode898 {

    public static int subarrayBitwiseORs(int[] A) {
        int len = A.length;
        //去重
        Set<Integer> count = new HashSet<>();
        Set<Integer> cur = new HashSet<>();
        Set<Integer> last = new HashSet<>();
        for(int a : A){
            for(int i : last){
                cur.add(a | i);
            }
            cur.add(a);
            count.addAll(cur);
            last = cur;
            cur = new HashSet<>();
        }
        return count.size();
    }

    public static void main(String ...args){
        System.out.println(subarrayBitwiseORs(new int[]{1,1,2}));
    }
}
