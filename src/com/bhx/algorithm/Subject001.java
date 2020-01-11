package com.bhx.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个不包含相同元素的整数集合，nums，返回所有可能的子集集合。解答中集合不能包含重复的子集
 */
public class Subject001 {

    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        if(nums.length == 0 || nums == null)
            return res;
        Arrays.sort(nums); //排序
        dfs(nums, 0, item, res);  //递归调用
        res.add(new ArrayList<Integer>());  //最后加上一个空集
        return res;
    }
    public static void dfs(int[] nums, int start, List<Integer> item, List<List<Integer>> res){
        for(int i = start; i < nums.length; i ++){
            item.add(nums[i]);
            //item是以整数为元素的动态数组，而res是以数组为元素的数组，在这一步，当item增加完元素后，item所有元素构成一个完整的子串，再由res纳入
            res.add(new ArrayList<Integer>(item));
            dfs(nums, i + 1, item, res);
            item.remove(item.size() - 1);
        }
    }
}
