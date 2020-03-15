package com.bhx.arithmetic;

/**
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-array-into-three-parts-with-equal-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class subject009 {

    public static void main(String[] args) {
//        int[] arr = {0,2,1,-6,6,-7,9,1,2,0,1};
        int[] arr = {10,-10,10,-10,10,-10,10,-10};
       boolean v = canThreePartsEqualSum(arr);
        System.out.println(v);
    }

    /**
     * 思路，数组和Sum为3的倍数，数据元素累加过程中必定会出现Sum的1/3,Sum的2/3。
     * @param A
     * @return
     */
    public static boolean canThreePartsEqualSum(int[] A) {
        int sum =0;
        for (int i = 0; i <A.length ; i++) {
            sum+=A[i];
        }
        if (sum%3!=0) return false;
        int aim = sum/3;
        int temp = 0;
        int flag = 0;
        for (int i = 0; i <A.length ; i++) {
            temp+=A[i];
            if (flag==2){
                continue;
            }
            if (temp==aim){
                temp=0;
                ++flag;
                if (i==A.length-1) return false;
            }
        }
        if (temp==aim ) return true;
        return false;
    }
}


