package com.bhx.arithmetic;

import java.util.HashMap;
import java.util.Map;

public class CountElements {

    /**
     * 判断字符串中各字符出现的次数 例如："abfdogetnetsd";
     * @param str
     */
    public static void countElements(String str){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i<str.length() ; i++){
            char[] arr = str.toCharArray();
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(Character it:map.keySet()){
            System.out.println(it+"出现的个数是："+map.get(it));
        }
    }
}
