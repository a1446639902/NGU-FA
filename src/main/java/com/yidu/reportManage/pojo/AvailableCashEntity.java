package com.yidu.reportManage.pojo;

/**
 * 报表管理：现金头寸报表的实体类
 * date：2020/9/18
 * @Mr.Zou
 **/
public class AvailableCashEntity {

    private String accountName;
    private double cashBlance;

    public AvailableCashEntity() {
    }

    public AvailableCashEntity(String accountName, double cashBlance) {
        this.accountName = accountName;
        this.cashBlance = cashBlance;
    }

    @Override
    public String toString() {
        return "AvailableCashPositionTable{" +
                "accountName='" + accountName + '\'' +
                ", cashBlance=" + cashBlance +
                '}';
    }

    public double getCashBlance() {
        return cashBlance;
    }

    public void setCashBlance(double cashBlance) {
        this.cashBlance = cashBlance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }


}
