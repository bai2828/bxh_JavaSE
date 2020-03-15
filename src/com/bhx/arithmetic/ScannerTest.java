package com.bhx.arithmetic;

import java.util.Scanner;

public class ScannerTest {

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

