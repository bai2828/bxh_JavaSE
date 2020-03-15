package com.bhx.arithmetic;

/**
 *  判断一个数是否为2的n次方
 */
public class Subject011 {

    public static boolean isPower1(int x){
        if(x<1) return false;
        int i = 1;
        while(x>=i){
            if(x==i) return true;
            i<<=1;
        }
        return false;
    }
}
