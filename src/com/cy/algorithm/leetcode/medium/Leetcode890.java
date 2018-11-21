package com.cy.algorithm.leetcode.medium;

import java.util.*;

/**
 * 题名 : 查找和替换模式
 * 题目 : 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * 返回 words 中与给定模式匹配的单词列表。
 * 你可以按任何顺序返回答案。
 *
 * 思路 : hash表映射(注意hash表的value也不能重复)
 * 执行时间 : 7ms
 *
 * @author clay
 * @date 18-11-21 19:57
 */
public class Leetcode890 {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char []patternArr = pattern.toCharArray();
        List<String> result = new LinkedList<>();
        for(int i = 0; i < words.length; i++){
            char []arr = words[i].toCharArray();
            if(arr.length != patternArr.length){
                continue;
            }
            Map<Character,Character> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            for(int j = 0; j < arr.length; j++){
                if(map.containsKey(patternArr[j])){
                    if(map.get(patternArr[j]) == arr[j]){
                        if(j == arr.length - 1){
                            result.add(words[i]);
                        }
                    }else {
                        break;
                    }
                }else {
                    if(set.contains(arr[j])){
                        break;
                    }
                    if(j == arr.length - 1){
                        result.add(words[i]);
                        break;
                    }
                    map.put(patternArr[j],arr[j]);
                    set.add(arr[j]);
                }
            }
        }
        return result;
    }

    public static void main(String ...args){
        Leetcode890 l = new Leetcode890();
        List<String> result = l.findAndReplacePattern(new String[]{"abc","deq","mee","aqq","dkd","ccc"},
                "abb");
        for(String s : result){
            System.out.println(s);
        }
    }

}
