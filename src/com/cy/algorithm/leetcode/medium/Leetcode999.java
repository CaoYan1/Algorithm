package com.cy.algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * 题名 : 车的最大捕获量
 * 题目 : 在一个 8 x 8 的棋盘上，有一个白色车（rook）。也可能有空方块，白色的象（bishop）和黑色的卒（pawn）。它们分别以字符 “R”，“.”，“B” 和 “p” 给出。大写字符表示白棋，小写字符表示黑棋。
 * 车按国际象棋中的规则移动：它选择四个基本方向中的一个（北，东，西和南），然后朝那个方向移动，直到它选择停止、到达棋盘的边缘或移动到同一方格来捕获该方格上颜色相反的卒。另外，车不能与其他友方（白色）象进入同一个方格。
 * 返回车能够在一次移动中捕获到的卒的数量。
 *
 * 思路 : 找到车遍历四个方向即可
 * @author clay
 * @date 19-2-24 10:44
 */
public class Leetcode999 {
    class Solution {
        public int numRookCaptures(char[][] board) {
            int[] pos = new int[2];
            for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                    if (board[i][j] == 'R'){
                        pos = new int[]{i,j};
                    }
                }
            }
            int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            int count = 0;
            for (int i = 0; i < direction.length; i++){
                int[] p = Arrays.copyOf(pos,2);
                while (true){
                    if (p[0] < 0 || p[1] < 0 || p[0] >= 8 || p[1] >= 8){
                        break;
                    }
                    if (board[p[0]][p[1]] == 'p'){
                        count++;
                        break;
                    }else if (board[p[0]][p[1]] == 'B'){
                        break;
                    }
                    p[0] += direction[i][0];
                    p[1] += direction[i][1];
                }
            }
            return count;

        }
    }
}
