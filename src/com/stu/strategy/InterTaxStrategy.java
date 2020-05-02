package com.stu.strategy;

/**
 * 价内税策略
 */
public class InterTaxStrategy implements TaxStrategy {


    @Override
    public double calc(long amount) {
        final double taxRate = 0.3; // 获得税率
        return amount * taxRate;
    }
}
