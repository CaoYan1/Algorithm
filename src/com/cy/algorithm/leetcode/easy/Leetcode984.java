package com.cy.algorithm.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题名 : 不含AAA或BBB的字符串
 * 题目 : 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 *     S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 *     子串 'aaa' 没有出现在 S 中；
 *     子串 'bbb' 没有出现在 S 中。
 *
 * 思路 : AA和BB交替插入,多余的A(B)插到两个B(A)之间
 *
 * @author clay
 * @date 19-1-27 10:31
 */
public class Leetcode984 {

    class Solution {
        public String strWithout3a3b(int A, int B) {
            StringBuilder result = new StringBuilder();
            Queue<Character> queue = new LinkedList<>();
            while(A != 0 && B != 0){
                queue.offer('a');
                if(--A == 0){
                    break;
                }
                queue.offer('a');
                A--;
                queue.offer('b');
                if(--B == 0){
                    break;
                }
                queue.offer('b');
                B--;
            }
            char c = 'a';
            if(A == 0){
                c = 'b';
                A = B;
            }
            char last = 0;
            while(!queue.isEmpty()){
                if(c != last && c != queue.peek() && A != 0){
                    result.append(c);
                    if(--A == 0){
                        continue;
                    }
                    result.append(c);
                    A--;
                }
                result.append(queue.poll());
            }
            while (A != 0){
                result.append(c);
                A--;
            }
            return result.toString();
        }
    }
}
