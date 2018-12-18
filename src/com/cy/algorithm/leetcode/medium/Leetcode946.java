package com.cy.algorithm.leetcode.medium;

import java.util.Stack;

/**
 * 题名 : 验证栈序列
 * 题目 : 给定 pushed 和 popped 两个序列，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。
 *
 * 思路 : 将pushed数组入栈,用一个指针记录popped数组当前位置,比较栈顶和当前位置的值,相等则出栈
 * 最后如果popped数组所有元素都出栈一次则为true
 * 执行时间 : 21ms
 * @author clay
 * @date 18-12-18 18:58
 */
public class Leetcode946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int pos = 0;
            for(int i : pushed){
                stack.push(i);
                while(!stack.empty() && stack.peek() == popped[pos]){
                    pos++;
                    stack.pop();
                }
            }
            return pos == popped.length;

        }
    }

}
