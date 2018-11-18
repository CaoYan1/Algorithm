package com.cy.algorithm.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 题名 : 螺旋矩阵III
 * 题目 : 在 R 行 C 列的矩阵上，我们从 (r0, c0) 面朝东面开始
 * 这里，网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * 现在，我们以顺时针按螺旋状行走，访问此网格中的每个位置。
 * 每当我们移动到网格的边界之外时，我们会继续在网格之外行走（但稍后可能会返回到网格边界）。
 * 最终，我们到过网格的所有 R * C 个空间。
 * 按照访问顺序返回表示网格位置的坐标列表。
 *
 * 思路 : 定义四个方向,每走完两个不同的方向步数就加一,走完所有位置结束循环
 * 执行时间 : 18ms
 * @author clay
 * @date 18-11-11 17:28
 */
public class Leetcode885 {


    public static int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<int []> result = new ArrayList<>();
        int stride = 1;
        int dir = 0;
        int []x = new int[]{0,1,0,-1};
        int []y = new int[]{1,0,-1,0};
        if(r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
            result.add(new int[]{r0,c0});
        }
        while(result.size() != R*C){
            for(int i = 0; i < 2; i++){
                for(int j = 0; j < stride; j++){
                    r0 += x[dir];
                    c0 += y[dir];
                    if(r0 >= 0 && r0 < R && c0 >= 0 && c0 < C){
                        result.add(new int[]{r0,c0});
                    }
                }
                dir = (dir + 1)%4;
            }
            stride++;

        }
        int [][]resultArray = new int[R*C][2];
        return result.toArray(resultArray);
    }

    public static void main(String ...args){
        int [][]result = spiralMatrixIII(5,6,1,4);
        for(int[] e : result){
            for(int i : e){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
