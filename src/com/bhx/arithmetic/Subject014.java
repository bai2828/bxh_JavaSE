package com.bhx.arithmetic;

import java.util.Arrays;

/**
 * 找出数组中最大的K个数
 */
public class Subject014 {


    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        System.out.println(Arrays.toString(findLestKeys(arr,3)));

    }

    public static int[] findLestKeys(int[] arr,int k){
        for (int i = 0; i <k ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if (arr[i]>arr[j]){
                    int t = arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        return Arrays.copyOf(arr,k);
    }
}
