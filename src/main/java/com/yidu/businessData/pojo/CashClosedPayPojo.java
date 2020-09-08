package com.yidu.businessData.pojo;

/**
 * @ClassName CashClosedPayPojo
 * @Description: TODO
 * @Author 硠君
 * @Date create in 10:04 2020/9/1
 * @Version 1.0
 **/
public class CashClosedPayPojo {
    private String cashClosedPayId;     //现金应收应付
    private String fundId;              //基金信息表Id  fund表
    private String fundName;            //基金名称
    private String accountId;           //账户信息表ID  account表
    private String accountName;         //账户名称
    private int serviceType;            //业务类型 1=“管理费”2=“托管费”3=“存款利息”4=“申购赎回款"        **
    private double amount;              //金额                                                    **
    private String dateTime;            //日期                                                    **
    private int flag;                   //资金流向 1=“流入” -1=“流出”                               **

    public CashClosedPayPojo(){}
    public CashClosedPayPojo(String cashClosedPayId, String fundId, String accountId,
                             int serviceType, double amount, String dateTime, int flag) {
        this.cashClosedPayId = cashClosedPayId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
    }

    public CashClosedPayPojo(String cashClosedPayId, String fundId, String fundName, String accountId, String accountName,
                             int serviceType, double amount, String dateTime, int flag) {
        this.cashClosedPayId = cashClosedPayId;
        this.fundId = fundId;
        this.fundName = fundName;
        this.accountId = accountId;
        this.accountName = accountName;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
    }

    public String getFundName() {
        return fundName;
    }
    public void setFundName(String fundName) {
        this.fundName = fundName;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getCashClosedPayId() {
        return cashClosedPayId;
    }
    public void setCashClosedPayId(String cashClosedPayId) {
        this.cashClosedPayId = cashClosedPayId;
    }

    public String getFundId() {
        return fundId;
    }
    public void setFundId(String fundId) {
        this.fundId = fundId;
    }

    public String getAccountId() {
        return accountId;
    }
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public int getServiceType() {
        return serviceType;
    }
    public void setServiceType(int serviceType) {
        this.serviceType = serviceType;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "CashClosedPayPojo{" +
                "cashClosedPayId='" + cashClosedPayId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", fundName='" + fundName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", accountName='" + accountName + '\'' +
                ", serviceType=" + serviceType +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", flag=" + flag +
                '}';
    }
}
