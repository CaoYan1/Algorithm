package com.cy.algorithm.leetcode.medium;

import java.util.Scanner;
import java.util.Stack;

/**
 * 题名 :使括号有效的最好添加
 * 问题 :给定一个由 '(' 和 ')' 括号组成的字符串 S，
 * 我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 *     它是一个空字符串，或者
 *     它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 *     它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 *
 * 思路 :遇到'('入栈,遇到')'出栈,如果栈为空,则需要添加(结果加一),遍历完字符串栈里还剩多少个字符
 * 就需要补多少个括号
 * 执行时间 :9ms
 * @author clay
 * @date 18-11-11 14:28
 */
public class Leetcode921 {

    public static int minAddToMakeValid(String S) {
        int result = 0;
        Stack<Character> stack = new Stack<>();
        char []charArray = S.toCharArray();
        for(char c : charArray){
            if(c == '('){
                stack.push(c);
            }else if(c == ')'){
                result += stack.empty() ? 1 : stack.pop()*0;
            }
        }
        result += stack.size();
        return result;
    }

    public static void main(String ...args){
        Scanner in = new Scanner(System.in);
        int result = minAddToMakeValid(in.next());
        System.out.println(result);
    }
}
