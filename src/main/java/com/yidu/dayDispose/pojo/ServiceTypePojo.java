package com.yidu.dayDispose.pojo;

/**
 * 查询余额的实体类
 *
 * @author kangshao
 * @version 1.0
 * @Type:
 * @time
 **/
public class ServiceTypePojo {
    private double amount;
    private double TotalMoney;
    private String accountName;
    private String blankCardCode;

    public String getAccountName() {
        return accountName;
    }

    @Override
    public String toString() {
        return "ServiceTypePojo{" +
                "amount=" + amount +
                ", TotalMoney=" + TotalMoney +
                ", accountName='" + accountName + '\'' +
                ", blankCardCode='" + blankCardCode + '\'' +
                '}';
    }

    public double getTotalMoney() {
        return TotalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        TotalMoney = totalMoney;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getBlankCardCode() {
        return blankCardCode;
    }

    public void setBlankCardCode(String blankCardCode) {
        this.blankCardCode = blankCardCode;
    }

    public ServiceTypePojo(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
