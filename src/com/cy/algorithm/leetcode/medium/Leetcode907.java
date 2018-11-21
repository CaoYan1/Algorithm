package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 子数组的最小值之和
 * 题目 : 给定一个整数数组 A，找到 min(B) 的总和，其中 B 的范围为 A 的每个（连续）子数组。
 * 由于答案可能很大，因此返回答案模 10^9 + 7。
 *
 * 思路 : 自底向上求出数组每个元素左右边界(左右边界相乘就是该元素在最终结果出现的次数)
 * 执行时间 :　829ms
 * @author clay
 * @date 18-11-21 11:53
 */
public class Leetcode907 {

    class Element{
        int left;
        int right;
        public Element(int left, int roght) {
            this.left = left;
            this.right = roght;
        }
    }

    public int sumSubarrayMins(int[] A) {
        Element []dp = new Element[A.length];
        dp[0] = new Element(1,1);
        int mod = 1000000007;
        int result = 0;
        for(int i = 1; i < A.length && A[i] >= A[0]; i++){
            dp[0].right++;
        }
        System.out.println(dp[0].left + ":" + dp[0].right);
        result += dp[0].right * dp[0].left * A[0];
        result %= mod;
        for(int i = 1; i < A.length; i++){
            dp[i] = new Element(1,1);
            if(A[i] > A[i-1]){
                for(int j = i + 1; j < A.length && A[j] >= A[i]; j++){
                    dp[i].right++;
                }
            }else {
                int k;
                while((k=i-dp[i].left) >= 0 && A[k] > A[i]){
                    dp[i].left += dp[k].left;
                }
                for(int j = i + 1; j < A.length && A[j] >= A[i]; j++){
                    dp[i].right++;
                }
            }
            System.out.println(dp[i].left + ":" + dp[i].right);
            result += dp[i].left * dp[i].right * A[i];
            result %= mod;
        }
        return result;
    }

    public static void main(String ...args){
        Leetcode907 l = new Leetcode907();
        System.out.println(l.sumSubarrayMins(new int[]{3,1,2,4}));
    }
}
