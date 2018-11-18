package com.cy.algorithm.leetcode.easy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题名 :按奇偶排序数组II
 * 问题 :给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * 思路 : 先排序,然后从左向右遍历,如果下标与当前元素值不相同,则往后遍历直到奇偶性相同然后交换
 * 也可以用插入排序,两个变量记录奇数和偶数当前索引
 * @author clay
 * @date 18-11-11 14:48
 */
public class Leetcode922 {

    public static int[] sortArrayByParityII(int[] A) {
        Arrays.sort(A);
        for(int i = 0; i < A.length; i++){
            if(((i ^ A[i]) & 1) != 0){
                //A[i]与i奇偶性不同
                for(int j = i + 1; j < A.length; j++){
                    if(((i ^ A[j]) & 1) == 0){
                        //交换位置
                        A[i] ^= A[j];
                        A[j] ^= A[i];
                        A[i] ^= A[j];
                        break;
                    }
                }
            }
        }
        return A;
    }

    public static void main(String ...args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []A = new int[n];
        for(int i = 0; i < n; i++){
            A[i] = in.nextInt();
        }
        sortArrayByParityII(A);
        for(int ele : A){
            System.out.println(ele);
        }

    }

}
