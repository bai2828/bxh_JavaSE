package com.bhx.arithmetic;

import java.util.Arrays;

/*
 * 1.快速找出一个数组中的最大数、第二大数。
 *
 * 思路：如果当前元素大于最大数 max，则让第二大数等于原来的最大数 max， 再把当前元素的值赋给
 * max。如果当前的元素大于等于第二大数secondMax的值 而小于最大数max的值，则要把当前元素的值赋给 secondMax。
 */
public class subject006 {

    public static void main(String[] args) {

        int[] arr = { 12, 49, 23, 32, 148, 48, };
        System.out.println(Arrays.toString(findMaxValues(arr)));
        System.out.println(Arrays.toString(findMaxValues1(arr)));
    }

    /**
     * 实现方式1
     * @param arr
     * @return
     */
    public static int[] findMaxValues(int arr[]){
        int[] result = new int[2];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int secondMax = arr[0];
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > secondMax && arr[j] < max) {
                secondMax = arr[j];
            }
        }
        result[0]=max;
        result[1]=secondMax;
        return result;
    }

    /**
     * 实现方式2
     * @param arr
     * @return
     */
    public static int[] findMaxValues1(int arr[]){
        int[] result = Arrays.copyOf(arr,2);
        for (int i = 2; i < arr.length; i++) {
                if (result[0]<result[1]){
                    int t = result[0];
                    result[0]=result[1];
                    result[1] =t;
                }
                if (arr[i] > result[1]) {
                    result[1]=arr[i];
                }
        }
        return result;
    }
}
