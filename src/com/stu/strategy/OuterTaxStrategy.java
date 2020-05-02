package com.stu.strategy;

/**
 * 价外税策略,负责计算外税
 */
public class OuterTaxStrategy implements TaxStrategy {
    @Override
    public double calc(long amount) {
        final double taxRate = 0.2;
        return amount * taxRate;
    }
}
