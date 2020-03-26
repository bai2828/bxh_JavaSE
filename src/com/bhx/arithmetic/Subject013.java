package com.bhx.arithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 注意：每次拼写时，chars 中的每个字母都只能用一次。
 返回词汇表 words 中你掌握的所有单词的 长度之和。
 示例 1：
 输入：words = ["cat","bt","hat","tree"], chars = "atach"
 输出：6
 解释：
 可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 示例 2：
 输入：words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 输出：10
 解释：
 可以形成字符串 "hello" 和 "world"，所以答案是 5 + 5 = 10。
 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subject013 {

    public static void main(String[] args) {
//        String[] words = {"cat","bt","hat","tree"};
//        String[] words = {"hello","world","leetcode"};
        String[] words = {"boygirdlggnh"};
//        String chars = "atach";
//        String chars = "welldonehoneyr";
        String chars = "usdruypficfbpfbivlrhutcgvyjenlxzeovdyjtgvvfdjzcmikjraspdfp";
        getWordsLength(words,chars);
    }

    public static int getWordsLength(String[] words , String chars){

        List<String> list =new ArrayList<>();
        int result = 0;
        for (int i = 0; i <words.length ; i++) {
            char[] array = words[i].toCharArray();
            String temp = chars;
            for (int j = 0; j <array.length ; j++) {
                if (temp.indexOf(array[j])<0) break;
                if (temp.indexOf(array[j])>=0){
                    temp = temp.replaceFirst(String.valueOf(array[j]),"");
                }
                if (j==array.length-1){
                    list.add(words[i]);
                    result +=words[i].length();
                }
            }
        }
        for (String r: list) {
            System.out.println("word:"+r);
        }
        System.out.println("result"+result);
        return result;
    }
}
