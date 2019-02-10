package com.cy.algorithm.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * 题名 : 等式方程的可满足性
 * 题目 : 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
 * 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
 *
 * 思路 : 并查集算法,如果是等式则为同一棵数,如果为不等式且在同一棵树中就无法满足
 * @author clay
 * @date 19-2-10 10:55
 */
public class Leetcode990 {

    public static void main(String[] args) {
        Solution s = new Leetcode990().new Solution();
        System.out.println(s.equationsPossible(new String[]{"a==b","b!=c","c==a"}));
    }

    class Solution {
        public int[] pre = new int[27];

        int Find(int x) {
            int root = x;
            while ((x = pre[x]) != 0){
                root = x;
            }
            return root;
        }

        void join(int x,int y) {
            int fx=Find(x);
            int fy=Find(y);
            if(fx!=fy)
                pre[fx]=fy;

        }

        public boolean equationsPossible(String[] equations) {
            List<String> notEquel = new LinkedList<>();
            for(String equation : equations){
                if(equation.charAt(1) == '='){
                    int  c1 = equation.charAt(0) - 96;
                    int  c2 = equation.charAt(3) - 96;
                    if(c1 == c2){
                        continue;
                    }
                    join(c1,c2);
                }else {
                    notEquel.add(equation);
                }
            }
            for(String equation : notEquel){
                int  c1 = equation.charAt(0) - 96;
                int  c2 = equation.charAt(3) - 96;
                if(c1 == c2){
                    return false;
                }
                int root1 = Find(c1);
                int root2 = Find(c2);
                if((root1 == root2 && root1 != 0) || root1 == c2 || root2 == c1){
                    return false;
                }
            }
            return true;
        }
    }
}
