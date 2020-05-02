package com.stu.strategy;

//税的策略工厂
public class TaxStrategyFactory {

    public static TaxStrategy getTaxStrategy(TaxType taxType) throws Exception {
        // 当增加新的税类型时，需要修改代码，同时会增加圈复杂度
        if (taxType == TaxType.INTER) {
            return new InterTaxStrategy();
        } else if (taxType == TaxType.OUTER) {
            return new OuterTaxStrategy();
        } else {
            throw new Exception("The tax type is not supported.");
        }
    }
}
