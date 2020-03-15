package com.bhx.arithmetic;

import java.io.*;
/**
 * 从a.txt中读取文本内容，存入b.txt中
 */
public class ReaderTest {

    public static void readerTest()throws IOException {
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
}
