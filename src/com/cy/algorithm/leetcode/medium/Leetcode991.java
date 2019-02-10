package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 坏了的计算器
 * 题目 : 在显示着数字的坏计算器上，我们可以执行以下两种操作：
 *     双倍（Double）：将显示屏上的数字乘 2；
 *     递减（Decrement）：将显示屏上的数字减 1 。
 * 最初，计算器显示数字 X。
 * 返回显示数字 Y 所需的最小操作数
 *
 * 思路 : 递归,奇数加1除二两次操作,偶数除2一次操作,直到Y小于X,需要X-Y次操作
 *
 * @author clay
 * @date 19-2-10 11:42
 */
public class Leetcode991 {
    class Solution {
        public int brokenCalc(int X, int Y) {
            if(X > Y){
                return X - Y;
            }
            if(Y % 2 != 0){
                return 2 + brokenCalc(X , (Y + 1) / 2);
            }else {
                return 1 + brokenCalc(X , (Y + 1) / 2);
            }
        }
    }
}
