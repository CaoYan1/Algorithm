package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 镜面反射
 * 题目 : 有一个特殊的正方形房间，每面墙上都有一面镜子。除西南角以外，每个角落都放有一个接受器，编号为 0， 1，以及 2。
 * 正方形房间的墙壁长度为 p，一束激光从西南角射出，首先会与东墙相遇，入射点到接收器 0 的距离为 q 。
 * 返回光线最先遇到的接收器的编号（保证光线最终会遇到一个接收器）。
 *
 * 思路 : 假设没有上下两面镜子,光线穿透上面镜子和反射到左右两边镜子形成的三角形全等,所以去掉上下两面镜子,如果反射
 * 距离变成p的整数倍就到达了接收点,如果是奇数倍就为上面哪个接收器,偶数倍则为下面那个接收器
 * @author clay
 * @date 19-2-4 18:57
 */
public class Leetcode858 {

    class Solution {

        public int mirrorReflection(int p, int q) {
            int dist = 0;
            int d = 0;
            int remain;
            while(true)
            {
                d++;
                dist += q;
                remain = dist%(2*p);
                if(remain == p)
                {
                    if(d%2 == 1)
                        return 1;
                    else
                        return 2;
                }
                if(remain == 0)
                    return 0;
            }

        }
    }
}
