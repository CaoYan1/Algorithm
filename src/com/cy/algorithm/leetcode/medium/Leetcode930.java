package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 和相等的二元子数组
 * 题目 : 在由若干 0 和 1  组成的数组 A 中，有多少个和为 S 的非空子数组。
 *
 * 思路 : 动态规划,F(i)为以A[i]结尾和为s的子数组数量,F(i) = F(i-1) + 开头0的个数(A[i]==1)
 * F(i) = F(i-1) (A[i]==0) 将S==0的情况单独处理
 * 执行时间 : 5ms
 * @author clay
 * @date 18-11-22 15:38
 */
public class Leetcode930 {

    public int numSubarraysWithSum(int[] A, int S) {
        int result = 0;
        if(S == 0){
            int temp = 0;
            for(int i = 0; i < A.length; i++){
                if(A[i] == 1){
                    result += (temp+1)*temp/2;
                    temp = 0;
                }else {
                    temp++;
                }
            }
            return result + (temp+1)*temp/2;
        }
        int last = 0;
        int start = -1;
        int i = 0;
        while(S != 0 && i < A.length){
            S -= A[i++];
        }
        if(i == A.length && S != 0){
            return 0;
        }
        for(int j = i - 1; j < A.length; j++){
            if(A[j] == 1){
                last = 1;
                while(A[++start] == 0){
                    last++;
                }
            }
            result += last;
        }
        return result;
    }


    public int numSubarraysWithSum1(int[] A, int S) {
        int last = 0;
        int bk = S;
        int start = -1;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(S != 0){
                if(bk == 0){
                    if(A[i] == 1){
                        last = 1;
                        while (A[++start] != 1){
                            last++;
                        }
                    }
                    result += last;
                }else {
                    bk -= A[i];
                    if(bk == 0){
                        i--;
                    }
                }
            }else {
                if(A[i] == 1){
                    last = 0;
                }else {
                    last++;
                }
                result += last;
            }

        }
        return result;
    }

    public static void main(String ...args){
        Leetcode930 l = new Leetcode930();
        System.out.println(l.numSubarraysWithSum1(new int[]{1,0,1,0,1},2));
    }

}
