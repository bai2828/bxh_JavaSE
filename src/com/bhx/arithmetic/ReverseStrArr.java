package com.bhx.arithmetic;

import java.util.StringTokenizer;

/**
 * 输入“please input a String” 输出“String a input please”;
 */
public class ReverseStrArr {

    public static void main(String[] args) {
        String arr = "please input a String";
        System.out.println(reverseStr(arr));
        System.out.println(getArray(arr," "));
    }

    /**
     * 数组转置方式实现
     * @param str
     * @return
     */
    public static String reverseStr(String str){
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (i>0){
                sb.append(arr[i]+" ");
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * StringTokenizer 类实现
     * @param s
     * @param mark
     * @return
     */
    public static String getArray(String s, String mark) {
        StringTokenizer st = new StringTokenizer(s, mark);
        String str = "";
        while (st.hasMoreElements()) {
            str= st.nextElement()+mark+str;
        }
        return str;
    }
}
