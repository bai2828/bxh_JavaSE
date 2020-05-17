package com.bhx.arithmetic;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/**
 * 将两个有序数组合并，并去重
 */
public class Subject015 {

    public static void main(String[] args) {

        Integer[] arr1={1,2,3,4,5,5,6,6,7};
        Integer[] arr2={2,3,4,4,5,6,8,8,9,10,11};
        Integer[] arr = merge(arr1,arr2);
        System.out.println(Arrays.toString(arr));
    }

    public static Integer[] merge(Integer[] arr1,Integer[] arr2){
        List<Integer> list1 = Arrays.asList(arr1);
        List<Integer> list2 = Arrays.asList(arr2);
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(list1);
        treeSet.addAll(list2);
        Integer[] result = treeSet.toArray(new Integer[treeSet.size()]);
        return result;
    }
}
