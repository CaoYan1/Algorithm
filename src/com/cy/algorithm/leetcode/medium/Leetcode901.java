package com.cy.algorithm.leetcode.medium;

import java.util.ArrayList;

/**
 * 题名 : 股票价格跨度
 * 题目 : 编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。
 * 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，
 * 那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
 *
 * 思路 : 用数组记录每一天的price,直接倒着遍历会超时,需要把之前每一天的价格跨度保存起来,往前跳跃遍历
 * 执行时间 : 122ms
 * @author clay
 * @date 18-11-14 17:21
 */
public class Leetcode901 {

    class Stock{
        int price;
        int len;

        public Stock(int price, int len) {
            this.price = price;
            this.len = len;
        }
    }

    private ArrayList<Stock> list = new ArrayList<>(100001);

    private int cur = -1;

    public int next(int price) {
        int result = 1;
        int i = cur;
        Stock stock;
        while(i >=0 && (stock = list.get(i)).price <= price){
            result += stock.len;
            i -= stock.len;
        }
        list.add(new Stock(price,result));
        cur++;
        return result;
    }

    public static void main(String ...args){
        Leetcode901 l = new Leetcode901();
        int []arr = new int[]{100,80,60,70,60,75,85};
        for(int i : arr){
            System.out.println(l.next(i));
        }


    }
}
