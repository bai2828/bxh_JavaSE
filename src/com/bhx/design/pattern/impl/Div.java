package com.bhx.design.pattern.impl;

import com.bhx.design.pattern.Operation;

public class Div implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        if (numberB == 0) {
            throw new Exception("除数不能为0！");
        }
        return numberA / numberB;
    }
}
