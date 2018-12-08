package com.cy.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * description
 *
 * @author clay
 * @date 18-12-8 16:04
 */
public class Leetcode$934 {
    class Solution {
        public int shortestBridge(int[][] A) {
            Queue<int[]> queue = new LinkedList<>();
            int[][] direction = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            boolean found = false;
            for(int i = 0; i < A.length; i++){
                for(int j = 0; j < A[0].length; j++){
                    if(!found && A[i][j] == 1){
                        dfs(A,i,j);
                        found = true;
                    }
                    if(found && A[i][j] == 1){
                        queue.offer(new int[]{i,j});
                    }
                }
            }
            int min = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int []point = queue.poll();
                    for(int j = 0; j < 4; j++){
                        int x = point[0] + direction[j][0];
                        int y = point[1]+direction[j][1];
                        if(x < 0 || x >= A.length || y < 0 || y >= A[0].length || A[x][y] == 1){
                            continue;
                        }else if(A[x][y] == 0){
                            A[x][y] = 1;
                            queue.offer(new int[]{x,y});
                        }else if(A[x][y] == 2){
                            return min;
                        }
                    }
                }
                min++;
            }
            return -1;
        }

        private void dfs(int [][]A, int a, int b){
            if(a < 0 || a >= A.length || b < 0 || b >= A[0].length || A[a][b] == 2 || A[a][b] == 0){
                return;
            }
            A[a][b] = 2;
            dfs(A,a+1,b);
            dfs(A,a-1,b);
            dfs(A,a,b+1);
            dfs(A,a,b-1);

        }
    }

    public static void main(String ...args){
        Solution s = new Leetcode$934().new Solution();
        int result = s.shortestBridge(new int[][]{{0,1,0},{0,0,0},{0,0,1}});
        System.out.println(result);
    }
}
