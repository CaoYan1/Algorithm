package com.cy.algorithm.leetcode.medium;

/**
 * 題名 : RLE迭代器
 * 題目 : 编写一个遍历游程编码序列的迭代器。
 * 迭代器由 RLEIterator(int[] A) 初始化，其中 A 是某个序列的游程编码。更具体地，对于所有偶数 i，A[i] 告诉我们在序列中重复非负整数值 A[i + 1] 的次数。
 * 迭代器支持一个函数：next(int n)，它耗尽接下来的  n 个元素（n >= 1）并返回以这种方式耗去的最后一个元素。如果没有剩余的元素可供耗尽，则  next 返回 -1 。
 * 例如，我们以 A = [3,8,0,9,2,5] 开始，这是序列 [8,8,8,5,5] 的游程编码。这是因为该序列可以读作 “三个八，零个九，两个五”。
 *
 * 思路 : 用一個指针指向A的当前位置,每次指针跳两个元素
 * 執行時間 : 75ms
 * @author clay
 * @date 18-11-17 15:30
 */
public class Leetcode900 {
    class RLEIterator {

        private int curPos;
        private int []A;


        public RLEIterator(int[] A) {
            this.A = A;
            curPos = 0;
        }

        public int next(int n) {
            while(n > 0){
                if(curPos >= A.length){
                    return -1;
                }
                if(A[curPos] >= n){
                    A[curPos] -= n;
                    n = 0;
                }else {
                    n -= A[curPos];
                    curPos += 2;
                }
            }
            return A[curPos+1];
        }
    }

    public static void main(String ...args){

    }
}
