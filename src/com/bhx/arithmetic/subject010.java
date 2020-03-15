package com.bhx.arithmetic;

import java.util.Stack;

public class subject010 {

    public static void main(String[] args) {
//        int[] arr = {4,10,4,3,8,9};
          int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(getMaxSub(arr));
    }

    /**
     * 尚未实现
     * @param arr
     * @return
     */
    public static int getMaxSub(int[] arr){
        Stack stack=new Stack();
        for (int i = 0; i <arr.length ; i++) {
            if (stack.empty()){
                stack.push(arr[i]);
            }else {
                while (!stack.empty()){
                    if (arr[i]>(int)stack.peek()){
                        stack.push(arr[i]);
                        break;
                    }else if (arr[i]<(int)stack.peek()){
                        stack.pop();
                    } else {
                        stack.pop();
                        break;
                    }
                }
                if (stack.empty()) stack.push(arr[i]);
            }
        }
        return stack.size();
    }

}
