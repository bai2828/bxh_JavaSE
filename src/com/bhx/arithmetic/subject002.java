package com.bhx.arithmetic;

public class subject002 {

	/**
	 * 递归实现 输入n输出n！
	 */
	
	public static void main(String[] args) {
		
		System.out.println(factorial(6));
		System.out.println(factorial2(6));
	}

	/**
	 * 递归方式实现
	 */
	public static int factorial(int n){
		if(n==0)
			return 1;
		else
			return n*factorial(n-1);
	}
	//算法实现
	public static int factorial2(int n){
		int v = 1;
		for (int i = 1; i <n+1 ; i++) {
			v = v*i;
		}
		return v;
	}

}
