package com.bhx.dome;

import java.lang.reflect.Method;

public class TheReflect {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        /** 详细的API使用方法参加JDK的doc文档中的java.lang.Class和java.lang.reflect.Method */

        /* 相当于你在Spring的Context中获取bean对象 */
        TheBeanClazz theBean = new TheBeanClazz();
        /* 通过获取到bean对象得到该对象的类定义 */
        Class clazz = theBean.getClass();
        /* 通过上面得到的类定义对象clazz得到指定名称和参数类型列表的方法定义 */
        Method m = clazz.getMethod("sayHello", String.class);
        /*
         * 在指定的对象（theBean）上调用符合上面方法定义的方法，
         *  并且制定方法的入口参数值列表（这个方法只有一个参数，
         * 如果是多个参数用逗号分隔）
         */
        String msg = (String) m.invoke(theBean, "床上等你");
        System.out.println("返回的结果 :" + msg);
    }

}

class TheBeanClazz {
    public String sayHello(String s) {
        System.out.println("Hello :" + s);
        return "Hello :" + s;
    }
}