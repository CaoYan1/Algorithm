package com.cy.algorithm.leetcode.medium;

import java.net.Socket;

/**
 * 题目 : 字母移位
 * 题名 :有一个由小写字母组成的字符串 S，和一个整数数组 shifts。
 * 我们将字母表中的下一个字母称为原字母的 移位（由于字母表是环绕的， 'z' 将会变成 'a'）。
 * 例如·，shift('a') = 'b'， shift('t') = 'u',， 以及 shift('z') = 'a'。
 * 对于每个 shifts[i] = x ， 我们会将 S 中的前 i+1 个字母移位 x 次。
 * 返回将所有这些移位都应用到 S 后最终得到的字符串。
 *
 * 思路 : 对于第i个字母,shifts数组第i后面的移位都对它生效,所以第i个字母的移位次数为shifts[i]+shifts[i+1]+....+shifts[n]
 * 倒着往前遍历,移位的次数累加,要对26取模防止溢出
 *
 * @author clay
 * @date 18-12-29 20:38
 */
public class Leetcode848 {

    public static void main(String[] args){
        Solution s = new Leetcode848().new Solution();
        System.out.println(s.shiftingLetters("abc",new int[]{3,5,9}));
    }

    class Solution {
        public String shiftingLetters(String S, int[] shifts) {
            char[] chars = S.toCharArray();
            int cur = 0;
            for(int i = shifts.length - 1; i >= 0; i--){
                cur += shifts[i];
                cur %= 26;
                chars[i] = (char)(97 + (chars[i] - 97 + cur) % 26);
            }
            return new String(chars);
        }
    }
}
