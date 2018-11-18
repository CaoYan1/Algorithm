package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 将字符串翻转到单调递增
 * 题目描述 : 如果一个由 '0' 和 '1' 组成的字符串，
 * 是以一些 '0'（可能没有 '0'）后面跟着一些 '1'（也可能没有 '1'）的形式组成的，那么该字符串是单调递增的。
 * 我们给出一个由字符 '0' 和 '1' 组成的字符串 S，我们可以将任何 '0' 翻转为 '1' 或者将 '1' 翻转为 '0'。
 * 返回使 S 单调递增的最小翻转次数。
 *
 * 思路 : 遍历一次字符串用两个数组分别保存前i个字符中'0'和'1'的个数,并且用一个变量存储'0'的总数
 * 然后再遍历一遍,找到少翻转次数(将i前面'1'变'0',i后面'0'变1)
 * 执行时间 : 10ms
 * @author clay
 * @date 18-11-11 16:08
 */
public class Leetcode926 {

    public static int minFlipsMonoIncr(String S) {
        int []count0 = new int[S.length()];
        int []count1 = new int[S.length()];
        int n0 = 0;
        char []charArray = S.toCharArray();
        if(charArray[0] == '0'){
            count0[0] += 1;
            n0 += 1;
        }else {
            count1[0] += 1;
        }
        for(int i = 1; i < S.length(); i++){
            if(charArray[i] == '0'){
                n0 += 1;
                count0[i] = count0[i-1] + 1;
                count1[i] = count1[i-1];
            }else {
                count1[i] = count1[i-1] + 1;
                count0[i] = count0[i-1];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i++){
            int a0 = n0 - count0[i];
            int a1 = count1[i] + (charArray[i] == '1' ? -1 : 0);
            if(result > a0 + a1){
                result = a0 + a1;
            }
        }
        return result;

    }

    public static void main(String ...args){
        System.out.println(minFlipsMonoIncr("00011000"));
    }


}
