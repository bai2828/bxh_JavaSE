package com.bhx.arithmetic;

import java.io.File;

public class Subject016 {

    public static void main(String[] args) {
        String path ="E:\\视频资料\\Spring";
        listFile(path);
    }


    /**
     * 读取文件夹下的所有文件,并重命名
     */

    public static void listFile(String path) {
        if (path == null) {
            return;// 因为下面的new File如果path为空，回报异常
        }
        File[] files = new File(path).listFiles();
        if (files == null) {
            System.out.println("is empty！！");
            return;
        }
        for(File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
                if (file.getName().indexOf("__")>0){
                    String newName = file.getName().replace("__","_佟刚_");
                    File parentPath = file.getParentFile();
                    File newDir = new File(parentPath + "/" + newName);//文件所在文件夹路径+新文件名
                    file.renameTo(newDir);//重命名
                    System.out.println("修改后：" + newDir);
                }
            } else if (file.isDirectory()) {
                System.out.println("Directory:"+file.getName());
            } else {
                System.out.println("Error");
            }
        }
    }
}
