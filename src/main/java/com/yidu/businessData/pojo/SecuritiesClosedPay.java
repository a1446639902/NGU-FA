package com.yidu.businessData.pojo;

/**
 * @name 戴言露
 * @data 2020/9/1 am
 * 证券应收应付表
 */
public class SecuritiesClosedPay {
    private String securitiesClosedPayId;//证券应收应付Id 主键
    private String fundId;               //FK 基金信息表Id
    private String accountId;            //账户信息表ID
    private String securitiesId;         //证券信息表ID  securities表
    private int serviceType;             //业务类型 1=清算款 2=估值增值 3=债券利息
    private double amount;               //金额
    private String dateTime;             //日期
    private int flag;                    //流入1 流出-1
    public SecuritiesClosedPay(){}

    public SecuritiesClosedPay(String securitiesClosedPayId, String fundId, String accountId, String securitiesId, int serviceType, double amount, String dateTime, int flag) {
        this.securitiesClosedPayId = securitiesClosedPayId;
        this.fundId = fundId;
        this.accountId = accountId;
        this.securitiesId = securitiesId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.dateTime = dateTime;
        this.flag = flag;
    }

    public String getSecuritiesClosedPayId() {
        return securitiesClosedPayId;
    }

    public void setSecuritiesClosedPayId(String securitiesClosedPayId) {
        this.securitiesClosedPayId = securitiesClosedPayId;
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

    public String getSecuritiesId() {
        return securitiesId;
    }

    public void setSecuritiesId(String securitiesId) {
        this.securitiesId = securitiesId;
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
        return "SecuritiesClosedPay{" +
                "securitiesClosedPayId='" + securitiesClosedPayId + '\'' +
                ", fundId='" + fundId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", securitiesId='" + securitiesId + '\'' +
                ", serviceType=" + serviceType +
                ", amount=" + amount +
                ", dateTime='" + dateTime + '\'' +
                ", flag=" + flag +
                '}';
    }
}
