package com.bhx.arithmetic;

import java.util.Arrays;

/**
 *物流公司要给快递员派单，有 N 个快递员站成了一条直线，系统会根据每个快递员的表现，预先给他们评分。
 * 你需要按照以下要求，帮助系统给这些快递员分发包裹：
 * 每个快递员至少分配到 1 个包裹。
 * 相邻的快递员中，评分高的快递员必须获得更多的包裹。
 * 那么这样下来，公司至少需要准备多少个包裹呢？
 * 示例 1:
 * 输入: [1,0,2]
 * 输出: 5
 * 解释: 你可以分别给这三个快递员分发 2、1、2 个包裹。
 * 示例 2:
 * 输入: [1,2,2]
 * 输出: 4
 * 解释: 你可以分别给这三个快递员分发 1、2、1 个包裹。
 * 第三个快递员只得到 1 个包裹，这已满足上述两个条件。
 */
public class Subject012 {

    public static void main(String[] args) {
        int[] arr ={1,0,3,4,3,2,1};
//        int[] arr ={2,1,2,4,3,2,1};
//        int[] arr ={1,0,2};
        System.out.println(sumTest(arr));
    }

    public static int sumTest(int arr []){
        int[] aim=new int[arr.length];//每个员工包裹数
        int t = 0;//评分连续降及持平次数
        for (int i = 0; i <arr.length ; i++) {
            //默认初始都有1个件
            aim[i]=1;
            //记录评分连续降低或持平次数
            if (i>0 &&arr[i]<=arr[i-1]) t++;
            //如果第i个员工评分小于前一个人，且前一个员工件数为1，则前t个员工件数需重新判断是否+1个包裹
            if (i>0 &&arr[i]<arr[i-1] && aim[i-1]==aim[i]){
                for (int j = 0; j < t ; j++) {
                    //若前j+1个员工评分大于当前员工，但包裹数小于等于当前员工，则需加1
                    if (arr[i-j-1]>arr[i-j] && aim[i-j-1]<=aim[i-j]){
                        aim[i-j-1]=aim[i-j-1]+1;
                    }
                    //若前j+1个员工评分等于当前员工，但包裹数小于当前员工，则需加1
                    if (arr[i-j-1]==arr[i-j] && aim[i-j-1]<aim[i-j]){
                        aim[i-j-1]=aim[i-j-1]+1;
                    }
                }
                //如果第i个员工评分大于前一个员工，则第i个员工包裹数=前一个员工包裹数+1
            }else if (i>0 &&arr[i]>arr[i-1]){
                aim[i]=aim[i-1]+1;
                t=0;//连续中断
            }
        }
        System.out.println(Arrays.toString(aim));
        int result =0;
        for (int i = 0; i <aim.length ; i++) {
            result+=aim[i];
        }
        return result;
    }



}
