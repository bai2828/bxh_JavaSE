package com.bhx.design.pattern.impl;

import com.bhx.design.pattern.Operation;

/**
 * 加法计算
 */
public class Add implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA + numberB;
    }
}
