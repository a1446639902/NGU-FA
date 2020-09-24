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
    private double totalMoney;
    private double totalPrice;

    @Override
    public String toString() {
        return "NetFinalPojo{" +
                "amount=" + amount +
                ", totalMoney=" + totalMoney +
                ", totalPrice=" + totalPrice +
                '}';
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public NetFinalPojo(double amount, double totalMoney) {
        this.amount = amount;
        this.totalMoney = totalMoney;
    }

    public NetFinalPojo() {
    }

    public NetFinalPojo(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}

