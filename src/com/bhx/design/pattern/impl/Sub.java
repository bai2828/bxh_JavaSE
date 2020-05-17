package com.bhx.design.pattern.impl;

import com.bhx.design.pattern.Operation;

public class Sub implements Operation {
    @Override
    public double getResult(double numberA, double numberB) throws Exception {
        return numberA-numberB;
    }
}
