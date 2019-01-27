package com.cy.algorithm.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 题名 : 基于时间的键值存储
 * 题目 : 创建一个基于时间的键值存储类 TimeMap，它支持下面两个操作：
 * 1. set(string key, string value, int timestamp)
 *     存储键 key、值 value，以及给定的时间戳 timestamp。
 * 2. get(string key, int timestamp)
 *     返回先前调用 set(key, value, timestamp_prev) 所存储的值，其中 timestamp_prev <= timestamp。
 *     如果有多个这样的值，则返回对应最大的  timestamp_prev 的那个值。
 *     如果没有值，则返回空字符串（""）。
 *
 * 思路 : 用hashmap存储,每个key对应一个treemap
 * @author clay
 * @date 19-1-27 10:43
 */
public class Leetcode985 {

    public static void main(String[] args) {
        TimeMap timeMap = new Leetcode985().new TimeMap();
        timeMap.set("love","high",10);
        timeMap.set("love","low",20);
        System.out.println(timeMap.get("love",5));
    }
    class TimeMap {

        public Map<String, TreeMap<Integer, String>> map;
        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer,String> treeMap = map.getOrDefault(key,null);
            if(treeMap == null){
                treeMap = new TreeMap<>();
                map.put(key,treeMap);
            }
            treeMap.put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.getOrDefault(key,null);
            if(treeMap == null){
                return "";
            }
            Map.Entry<Integer,String> entry;
            return (entry = treeMap.floorEntry(timestamp)) == null ? "" : entry.getValue();
        }
    }
}
