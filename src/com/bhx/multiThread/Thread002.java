package com.bhx.multiThread;

public class Thread002 {

    //重写ThreadLocal变量的默认值
    private static ThreadLocal num = ThreadLocal.withInitial(() -> 0);

    public static void main(String[] args) {
        // 创建一号线程
        new Thread(()-> {
            // 在一号线程中将ThreadLocal变量设置为1
            num.set(1);
            System.out.println("一号线程中ThreadLocal变量中保存的值为：" + num.get());
        }).start();

        // 创建二号线程
        new Thread(() ->{
            num.set(2);
            System.out.println("二号线程中ThreadLocal变量中保存的值为：" + num.get());
        }).start();

        //为了让一二号线程执行完毕，让主线程睡500ms
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("主线程中ThreadLocal变量中保存的值：" + num.get());
    }

    /**
     * 程序结果重点看的是主线程输出的是0，如果是一个普通变量，在一号线程和二号线程中将普通变量设置为1和2，
     * 那么在一二号线程执行完毕后在打印这个变量，输出的值肯定是1或者2（到底输出哪一个由操作系统的线程调度逻辑有关）。
     * 但使用ThreadLocal变量通过两个线程赋值后，在主线程程中输出的却是初始值0。
     * 在这也就是为什么“一个ThreadLocal在一个线程中是共享的，在不同线程之间又是隔离的”，
     * 每个线程都只能看到自己线程的值，这也就是ThreadLocal的核心作用：实现线程范围的局部变量。
     * ————————————————
     * 版权声明：本文为CSDN博主「听到微笑」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/tianjindong0804/article/details/85597215
     */
}