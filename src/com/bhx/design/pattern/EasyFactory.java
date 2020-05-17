package com.bhx.design.pattern;

import com.bhx.design.pattern.impl.Add;
import com.bhx.design.pattern.impl.Div;
import com.bhx.design.pattern.impl.Mul;
import com.bhx.design.pattern.impl.Sub;

/**
 * 创建一个简单工厂类
 * 我们无需提供具体的子类类名，只需要提供一个字符串即可得到相应的实例对象。
 * 这样的话，当子类的类名更换或者增加子类时我们都无需修改客户端代码，
 * 只需要在简单工厂类上增加一个分支判断代码即可。
 *
 *
 * 原文链接：https://blog.csdn.net/u012156116/article/details/80857255
 *
 */
public class EasyFactory {
    // 简单工厂，根据字符串创建相应的对象
    public static Operation createOperation(String name) {
        Operation operationObj = null;
        switch (name) {
            case "+":
                operationObj = new Add();
                break;
            case "-":
                operationObj = new Sub();
                break;
            case "*":
                operationObj = new Mul();
                break;
            case "/":
                operationObj = new Div();
                break;
        }
        return operationObj;
    }

    /**
     * 这样做的优点：我们可以对创建的对象进行一些 “加工” ，而且客户端并不知道，因为工厂隐藏了这些细节。
     * 如果，没有工厂的话，那我们是不是就得自己在客户端上写这些代码，这就好比本来可以在工厂里生产的东西，
     * 拿来自己手工制作，不仅麻烦以后还不好维护。
     *
     * 但是缺点也很明显：如果需要在方法里写很多与对象创建有关的业务代码，而且需要的创建的对象还不少的话，
     * 我们要在这个简单工厂类里编写很多个方法，每个方法里都得写很多相应的业务代码，
     * 而每次增加子类或者删除子类对象的创建都需要打开这简单工厂类来进行修改。
     * 这会导致这个简单工厂类很庞大臃肿、耦合性高，而且增加、删除某个子类对象的创建都需要打开简单工厂类来进行修改代码也违反了开-闭原则。
     *
     */
}
