package com.cy.algorithm.leetcode.medium;

/**
 * 题名 : 水果成蓝
 * 题目 : 在一排树中，第 i 棵树产生 tree[i] 型的水果。
 * 你可以从你选择的任何树开始，然后重复执行以下步骤：
 *  1.把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。
 *  2.移动到当前树右侧的下一棵树。如果右边没有树，就停下来。
 * 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。
 * 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。
 * 用这个程序你能收集的水果总量是多少？
 *
 * 思路 : 两个指针记录当前最长的两个水果的长度以及末尾索引
 * 执行时间 : 20ms
 *
 * @author clay
 * @date 18-11-18 08:40
 */
public class Leetcode904 {

    class Element{
        int index;
        int len;

        public Element(int index) {
            this.index = index;
            this.len = 1;
        }
    }

    public int totalFruit(int[] tree) {
        if(tree == null){
            return 0;
        }
        if(tree.length < 2){
            return tree.length;
        }
        int temp = 1;
        while(temp < tree.length && tree[temp++] == tree[0]){

        }
        Element e1 = new Element(temp-2);
        e1.len = temp-1;
        Element e2 = new Element(temp-1);
        int result = e1.len + e2.len;
        for(int i = temp; i < tree.length; i++){
            if(tree[i] == tree[e1.index]){
                e1.index = i;
                e1.len++;
            }else if(tree[i] == tree[e2.index]){
                e2.index = i;
                e2.len++;
            }else {
                if(e1.index > e2.index){
                    e1.len = e1.index - e2.index;
                    e2.index = i;
                    e2.len = 1;
                }else {
                    e2.len = e2.index - e1.index;
                    e1.index = i;
                    e1.len = 1;
                }
            }
            if(e1.len + e2.len > result){
                result = e1.len + e2.len;
            }
        }
        return result;
    }

    public static void main(String ...args){
        Leetcode904 l = new Leetcode904();
        System.out.println(l.totalFruit(new int[]{0,1,2,2}));
    }
}
