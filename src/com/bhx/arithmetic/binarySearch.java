package com.bhx.arithmetic;

public class binarySearch {

	public static void main(String[] args) {
		int[] arr = {3,5,7,9,11,24,54,57,80}; 
		int a = search(arr,11);
		    a = search1(arr,11);
		System.out.println(a);
	}
	
	/*
	 * 方式1
	 */
	private static int search(int[] arr , int key){
		int min = 0;
		int max = arr.length-1;
		int mid = (min+max)/2;
		while(key != arr[mid]){
			if(key>arr[mid]){
				min = mid+1;
			}else{
				max = mid-1;
			}
			mid = (min+max)/2;
			if(min>max) return -1;
		}		
		return mid;
	}
	
	/*
	 * 方式2
	 */
	private static int search1(int[] arr , int key){
		int min = 0;
		int max = arr.length-1;
		while(min <= max){
			int mid = (min+max)/2;
			if(key>arr[mid]){
				min = mid+1; 
			}else if(key<arr[mid]){
				max = mid-1;
			}else{
				return mid;
			}
		}		
		return -1;
	}

	/**
	 * 递归方式实现二分查找
	 * @param arr
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 */
	public static int binaryFind(int[] arr,int key,int min, int max){
		int mid = (min+max)/2;
		if(min>max){
			return -1;
		}else if (arr[mid]==key){
			return mid;
		}else if (arr[mid]>key){
			return binaryFind(arr,key,min,mid-1);
		}else{
			return binaryFind(arr,key,mid+1,max);
		}
	}
}
