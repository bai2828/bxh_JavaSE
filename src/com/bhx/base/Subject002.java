package com.bhx.base;

public class Subject002 {


    /**
     * 给定两个字符串s和t， 写一个函数来决定是否t是s的重组词。你可以假设字符串只包含小写字母。
     */
    public static boolean isAnagram(String s, String t) {
        //首先单词位数需相等
        if(s.length()!=t.length())
            return false;
        //创建一个26位的int数组，数组元素默认值为0；
        int bit[] = new int[26];
        //遍历单词A,将每个字母所在下标的元素值自增。
        // 若单词为：abcb 则数组为： {1,2,1,0,0,0,0……}
        for(int i=0;i<s.length();i++){
            bit[s.charAt(i)-'a']++;
        }
        //遍历单词B,将该数组中，每个字母出现过的下标自减，
        // 遇到未出现过的字母或同一字母出现次数超过单词A的则return；
        for(int i=0;i<s.length();i++){
            if(--bit[t.charAt(i)-'a']<0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("abcceg","acbgec")) ;
    }
}
