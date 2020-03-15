package com.bhx.arithmetic;
/**   
 * @Title:连续数字中，找出缺失的数    
 * @Description:   
 * @author: bhx  
 * @date: 2018年8月28日      
 */
public class findLoseKey {

	public static void main(String[] args) {
		int[] a = {1, 2, 5, 4, 6, 9, 7, 8, 10};
		int[] b = {2, 5, 4, 6, 9, 7, 8, 10,11};
		System.out.println(findloseNum(a));
		System.out.println(findloseNumNew(b,2));
	}

    /**
     * 算法实现1
     * 缺点：只能支持固定起始值的数组
     * @param a
     * @return
     */
	public static int findloseNum(int[] a){
        int b[] = null;
        b = new int[a.length+1]; //缺失几个数，就多开辟几个长度。
        for (int i = 0; i < a.length; i++) {
            //由于数组是从1开始的，所以此处下标-1
            b[ a[i]-1 ] = 1;
        }
        for(int i = 0; i < b.length; i++) {
            if (b[i] == 0) {
                return (i+1);
            }
        }
		return -1;
	}

    /**
     * 算法实现2
     * @param a
     * @param start
     * @return
     */
	public static int findloseNumNew(int[] a , int start){
        int b[] = null;
        b = new int[a.length+1]; //缺失几个数，就多开辟几个长度。
        for (int i = 0; i < a.length; i++) {
            //由于数组是从1开始的，所以此处下标-1
            b[ a[i]-start ] = 1;
        }
        for(int i = 0; i < b.length; i++) {
            if (b[i] == 0) {
                return (i+start);
            }
        }
        return -1;
    }
}
