package com.yidu.dayDispose.pojo;

/**
 * 证券清算款的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class SecuritiesClearingAccountPojo {
    private double totalPrice;

    public SecuritiesClearingAccountPojo() {
    }

    public SecuritiesClearingAccountPojo(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "SecuritiesClearingAccountPojo{" +
                "totalPrice=" + totalPrice +
                '}';
    }
}
