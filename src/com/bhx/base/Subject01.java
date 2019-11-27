package com.bhx.base;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 程序设计类
 * @param
 */
public class Subject01 {
    //方法测试入口
    public static void main(String[] args) {
        int[] arr = {3,6,5,7,2,1,8};
        int[] arr1 = {2,4,5,6,7,8,9};
//冒泡测试
// System.out.println(Arrays.toString(maoPaoSort(arr)));
//选择测试
// System.out.println(Arrays.toString(xuanZeSort(arr)));
//递归求阶乘
// System.out.println(diGuiFactorial(3));
//二分查找
// System.out.println(binaryFind(arr1,5,0,arr1.length));
//单词反序
        System.out.println(reverseStr("please input a String"));
    }

    /**
     * 冒泡排序
     */
    public static int[] maoPaoSort(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t ;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     */
    public static int[] xuanZeSort(int[] arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]>arr[j]){
                    int t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
        return arr;
    }

    /**
     * 递归方式计算阶乘
     * @param n
     * @return
     */
    public static int diGuiFactorial(int n){
        if (n == 1){
            return 1;
        }
        return n*diGuiFactorial(n-1);
    }

    /**
     * 二分查找方法
     * @param arr
     * @param key
     * @return
     */
    public static int binarySearc(int[] arr, int key){
        int min = 0;
        int max = arr.length;
        while (min<max){
            int mid = (min+max)/2;
            if (key>arr[mid]){
                min = mid+1;
            }else if (key<arr[mid]){
                max = mid-1;
            }else {
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

    /**
     * 输入“please input a String” 输出“String a input please”;
     * @param str
     * @return
     */
    public static String reverseStr(String str){
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >= 0 ; i--) {
            if (i>0){
                sb.append(arr[i]+" ");
            }else{
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 从a.txt中读取文本内容，存入b.txt中
     * @throws IOException
     */
    public static void readerTest()throws IOException{
        BufferedWriter bw = null;
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(new File("D://a.txt")));
            String str = br.readLine();
            if(str != null ){
                System.out.println(str);
            }
            bw = new BufferedWriter(new FileWriter(new File("D://b.txt")));
            bw.write(str);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            br.close();
            bw.close();
        }
    }

    /**
     * 判断一个数是否为2的n次方
     * @param x
     * @return
     */
    public static boolean isPower1(int x){
        if(x<1) return false;
        int i = 1;
        while(x>=i){
            if(x==i) return true;
            i<<=1;
        }
        return false;
    }

    /**
     * 传入String s = “abc-eee-ppp” 返回[“abc”,” eee”,” ppp”]不使用split。
     * @param s
     * @param mark
     * @return
     */
    public static String[] getArray(String s, String mark) {
        StringTokenizer st = new StringTokenizer(s, mark);
        int count = st.countTokens();
        String[] strs = new String[count];
        int i = 0;
        while (st.hasMoreElements()) {
            strs[i] = (String) st.nextElement();
            i++;
        }
        return strs;
    }

    /**
     * 输入“abc1yi2mm 3gk4”输出“1234”
     * @param str
     */
    public static String getNum(String str) {
        return str.replaceAll("[^\\d]", "");
    }

    /**
     * 判断字符串中各字符出现的次数 例如："abfdogetnetsd";
     * @param str
     */
    public static void countElements(String str){
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0 ; i<str.length() ; i++){
            char[] arr = str.toCharArray();
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        for(Character it:map.keySet()){
            System.out.println(it+"出现的个数是："+map.get(it));
        }
    }

    /**
     * 键盘输入三个整数,若他们相等则打印equal。
     */
    public static void testScanner(){
        Scanner sc = new Scanner(System.in);
        System.out.println("键盘输入三个字");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (a==b && b==c){
            System.out.println("equal!!");
        }else {
            System.out.println("not equal!!!");
        }
    }

}