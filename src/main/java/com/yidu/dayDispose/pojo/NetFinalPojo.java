package com.yidu.dayDispose.pojo;

/**
 * 第二账户所有属性的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class NetFinalPojo {
    private double amount;
    public NetFinalPojo(double amount) {
        this.amount = amount;
    }

    public NetFinalPojo() {
    }

    @Override
    public String toString() {
        return "NetFinalPojo{" +
                "amount=" + amount +
                '}';
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

