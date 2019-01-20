package com.cy.algorithm.leetcode.hard;

/**
 * 题名 : 不同路径III
 * 题目 : 在二维网格 grid 上，有 4 种类型的方格：
 *     1 表示起始方格。且只有一个起始方格。
 *     2 表示结束方格，且只有一个结束方格。
 *     0 表示我们可以走过的空方格。
 *     -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
 *
 * 思路 : 深度优先搜索,记录0方格总共的次数,到终点判断次数是否相等.
 * @author clay
 * @date 19-1-20 11:25
 */
public class Leetcode980 {
    public static void main(String[] args){
        Solution s = new Leetcode980().new Solution();
        System.out.println(s.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
    class Solution {

        public int result = 0;
        public int sum;
        public int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
        public void dfs(int[][] grid, int cur, int x, int y){
            if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1){
                return;
            }
            if(grid[x][y] == 2){
                if(cur == sum + 1){
                    result++;
                    return;
                }else {
                    return;
                }
            }
            grid[x][y] = -1;
            for(int i = 0; i < 4; i++){
                dfs(grid,cur+1,x+direction[i][0],y+direction[i][1]);

            }
            grid[x][y] = 0;
        }
        public int uniquePathsIII(int[][] grid) {
            int[] start = new int[2];
            int[] end = new int[2];
            sum = 0;
            for(int i = 0 ; i < grid.length; i++){
                for(int j = 0; j < grid[0].length; j++){
                    if(grid[i][j] == 0){
                        sum++;
                    }else if(grid[i][j] == 1){
                        start[0] = i;
                        start[1] = j;
                    }else if(grid[i][j] == 2){
                        end[0] = i;
                        end[1] = j;
                    }

                }
            }
            dfs(grid,0,start[0],start[1]);
            return result;
        }
    }
}
